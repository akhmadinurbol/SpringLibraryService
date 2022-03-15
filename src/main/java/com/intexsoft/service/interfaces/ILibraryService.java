package com.intexsoft.service.interfaces;

import com.intexsoft.dto.BookRequest;
import com.intexsoft.model.Library;

public interface ILibraryService {
    String addBook(BookRequest newBook, long id);
    Library getLibrary(Long id);
}
