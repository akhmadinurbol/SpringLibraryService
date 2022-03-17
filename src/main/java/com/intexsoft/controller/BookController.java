package com.intexsoft.controller;

import com.intexsoft.dto.BookRequest;
import com.intexsoft.model.Book;
import com.intexsoft.service.BookService;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/book")
@AllArgsConstructor
public class BookController {
    private final BookService bookService;
    @PutMapping("/create")
    public ResponseEntity createBook(@RequestBody BookRequest book){
        String result = bookService.createBook(book);
        if (result.equals("OK")){
            return new ResponseEntity("Successfully added!", HttpStatus.OK);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PutMapping("/update")
    public ResponseEntity updateBook(@RequestBody BookRequest book){
        String result = bookService.updateBook(book);
        if (result.equals("OK")){
            return new ResponseEntity("Successfully changed!", HttpStatus.OK);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteBook(@RequestParam Long id){
        String result = bookService.deleteBook(id);
        if (result.equals("OK")){
            return new ResponseEntity("Successfully deleted!", HttpStatus.OK);
        }
        return ResponseEntity.badRequest().body(result);
    }


    @GetMapping("/order")
    public ResponseEntity orderBook(@RequestBody BookRequest book) {
        String result = bookService.orderBook(book.getId(), book.getIssuedTo());
        if (result.equals("OK")){
            return new ResponseEntity("Successfully ordered!", HttpStatus.OK);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/return")
    public ResponseEntity returnBook(@RequestParam Long id) {
        String result = bookService.returnBook(id);
        if (result.equals("OK")){
            return new ResponseEntity("Successfully returned!", HttpStatus.OK);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PostMapping("/find")
    public List<BookRequest> findBooks(@RequestBody BookRequest book){
        return bookService.findBooks(book);
    }

    @PostMapping("/getAll")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }
}
