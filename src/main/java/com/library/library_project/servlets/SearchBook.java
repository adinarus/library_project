package com.library.library_project.servlets;

import com.library.library_project.dto.BookDto;
import com.library.library_project.ejb.BookBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchBook", value = "/SearchBook")
public class SearchBook extends HttpServlet {
    @Inject
    BookBean bookBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchQuery = request.getParameter("searchQuery");
        List<BookDto> searchResults = bookBean.searchBooks(searchQuery);
        request.setAttribute("books", searchResults);
        request.getRequestDispatcher("/WEB-INF/pages/books.jsp").forward(request, response);
    }
}

