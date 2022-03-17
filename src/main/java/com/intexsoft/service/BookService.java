package com.intexsoft.service;

import com.intexsoft.dto.BookRequest;
import com.intexsoft.model.Book;
import com.intexsoft.model.Library;
import com.intexsoft.repository.BookRepository;
import com.intexsoft.repository.LibraryRepository;
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
    private final LibraryRepository libraryRepository;

    @Override
    public String createBook(BookRequest request) {
        Book book = new Book(request.getAuthor(), request.getName(), request.getIssuedDate(), request.getIssuedTo());
        if (libraryRepository.findById(request.getLibraryId()).isPresent()){
            Library library = libraryRepository.findById(request.getLibraryId()).get();
            book.setLibrary(library);
            bookRepository.save(book);
        } else{
            return "LIBRARY NOTFOUND";
        }
        return "OK";
    }

    @Override
    public String updateBook(BookRequest request) {
        if (bookRepository.findById(request.getId()).isPresent()){
            Book book = bookRepository.findById(request.getId()).get();
            Book updatedBook = new Book(request.getId(), request.getAuthor(), request.getName(), request.getIssuedDate(), request.getIssuedTo());
            if (libraryRepository.findById(request.getLibraryId()).isPresent()){
                Library library = libraryRepository.findById(request.getLibraryId()).get();
                book.setLibrary(library);
            }
            book = updatedBook;
            bookRepository.save(book);
            return "OK";
        } else {
            return "NOTFOUND";
        }
    }

    @Override
    public String deleteBook(Long id) {
        if (bookRepository.findById(id).isPresent()){
            bookRepository.deleteById(id);
            return "OK";
        } else {
            return "NOTFOUND";
        }
    }

    @Override
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        if (bookRepository.findById(id).isPresent()){
            return bookRepository.findById(id).get();
        } else {
            return null;
        }
    }

    @Override
    public List<BookRequest> findBooks(BookRequest request) {
        List<Book> bookList = bookRepository.findByAuthorOrName(request.getAuthor(), request.getName());
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
}
