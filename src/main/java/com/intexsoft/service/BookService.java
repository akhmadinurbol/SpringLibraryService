package com.intexsoft.service;

import com.intexsoft.dto.BookRequest;
import com.intexsoft.model.Book;
import com.intexsoft.repository.BookRepository;
import com.intexsoft.service.interfaces.IBookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class BookService implements IBookService {

    private final BookRepository bookRepository;

    @Override
    public String returnBook(Long id) {
        if(bookRepository.findById(id).isPresent()){
            Book book = bookRepository.findById(id).get();

            if(!book.getIssuedDate().isEmpty() && !book.getIssuedTo().isEmpty()){
                book.setIssuedDate("");
                book.setIssuedTo("");
                bookRepository.save(book);
                return "OK";
            } else {
                return "ALREADYRETURNED";
            }
        } else {
            return "NOTFOUND";
        }
    }

    @Override
    public String orderBook(Long id, String issuedTo) {
        if (bookRepository.findById(id).isPresent()){
            Book book = bookRepository.findById(id).get();

            if(book.getIssuedDate().isEmpty() && book.getIssuedTo().isEmpty()){
                DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
                String date = dateFormat.format(new Date());

                book.setIssuedTo(issuedTo);
                book.setIssuedDate(date);
                bookRepository.save(book);
                return "OK";
            } else {
                return "RESERVED";
            }
        } else {
            return "NOTFOUND";
        }
    }

    @Override
    public List<BookRequest> findBooks(BookRequest bookRequest) {
        List<Book> bookList = bookRepository.findByAuthorOrName(bookRequest.getAuthor(), bookRequest.getName());
        List<BookRequest> bookRequestList = new ArrayList<>();
        for (Book book : bookList){
            BookRequest newBook = new BookRequest(
                    book.getId(),
                    book.getAuthor(),
                    book.getName(),
                    book.getIssuedDate(),
                    book.getIssuedTo(),
                    book.getLibrary().getLibrary_id(),
                    book.getLibrary().getLibraryName()
            );
            bookRequestList.add(newBook);
        }
        return bookRequestList;
    }
}
