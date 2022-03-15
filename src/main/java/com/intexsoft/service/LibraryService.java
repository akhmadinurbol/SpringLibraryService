package com.intexsoft.service;

import com.intexsoft.dto.BookRequest;
import com.intexsoft.model.Book;
import com.intexsoft.model.Library;
import com.intexsoft.repository.BookRepository;
import com.intexsoft.repository.LibraryRepository;
import com.intexsoft.service.interfaces.ILibraryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LibraryService implements ILibraryService {
    LibraryRepository libraryRepository;
    BookRepository bookRepository;

    @Override
    public String addBook(BookRequest request, long id) {
        Book book = new Book(request.getAuthor(), request.getName(), request.getIssuedDate(), request.getIssuedTo());
        if (libraryRepository.findById(id).isPresent()){
            Library library = libraryRepository.findById(id).get();
            library.setLibraryList(List.of(book));
            libraryRepository.findById(id);
        } else{
            return "LIBRARY NOTFOUND";
        }
        return "OK";
    }

    @Override
    public Library getLibrary(Long id) {
        if (libraryRepository.findById(id).isPresent()) return libraryRepository.findById(id).get();
        else return null;
    }
}
