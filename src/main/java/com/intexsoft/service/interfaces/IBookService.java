package com.intexsoft.service.interfaces;

import com.intexsoft.dto.BookRequest;

import java.util.List;

public interface IBookService {
    String orderBook(Long id, String issuedTo);
    String returnBook(Long id);
    List<BookRequest> findBooks(BookRequest book);
}
