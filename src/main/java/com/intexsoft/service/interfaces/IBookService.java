package com.intexsoft.service.interfaces;

import com.intexsoft.dto.BookRequest;
import com.intexsoft.model.Book;

import java.util.List;

public interface IBookService {
    String createBook(BookRequest request);
    String updateBook(BookRequest request);
    String deleteBook(Long id);
    List<Book> getAllBooks();
    BookRequest getBookById(Long id);
    List<BookRequest> findBooksByAuthorAndName(BookRequest request);
    String orderBook(Long id, String issuedTo);
    String returnBook(Long id);
}
