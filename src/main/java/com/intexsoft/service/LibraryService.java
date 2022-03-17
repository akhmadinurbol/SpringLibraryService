package com.intexsoft.service;

import com.intexsoft.model.Library;
import com.intexsoft.repository.LibraryRepository;
import com.intexsoft.service.interfaces.ILibraryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LibraryService implements ILibraryService {
    private final LibraryRepository libraryRepository;

    @Override
    public Library getLibrary(Long id) {
        if (libraryRepository.findById(id).isPresent()) return libraryRepository.findById(id).get();
        else return null;
    }
}
