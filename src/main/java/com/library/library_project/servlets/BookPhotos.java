package com.library.library_project.servlets;

import com.library.library_project.dto.BookPhotoDto;
import com.library.library_project.ejb.BookBean;
import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "BookPhotos", value = "/BookPhotos")
public class BookPhotos extends HttpServlet {
    @Inject
    BookBean booksBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, IOException {
        Integer bookId = Integer.parseInt(request.getParameter("id"));
        BookPhotoDto photo = booksBean.findPhotoByCarId(bookId);

        if (photo != null) {
            response.setContentType(photo.getFileType());
            response.setContentLength(photo.getFileContent().length);
            response.getOutputStream().write(photo.getFileContent());
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND); // Error 404
        }
    }
}