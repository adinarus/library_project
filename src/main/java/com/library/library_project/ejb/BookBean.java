package com.library.library_project.ejb;

import com.library.library_project.dto.BookDto;
import com.library.library_project.dto.BookPhotoDto;
import com.library.library_project.dto.DtoConverter;
import com.library.library_project.entities.Book;
import com.library.library_project.entities.BookPhoto;
import com.library.library_project.entities.BorrowedBook;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;

import java.util.ArrayList;
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
                           int quantity, String pdfUrl){
        LOG.info("createBook");

        Book book= new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setGenre(genre);
        book.setQuantity(quantity);
        book.setPdfUrl(pdfUrl);

        try {
            entityManager.persist(book);
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error during book creation", e);
            throw new EJBException("Error during book creation", e);
        }
    }

    public BookDto findById(int bookId) {
        Book book = entityManager.find(Book.class, bookId);
        return new BookDto(book.getId(),book.getTitle(), book.getAuthor(), book.getGenre(), book.getQuantity(),book.getPdfUrl());
    }

    public void updateBook(int bookId, String title, String author, String genre, int quantity, String pdfUrl) {
        LOG.info("updateBook");

        Book book=entityManager.find(Book.class,bookId);
        book.setTitle(title);
        book.setAuthor(author);
        book.setGenre(genre);
        book.setQuantity(quantity);
        book.setPdfUrl(pdfUrl);
    }

    public String deleteBook(int bookId) {
        LOG.info("deleteBook");

        // verific daca cartea este împrumutata
        Query query = entityManager.createQuery(
                "SELECT count(b) FROM BorrowedBook b WHERE b.book_id = :bookId");
        query.setParameter("bookId", bookId);

        long count = (Long) query.getSingleResult();
        if (count > 0) {
            return "Cartea este împrumutată în prezent și nu poate fi ștearsă.";
        }

        Book book = entityManager.find(Book.class, bookId);
        if (book != null) {
            entityManager.remove(book);
            return "Cartea a fost ștearsă cu succes.";
        } else {
            return "Cartea nu a fost găsită.";
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
    public BookPhotoDto findPhotoByBookId(Integer bookId) {
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

    public String borrowBook(int id,String username){
        try {
            Query check=entityManager.createQuery(
                    "select count(b) from BorrowedBook b where b.book_id=:bookId and b.user_id= (select u.id from User u where u.username= :username)");
            check.setParameter("bookId",id);
            check.setParameter("username",username);

            long existsCount= (Long) check.getSingleResult();

            if(existsCount>0){
                return "Deja ai imprumutat cartea respectiva";
            }

            BorrowedBook borrowedBooks=new BorrowedBook();
            Query query=entityManager.createQuery(
                    "select u.id from User u where u.username= :username");
            query.setParameter("username",username);

            int userId=(Integer)query.getSingleResult();
            LOG.info("Id"+userId);

            //finds the book by id and does the update query for me
            Book book = entityManager.find(Book.class, id);
            if(book.getQuantity()<=0){
                return "Nu mai sunt exemplare pentru cartea:  " + book.getTitle();
            }
            book.setQuantity(book.getQuantity()-1);
            entityManager.persist(book);


            borrowedBooks.setBook_id(id);
            borrowedBooks.setUser_id(userId);

            //persist=add
            entityManager.persist(borrowedBooks);
            return null;

        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error during insertion into borrowed_books", e);
            return "Error during book borrowing: " + e.getMessage();
        }
    }

    public List<BookDto> findBooksForMyLibrary(String username){
        try{
            Query userId= entityManager.createQuery(
                    "select u.id from User u where u.username= :username");
            userId.setParameter("username",username);
            int user_id=(Integer) userId.getSingleResult();
            Query borrowedBooksQuery=entityManager.createQuery(
                    "select borrowed from BorrowedBook borrowed where borrowed.user_id= :id_user");
            borrowedBooksQuery.setParameter("id_user",user_id);

            List<BorrowedBook> borrowedBooksList= borrowedBooksQuery.getResultList();
            List<BookDto> booksForMyLibrary= new ArrayList<>();

            for (BorrowedBook borrowedBooks:borrowedBooksList){
                int bookId=borrowedBooks.getBook_id();
                BookDto bookDto=findBookById(bookId);

                booksForMyLibrary.add(bookDto);
            }

            return booksForMyLibrary;
        }
        catch (Exception e){
            throw new EJBException(e);
        }
    }

    public BookDto findBookById(int bookId){
        try {
            Query bookQuery = entityManager.createQuery(
                    "select book from Book book where book.id= :bookId");
            bookQuery.setParameter("bookId", bookId);

            Book book = (Book) bookQuery.getSingleResult();

            return new BookDto(book.getId(), book.getTitle(), book.getAuthor(), book.getGenre(), book.getQuantity(),book.getPdfUrl());
        }
        catch (NoResultException e){
            return null;
        }
    }

    public void deleteFromMyLibrary(int id,String username){
        Query query=entityManager.createQuery(
                "select u.id from User u where u.username= :username");
        query.setParameter("username",username);

        int userId=(Integer)query.getSingleResult();

        Query delete=entityManager.createQuery(
                "delete from BorrowedBook borrowed where borrowed.book_id= :id and borrowed.user_id= :userId");
        delete.setParameter("id",id);
        delete.setParameter("userId",userId);


        try {
            delete.executeUpdate();
            //finds the book by id and does the update query for me
            Book book = entityManager.find(Book.class, id);
            book.setQuantity(book.getQuantity()+1);
            entityManager.persist(book);
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error during insertion into borrowed_books", e);
            throw new EJBException("Error during insertion into borrowed_books", e);
        }
    }
}
