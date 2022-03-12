package com.intexsoft.controller;

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

    @GetMapping("/order")
    public ResponseEntity orderBook(@RequestBody Book book) {
        boolean result = bookService.orderBook(book.getId(), book.getIssuedTo());
        if (result){
            return new ResponseEntity("Successfully ordered!", HttpStatus.OK);
        }
        return ResponseEntity.badRequest().body("Bad request!");
    }

    @GetMapping("/return")
    public ResponseEntity returnBook(@RequestParam Long id) {
        boolean result = bookService.returnBook(id);
        if (result){
            return new ResponseEntity("Successfully returned!", HttpStatus.OK);
        }
        return ResponseEntity.badRequest().body("Bad request!");
    }

    @PostMapping("/find")
    public List<Book> findBooks(@RequestBody Book book){
        return bookService.findBooks(book);
    }

}
