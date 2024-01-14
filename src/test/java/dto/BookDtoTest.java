package dto;
import com.library.library_project.dto.BookDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookDtoTest {

    @Test
    void testGettersAndSetters() {
        // Arrange
        int id = 1;
        String title = "The Great Gatsby";
        String author = "F. Scott Fitzgerald";
        String genre = "Fiction";
        int quantity = 5;

        // Act
        BookDto bookDto = new BookDto();
        bookDto.setId(id);
        bookDto.setTitle(title);
        bookDto.setAuthor(author);
        bookDto.setGenre(genre);
        bookDto.setQuantity(quantity);

        // Assert
        assertEquals(id, bookDto.getId());
        assertEquals(title, bookDto.getTitle());
        assertEquals(author, bookDto.getAuthor());
        assertEquals(genre, bookDto.getGenre());
        assertEquals(quantity, bookDto.getQuantity());
    }

    @Test
    void testDefaultConstructor() {
        // Act
        BookDto bookDto = new BookDto();

        // Assert
        assertNotNull(bookDto);
    }

    @Test
    void testParameterizedConstructor() {
        // Arrange
        int id = 1;
        String title = "The Great Gatsby";
        String author = "F. Scott Fitzgerald";
        String genre = "Fiction";
        int quantity = 5;

        // Act
        BookDto bookDto = new BookDto(id, title, author, genre, quantity);

        // Assert
        assertEquals(id, bookDto.getId());
        assertEquals(title, bookDto.getTitle());
        assertEquals(author, bookDto.getAuthor());
        assertEquals(genre, bookDto.getGenre());
        assertEquals(quantity, bookDto.getQuantity());
    }
}
