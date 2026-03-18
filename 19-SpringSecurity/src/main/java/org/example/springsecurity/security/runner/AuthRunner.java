package org.example.springsecurity.security.runner;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.example.springsecurity.security.entity.ERole;
import org.example.springsecurity.security.entity.Role;
import org.example.springsecurity.security.repository.RoleRepository;
import org.example.springsecurity.security.repository.UserRepository;
import org.example.springsecurity.security.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AuthRunner implements ApplicationRunner {
	
	@Autowired RoleRepository roleRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Run...");

		// Leggo nel DB se sono già presenti ruoli salvati
		List<Role> roleList = roleRepository.findAll();
		if(roleList.size() == 0) {
			// Metodo da lanciare solo la prima volta
			// Serve per inizializzare i ruoli nel DB
			setRoleDefault();
		} else {
			System.out.println(roleList);
		}
		
	}
	
	private void setRoleDefault() {
		// Creo un ruolo Admin e lo salvo nel DB
		Role admin = new Role();
		admin.setRoleName(ERole.ROLE_ADMIN);
		roleRepository.save(admin);

		// Creo un ruolo User e lo salvo nel DB
		Role user = new Role();
		user.setRoleName(ERole.ROLE_USER);
		roleRepository.save(user);

		// Creo un ruolo Moderator e lo salvo nel DB
		Role moderator = new Role();
		moderator.setRoleName(ERole.ROLE_MODERATOR);
		roleRepository.save(moderator);

	}
	
	

}
