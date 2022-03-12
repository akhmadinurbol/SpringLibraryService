package com.intexsoft.model;


import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.GenerationType.*;

@Table
@Entity(name = "Book")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(updatable = false)
    private Long id;
    @Column(nullable = false)
    private String author;
    @Column(nullable = false)
    private String name;
    private String issuedDate;
    private String issuedTo;
    private String library;
}
