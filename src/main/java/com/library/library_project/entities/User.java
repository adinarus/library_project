package com.library.library_project.entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table (name="users")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    @Column(name = "firstname")
    @Basic
    private String firstname;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Column(name = "lastname")
    @Basic
    private String lastname;

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Column(name = "username")
    @Basic
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToMany (mappedBy = "owner")
    private Collection<Book> books;

    public Collection<Book> getBooks() {
        return books;
    }

    public void setBooks(Collection<Book> books) {
        this.books = books;
    }
}