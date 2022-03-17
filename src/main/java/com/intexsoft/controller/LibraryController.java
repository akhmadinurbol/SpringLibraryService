package com.intexsoft.controller;

import com.intexsoft.model.Library;
import com.intexsoft.service.LibraryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/library")
@AllArgsConstructor
public class LibraryController {
    private LibraryService libraryService;

    @PostMapping("/get")
    public Library getLibrary(@RequestParam Long id){
        return libraryService.getLibrary(id);
    }
}
