package com.library.library_project.servlets;

import com.library.library_project.ejb.UserBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "Signup", value = "/Signup")
public class Signup extends HttpServlet {

    @Inject
    UserBean userBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/signup.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstname = request.getParameter("firstName");
        String lastname = request.getParameter("lastName");
        String username = request.getParameter("userName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        userBean.createUser(firstname, lastname, username, email, password);
        response.sendRedirect(request.getContextPath() + "/Login");
    }
}
