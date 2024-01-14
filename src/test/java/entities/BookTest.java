package entities;

import com.library.library_project.entities.Book;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    @Test
    public void testBookGetterSetter() {
        // Arrange
        int id = 1;
        String title = "The Great Gatsby";
        String author = "F. Scott Fitzgerald";
        String genre = "Fiction";
        int quantity = 5;

        // Act
        Book book = new Book();
        book.setId(id);
        book.setTitle(title);
        book.setAuthor(author);
        book.setGenre(genre);
        book.setQuantity(quantity);

        // Assert
        assertEquals(id, book.getId());
        assertEquals(title, book.getTitle());
        assertEquals(author, book.getAuthor());
        assertEquals(genre, book.getGenre());
        assertEquals(quantity, book.getQuantity());
    }

    @Test
    public void testBookConstructor() {
        // Arrange
        int id = 1;
        String title = "The Great Gatsby";
        String author = "F. Scott Fitzgerald";
        String genre = "Fiction";
        int quantity = 5;

        // Act
        Book book = new Book(id, title, author, genre, quantity);

        // Assert
        assertEquals(id, book.getId());
        assertEquals(title, book.getTitle());
        assertEquals(author, book.getAuthor());
        assertEquals(genre, book.getGenre());
        assertEquals(quantity, book.getQuantity());
    }

    @Test
    public void testDefaultConstructor() {
        // Act
        Book book = new Book();

        // Assert
        assertNotNull(book);
    }
}

