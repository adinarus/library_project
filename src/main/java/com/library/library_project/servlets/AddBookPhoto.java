package com.library.library_project.servlets;

import com.library.library_project.dto.BookDto;
import com.library.library_project.ejb.BookBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.IOException;


@MultipartConfig
@WebServlet(name = "AddBookPhoto", value = "/AddBookPhoto")
public class AddBookPhoto extends HttpServlet {
    @Inject
    BookBean booksBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int bookId = Integer.parseInt(request.getParameter("id"));
        BookDto book = booksBean.findById(bookId);
        request.setAttribute("book", book);
        request.getRequestDispatcher("/WEB-INF/pages/addBookPhoto.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int bookId = Integer.parseInt(request.getParameter("book_id"));

        Part filePart = request.getPart("file");
        String fileName = filePart.getSubmittedFileName();
        String fileType = filePart.getContentType();
        long fileSize = filePart.getSize();
        byte[] fileContent = new byte[(int) fileSize];
        filePart.getInputStream().read(fileContent);

        booksBean.addPhotoToBook(bookId, fileName, fileType, fileContent);
        response.sendRedirect(request.getContextPath() + "/Books");
    }
}