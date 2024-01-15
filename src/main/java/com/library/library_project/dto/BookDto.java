package com.library.library_project.dto;

import com.library.library_project.entities.User;

public class BookDto {
    private int id;
    private String title;
    private String author;
    private String genre;
    private int quantity;

    private int owner;

    private String pdfUrl;


    public BookDto(int id, String title, String author, String genre, int quantity, String pdfUrl) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.quantity = quantity;
        this.pdfUrl = pdfUrl;
    }

    public BookDto() {
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {this.quantity = quantity;}

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }
}
