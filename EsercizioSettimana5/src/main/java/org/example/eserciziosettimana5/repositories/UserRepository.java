package org.example.eserciziosettimana5.repositories;

import org.example.eserciziosettimana5.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
