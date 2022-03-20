package com.intexsoft.repository;

import com.intexsoft.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LibraryRepository extends JpaRepository<Library, Long> {
    Optional<Library> findByLibraryName(String name);
}
