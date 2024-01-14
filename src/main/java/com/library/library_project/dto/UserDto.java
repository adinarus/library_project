package com.library.library_project.dto;

import com.library.library_project.entities.Book;

import java.util.Collection;

public class UserDto {
    private int id;
    private String name;
    private String surname;
    private String username;
    private String email;
    private String password;
    private Collection<Book> books;

    public UserDto(int id, String firstname, String lastname, String username, String email) {
        this.id = id;
        this.surname = firstname;
        this.name = lastname;
        this.username = username;
        this.email = email;
    }

    public UserDto() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {return username;}

    public void setUsername(String username) {this.username = username;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public Collection<Book> getBooks() {return books;}

    public void setBooks(Collection<Book> books) {this.books = books;}

}
