package com.intexsoft.controller;

import com.intexsoft.dto.LibraryRequest;
import com.intexsoft.model.Library;
import com.intexsoft.service.LibraryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@AllArgsConstructor
public class LibraryController {
    private LibraryService libraryService;

    @PostMapping("/library/create")
    public ResponseEntity createLibrary(@RequestBody LibraryRequest request){
        String result = libraryService.createLibrary(request);
        if (result.equals("OK")){
            return new ResponseEntity("Successfully created!", HttpStatus.OK);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PutMapping("/library/update")
    public ResponseEntity updateBook(@RequestBody LibraryRequest request){
        String result = libraryService.updateLibrary(request);
        if (result.equals("OK")){
            return new ResponseEntity("Successfully changed!", HttpStatus.OK);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @DeleteMapping("/library/delete/{id}")
    public ResponseEntity deleteBook(@PathVariable Long id){
        String result = libraryService.deleteLibrary(id);
        if (result.equals("OK")){
            return new ResponseEntity("Successfully deleted!", HttpStatus.OK);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/library/{id}")
    public Library getLibrary(@PathVariable Long id){
        return libraryService.getLibraryById(id);
    }

    @GetMapping("/libraries")
    public List<Library> getLibraries(){
        return libraryService.getLibraries();
    }
}
