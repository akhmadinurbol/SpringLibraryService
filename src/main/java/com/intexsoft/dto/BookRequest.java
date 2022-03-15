package com.intexsoft.dto;

import lombok.*;

@Data
@AllArgsConstructor
public class BookRequest {
    private Long id;
    private String author;
    private String name;
    private String issuedDate;
    private String issuedTo;
    private Long libraryId;
    private String libraryName;
}
