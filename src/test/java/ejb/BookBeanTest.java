package ejb;import com.library.library_project.dto.BookDto;
import com.library.library_project.ejb.BookBean;
import com.library.library_project.entities.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class BookBeanTest {

    @InjectMocks
    private BookBean bookBean;

    @Mock
    private EntityManager entityManager;

    @Test
    public void testFindAllBooks() {
        // Arrange
        List<Book> bookList = new ArrayList<>();

        bookList.add(new Book(1, "The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 5));
        bookList.add(new Book(2, "To Kill a Mockingbird", "Harper Lee", "Drama", 8));
        bookList.add(new Book(3, "1984", "George Orwell", "Dystopian", 10));

        TypedQuery<Book> typedQuery = mock(TypedQuery.class);
        when(entityManager.createQuery("SELECT book FROM Book book", Book.class)).thenReturn(typedQuery);
        when(typedQuery.getResultList()).thenReturn(bookList);

        // Act
        List<BookDto> result = bookBean.findAllBooks();

        // Assert
        assertEquals(bookList.size(), result.size());
    }
    @Test
    public void testFindById() {
        // Arrange
        int bookId = 1;
        Book book = new Book(bookId, "The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 5);
        when(entityManager.find(Book.class, bookId)).thenReturn(book);

        // Act
        BookDto result = bookBean.findById(bookId);

        // Assert
        assertEquals(book.getId(), result.getId());
        assertEquals(book.getTitle(), result.getTitle());
        assertEquals(book.getAuthor(), result.getAuthor());
        assertEquals(book.getGenre(), result.getGenre());
        assertEquals(book.getQuantity(), result.getQuantity());
    }
}