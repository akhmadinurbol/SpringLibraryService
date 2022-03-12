package com.intexsoft.service.interfaces;

import com.intexsoft.model.Book;

import java.util.List;

public interface IBookService {
    boolean orderBook(Long id, String issuedTo);
    boolean returnBook(Long id);
    List<Book> findBooks(Book book);
}
