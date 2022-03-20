package com.intexsoft.service;

import com.intexsoft.dto.BookRequest;
import com.intexsoft.dto.LibraryRequest;
import com.intexsoft.model.Book;
import com.intexsoft.model.Library;
import com.intexsoft.repository.BookRepository;
import com.intexsoft.repository.LibraryRepository;
import com.intexsoft.service.interfaces.IBookService;
import com.intexsoft.service.interfaces.ILibraryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LibraryService implements ILibraryService {
    private final LibraryRepository libraryRepository;
    private final BookRepository bookRepository;
    private final IBookService bookService;

    @Override
    public String createLibrary(LibraryRequest request) {
        Library library = new Library(request.getLibraryId(), request.getLibraryName(), request.getBookList());
        if (String.valueOf(library.getLibrary_id()).equals("") || library.getLibraryName().equals("")){
            return "PLEASE ENTER ID AND NAME OF LIBRARY";
        } else{
            if (libraryRepository.findById(request.getLibraryId()).isPresent() || libraryRepository.findByLibraryName(request.getLibraryName()).isPresent()){
                return "LIBRARY WITH THIS ID OR NAME ALREADY EXISTS";
            } else{
                libraryRepository.save(library);
                if (!library.getBookList().isEmpty()){
                    for (Book book : library.getBookList()){
                        BookRequest bookRequest = new BookRequest(book.getBook_id(), book.getAuthor(), book.getName(), book.getIssuedDate(), book.getIssuedTo(), library.getLibrary_id(), library.getLibraryName());
                        if (bookRepository.findById(book.getBook_id()).isPresent()){
                            bookService.updateBook(bookRequest);
                        } else if(bookRepository.findById(book.getBook_id()).isEmpty()){
                            bookService.createBook(bookRequest);
                        }
                    }
                }
            }
        }
        return "OK";
    }

    @Override
    public String updateLibrary(LibraryRequest request) {
        if (libraryRepository.findById(request.getLibraryId()).isPresent()){
            Library library = libraryRepository.findById(request.getLibraryId()).get();
            library = new Library(request.getLibraryId(), request.getLibraryName(), library.getBookList());
            libraryRepository.save(library);
            return "OK";
        } else {
            return "NOTFOUND";
        }
    }

    @Override
    public String deleteLibrary(Long id) {
        if (libraryRepository.findById(id).isPresent()){
            libraryRepository.deleteById(id);
            return "OK";
        } else {
            return "NOTFOUND";
        }
    }

    @Override
    public Library getLibraryById(Long id) {
        if (libraryRepository.findById(id).isPresent()) return libraryRepository.findById(id).get();
        else return null;
    }

    @Override
    public List<Library> getLibraries(){
        return libraryRepository.findAll();
    }
}
