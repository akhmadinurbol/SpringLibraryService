package com.intexsoft.service;

import com.intexsoft.model.Book;
import com.intexsoft.repository.BookRepository;
import com.intexsoft.service.interfaces.IBookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class BookService implements IBookService {

    private final BookRepository bookRepository;

    @Override
    public boolean returnBook(Long id) {
        if(bookRepository.findById(id).isPresent()){
            Book book = bookRepository.findById(id).get();

            if(!book.getIssuedDate().isEmpty() && !book.getIssuedTo().isEmpty()){
                book.setIssuedDate("");
                book.setIssuedTo("");
                bookRepository.save(book);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean orderBook(Long id, String issuedTo) {
        if (bookRepository.findById(id).isPresent()){
            Book book = bookRepository.findById(id).get();

            if(book.getIssuedDate().isEmpty() && book.getIssuedTo().isEmpty()){
                DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
                String date = dateFormat.format(new Date());

                book.setIssuedTo(issuedTo);
                book.setIssuedDate(date);
                bookRepository.save(book);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public List<Book> findBooks(Book book) {
        return bookRepository.findByAuthorOrName(book.getAuthor(), book.getName());
    }
}
