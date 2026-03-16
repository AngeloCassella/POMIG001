package org.example.eserciziosettimana5.repositories;

import org.example.eserciziosettimana5.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
