package com.osinergmin.app.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.osinergmin.app.repository.RoleRepository;
import com.osinergmin.app.repository.UserRepository;

@Component
public class DemoData {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@EventListener
	public void appReady(ApplicationReadyEvent event) {
		if (roleRepository.count() == 0) {
			System.out.println("Registrando datos de demostración");
			
			// Agrega roles
			Role roleAdmin = new Role("ADMIN");
			Role roleUser = new Role("USER");
			roleRepository.save(roleAdmin);
			roleRepository.save(roleUser);
			
			// Agrega usuarios
			User userAdmin = new User("gustavo", passwordEncoder.encode("admin"), roleAdmin);
			User userReader = new User("claudia", passwordEncoder.encode("suerte"), roleUser);
			userRepository.save(userAdmin);
			userRepository.save(userReader);
			
			System.out.println("Datos de demostración registrados correctamente.");
		}
	}
}
