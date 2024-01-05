package com.library.library_project.ejb;

import com.library.library_project.dto.BookDto;
import com.library.library_project.dto.DtoConverter;
import com.library.library_project.entities.Book;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.logging.Logger;

@Stateless
public class BookBean {
    private static final Logger LOG = Logger.getLogger(BookBean.class.getName());
    @PersistenceContext
    EntityManager entityManager;

    public List<BookDto> findAllBooks(){
        LOG.info("findAllCars");
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
}
