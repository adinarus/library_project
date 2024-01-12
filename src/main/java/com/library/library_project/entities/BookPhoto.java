package com.library.library_project.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "bookphoto")
public class BookPhoto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "filename")
    private String filename;

    @Column(name = "fileType")
    private String fileType;

    @Lob
    @Column(name = "fileContent")
    private byte[] fileContent;
    @OneToOne
    @JoinColumn(name = "book_id")
    Book book;

    public void setBook(Book book) {
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public byte[] getFileContent() {
        return fileContent;
    }

    public void setFileContent(byte[] fileContent) {
        this.fileContent = fileContent;
    }

    @OneToOne
    public Book getBook() { return book;}
}
