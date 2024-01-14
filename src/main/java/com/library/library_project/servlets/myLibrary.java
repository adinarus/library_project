package com.library.library_project.servlets;

import com.library.library_project.dto.BookDto;
import com.library.library_project.ejb.BookBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "myLibrary", value = "/myLibrary")
public class myLibrary extends HttpServlet {
    @Inject
    BookBean bookBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getUserPrincipal().getName();
        List<BookDto> borrowedBooks=bookBean.findBooksForMyLibrary(username);
        request.setAttribute("borrowedbooks",borrowedBooks);
        request.getRequestDispatcher("/myLibrary.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
