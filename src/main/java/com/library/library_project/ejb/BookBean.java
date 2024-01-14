package com.library.library_project.ejb;

import com.library.library_project.dto.BookDto;
import com.library.library_project.dto.BookPhotoDto;
import com.library.library_project.dto.DtoConverter;
import com.library.library_project.entities.Book;
import com.library.library_project.entities.BookPhoto;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
public class BookBean {
    private static final Logger LOG = Logger.getLogger(BookBean.class.getName());
    @PersistenceContext
    EntityManager entityManager;

    public List<BookDto> findAllBooks(){
        LOG.info("findAllBooks");
        try{
            TypedQuery<Book> typedQuery=entityManager.createQuery("SELECT book FROM Book book",Book.class);
            List<Book> books=typedQuery.getResultList();
            return copyBookstoDto(books);
        }
        catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public List<BookDto> copyBookstoDto(List<Book> books){
        DtoConverter converter=new DtoConverter();
        return converter.toDtoBooks(books);
    }

    public void createBook(String title,
                           String author,
                           String genre,
                           int quantity){
        LOG.info("createBook");

        Book book= new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setGenre(genre);
        book.setQuantity(quantity);

        try {
            entityManager.persist(book);
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error during book creation", e);
            throw new EJBException("Error during book creation", e);
        }
    }

    public BookDto findById(int bookId) {
        Book book = entityManager.find(Book.class, bookId);
        return new BookDto(book.getId(),book.getTitle(), book.getAuthor(), book.getGenre(), book.getQuantity());
    }

    public void updateBook(int bookId, String title, String author, String genre, int quantity) {
        LOG.info("updateBook");

        Book book=entityManager.find(Book.class,bookId);
        book.setTitle(title);
        book.setAuthor(author);
        book.setGenre(genre);
        book.setQuantity(quantity);
    }

    public void deleteBook(int bookId) {
        LOG.info("deleteBook");

        Book book = entityManager.find(Book.class, bookId);
        if (book != null) {
            entityManager.remove(book);
        } else {
            LOG.log(Level.WARNING, "Book with id {0} not found", bookId);
        }
    }

    public List<BookDto> searchBooks(String searchQuery) {
        TypedQuery<Book> query = entityManager.createQuery(
                "SELECT b FROM Book b WHERE b.title LIKE :searchQuery OR b.author LIKE :searchQuery OR b.genre LIKE :searchQuery", Book.class);
        query.setParameter("searchQuery", "%" + searchQuery + "%");
        List<Book> books = query.getResultList();
        return copyBookstoDto(books);
    }

    public void addPhotoToBook(int bookId, String filename, String fileType, byte[] fileContent) {
        LOG.info("addPhotoToCar");
        BookPhoto photo = new BookPhoto();
        photo.setFilename(filename);
        photo.setFileType(fileType);
        photo.setFileContent(fileContent);
        Book book = entityManager.find(Book.class, bookId);
        if (book.getPhoto() != null) {
            entityManager.remove(book.getPhoto());
        }
        book.setPhoto(photo);
        photo.setBook(book);
        entityManager.persist(photo);
    }
    public BookPhotoDto findPhotoByCarId(Integer bookId) {
        List<BookPhoto> photos = entityManager
                .createQuery("SELECT p FROM BookPhoto p where p.book.id = :id", BookPhoto.class)
                .setParameter("id", bookId)
                .getResultList();
        if (photos.isEmpty()) {
            return null;
        }
        BookPhoto photo = photos.get(0); // the first element
        return new BookPhotoDto(photo.getId(), photo.getFilename(), photo.getFileType(),
                photo.getFileContent());
    }
}
