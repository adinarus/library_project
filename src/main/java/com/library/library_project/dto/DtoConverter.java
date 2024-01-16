package com.library.library_project.dto;

import com.library.library_project.entities.Book;
import com.library.library_project.entities.User;

import java.util.ArrayList;
import java.util.List;

public class DtoConverter{
    public UserDto toDto(User user) {
        UserDto dto = new UserDto();
        if (user != null) {
            dto.setId(user.getId());
            dto.setName(user.getLastname());
            dto.setSurname(user.getFirstname());
            dto.setUsername(user.getUsername());
            dto.setEmail(user.getEmail());
            dto.setPassword(user.getPassword());

        }
        return dto;
    }

    public List<UserDto> toDtoUsers(List<User> list) {
        List<UserDto> ret = new ArrayList<>();
        for(User u: list){
            ret.add(toDto(u));
        }
        return ret;
    }
    public User fromDto(UserDto dto) {
        User user = new User();
        if (dto != null) {
            user.setId(dto.getId());
            user.setFirstname(dto.getName());
            user.setLastname(dto.getSurname());
            user.setUsername(dto.getUsername());
            user.setEmail(dto.getEmail());
            user.setPassword(dto.getPassword());

        }
        return user;
    }

    public BookDto toDto(Book book) {
        BookDto dto = new BookDto();
        if (book != null) {
            dto.setId(book.getId());
            dto.setTitle(book.getTitle());
            dto.setAuthor(book.getAuthor());
            dto.setGenre(book.getGenre());
            dto.setQuantity(book.getQuantity());
        }
        return dto;
    }
    public Book fromDto(BookDto dto) {
        Book book = new Book();
        if (dto != null) {
            book.setId(dto.getId());
            book.setTitle(dto.getTitle());
            book.setAuthor(dto.getAuthor());
            book.setGenre(dto.getGenre());
            book.setQuantity(dto.getQuantity());
        }
        return book;
    }
    public List<BookDto> toDtoBooks(List<Book> list) {
        List<BookDto> ret = new ArrayList<>();
        for(Book b: list){
            ret.add(toDto(b));
        }
        return ret;
    }
}
