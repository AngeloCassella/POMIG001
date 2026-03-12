package org.example.springwebmvc.repositories;

import org.example.springwebmvc.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAORepository extends JpaRepository<User, Long> {
    public User findByEmailAndPassword(String email, String password);
}
