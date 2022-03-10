package com.intexsoft.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

import static jakarta.persistence.GenerationType.*;

@Table(name = "book",
        uniqueConstraints = {
            @UniqueConstraint(name = "book_id_unique", columnNames = "id")
        }
)
@Entity(name = "Book")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @SequenceGenerator(name = "book_sequence", sequenceName = "book_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "book_sequence")
    @Column(name = "id", updatable = false)
    private Long id;
    @Column(name = "author", nullable = false)
    private String author;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "issued_date")
    private Date issuedDate;
    @Column(name = "issued_to")
    private String issuedTo;

    public Book(String author, String name, Date issuedDate, String issuedTo) {
        this.author = author;
        this.name = name;
        this.issuedDate = issuedDate;
        this.issuedTo = issuedTo;
    }
}
