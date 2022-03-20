package com.intexsoft.service.interfaces;

import com.intexsoft.dto.LibraryRequest;
import com.intexsoft.model.Library;

import java.util.List;

public interface ILibraryService {
    String createLibrary(LibraryRequest request);
    String updateLibrary(LibraryRequest request);
    String deleteLibrary(Long id);
    List<Library> getLibraries();
    Library getLibraryById(Long id);
}
