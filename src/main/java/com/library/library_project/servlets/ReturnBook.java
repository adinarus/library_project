package com.library.library_project.servlets;

import com.library.library_project.dto.BookDto;
import com.library.library_project.ejb.BookBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ReturnBook", value = "/ReturnBook")
public class ReturnBook extends HttpServlet {
    @Inject
    BookBean bookBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String username=request.getUserPrincipal().getName();
            int id_book= Integer.parseInt(request.getParameter("id"));
            bookBean.deleteFromMyLibrary(id_book,username);
            List<BookDto> borrowedBooks=bookBean.findBooksForMyLibrary(username);
            request.setAttribute("borrowedbooks",borrowedBooks);
            request.getRequestDispatcher("/WEB-INF/pages/myLibrary.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
