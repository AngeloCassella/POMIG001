package org.example.springsecurity.security.repository;

import org.example.springsecurity.security.entity.ERole;
import org.example.springsecurity.security.entity.Role;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
	Optional<Role> findByRoleName(ERole roleName);

}
