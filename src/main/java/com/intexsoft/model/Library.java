package com.intexsoft.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import static jakarta.persistence.GenerationType.*;

@Entity
@Table(name = "library")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Library {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long library_id;

    @Column(nullable = false)
    private String libraryName;

    @OneToMany(mappedBy = "library", cascade = CascadeType.ALL)
    private List<Book> bookList;
}
