package com.intexsoft.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.GenerationType.*;

@Entity
@Table(name = "book")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(updatable = false)
    private Long book_id;
    @Column(nullable = false)
    private String author;
    @Column(nullable = false)
    private String name;
    private String issuedDate;
    private String issuedTo;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "library_id")
    private Library library = new Library();

    public Book(String author, String name, String issuedDate, String issuedTo) {
        this.author = author;
        this.name = name;
        this.issuedDate = issuedDate;
        this.issuedTo = issuedTo;
    }
}
