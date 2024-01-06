package com.library.library_project.servlets;

import com.library.library_project.ejb.BookBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"grup1"}))
@WebServlet(name = "AddBook", value = "/AddBook")
public class AddBook extends HttpServlet {
    @Inject
    BookBean bookBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/addBook.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title=request.getParameter("book_title");
        String author=request.getParameter("book_author");
        String genre=request.getParameter("book_genre");
        int quantity=Integer.parseInt(request.getParameter("book_quantity"));

        bookBean.createBook(title,author,genre,quantity);
        response.sendRedirect(request.getContextPath()+"/Books");
    }
}
