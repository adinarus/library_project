package com.library.library_project.servlets;

import com.library.library_project.dto.BookDto;
import com.library.library_project.ejb.BookBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "Books", value = "/Books")
public class Books extends HttpServlet {
    @Inject
    BookBean bookBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<BookDto> books=bookBean.findAllBooks();
        request.setAttribute("books",books);
        request.setAttribute("numberOfAvailableBooks",2);
        request.getRequestDispatcher("/WEB-INF/pages/books.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
