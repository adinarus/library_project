package servlets;

import com.library.library_project.dto.BookDto;
import com.library.library_project.ejb.BookBean;
import com.library.library_project.servlets.Books;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class BooksTest {

    @InjectMocks
    private Books booksServlet;

    @Mock
    private BookBean bookBean;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private RequestDispatcher requestDispatcher;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testDoGet() throws ServletException, IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // Arrange
        List<BookDto> bookDtos = Arrays.asList(
                new BookDto(1, "Book1", "Author1", "Genre1", 5),
                new BookDto(2, "Book2", "Author2", "Genre2", 8)
        );
        when(bookBean.findAllBooks()).thenReturn(bookDtos);
        when(request.getRequestDispatcher("/WEB-INF/pages/books.jsp")).thenReturn(requestDispatcher);

        // Use reflection to access and invoke the private method
        Method doGetMethod = Books.class.getDeclaredMethod("doGet", HttpServletRequest.class, HttpServletResponse.class);
        doGetMethod.setAccessible(true);

        // Act
        doGetMethod.invoke(booksServlet, request, response);

        // Assert
        verify(bookBean, times(1)).findAllBooks();

        verify(requestDispatcher, times(1)).forward(request, response);
    }
}