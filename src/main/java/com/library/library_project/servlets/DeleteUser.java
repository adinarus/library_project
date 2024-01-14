package com.library.library_project.servlets;

import com.library.library_project.dto.UserDto;
import com.library.library_project.ejb.UserBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;


@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"grup1"}))
@WebServlet(name = "DeleteUser", value = "/DeleteUser")
public class DeleteUser extends HttpServlet {
    @Inject
    UserBean userBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int userId= Integer.parseInt(request.getParameter("id"));
        UserDto user=userBean.findById(userId);
        request.setAttribute("user", user);

        request.getRequestDispatcher("/WEB-INF/pages/deleteUser.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("user_id"));
        userBean.deleteUser(userId);
        response.sendRedirect(request.getContextPath()+"/Users");
    }
}

