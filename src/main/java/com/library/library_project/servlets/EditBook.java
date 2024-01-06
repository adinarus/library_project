package com.library.library_project.servlets;

import com.library.library_project.dto.BookDto;
import com.library.library_project.ejb.BookBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"grup1"}))
@WebServlet(name = "EditBook", value = "/EditBook")
public class EditBook extends HttpServlet {
    @Inject
    BookBean bookBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int bookId= Integer.parseInt(request.getParameter("id"));
        BookDto book=bookBean.findById(bookId);
        request.setAttribute("book", book);

        request.getRequestDispatcher("/WEB-INF/pages/editBook.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title=request.getParameter("book_title");
        String author=request.getParameter("book_author");
        String genre=request.getParameter("book_genre");
        int quantity=Integer.parseInt(request.getParameter("book_quantity"));
        int bookId=Integer.parseInt(request.getParameter("book_id"));

        bookBean.updateBook(bookId, title,author,genre,quantity);
        response.sendRedirect(request.getContextPath()+"/Books");
    }
}