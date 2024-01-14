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
            dto.setName(user.getLastname());     //might be optional
            dto.setSurname(user.getFirstname());     //might be optional
            dto.setUsername(user.getUsername());
            dto.setEmail(user.getEmail());     //might be optional
            dto.setPassword(user.getPassword());     //might be optional
            //dto.setBooks(user.getBooks());
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
    public User fromDtoUsers(UserDto dto) {
        User user = new User();
        if (dto != null) {
            user.setId(dto.getId());
            user.setFirstname(dto.getName());     //might be optional
            user.setLastname(dto.getSurname());     //might be optional
            user.setUsername(dto.getUsername());
            user.setEmail(dto.getEmail());     //might be optional
            user.setPassword(dto.getPassword());     //might be optional
            //user.setBooks(dto.getBooks());
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
//            if(book.getOwner()!= null){
//                dto.setOwner(toDto(book.getOwner()));
//            }
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
//            if(dto.getOwner() != null) {
//                book.setOwner(fromDto(dto.getOwner()));
//            }
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
