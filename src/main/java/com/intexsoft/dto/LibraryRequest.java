package com.intexsoft.dto;

import com.intexsoft.model.Book;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class LibraryRequest {
    private long libraryId;
    private String libraryName;
    private List<Book> bookList;
}
