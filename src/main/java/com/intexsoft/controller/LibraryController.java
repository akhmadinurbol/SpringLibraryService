package com.intexsoft.controller;

import com.intexsoft.dto.BookRequest;
import com.intexsoft.model.Book;
import com.intexsoft.model.Library;
import com.intexsoft.service.LibraryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/library")
@AllArgsConstructor
public class LibraryController {
    private LibraryService libraryService;

    @PostMapping("/add")
    public ResponseEntity addBook(@RequestBody BookRequest book, @RequestParam long id){
        String result = libraryService.addBook(book, id);
        if (result.equals("OK")){
            return new ResponseEntity("Successfully added!", HttpStatus.OK);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PostMapping("/get")
    public Library getLibrary(@RequestParam Long id){
        return libraryService.getLibrary(id);
    }
}
