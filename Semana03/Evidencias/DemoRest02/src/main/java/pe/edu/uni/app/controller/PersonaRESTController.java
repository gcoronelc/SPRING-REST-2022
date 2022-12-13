package pe.edu.uni.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.uni.app.model.Persona;

@RestController
@RequestMapping("/personas")
public class PersonaRESTController {

	static List<Persona> lista = new ArrayList<Persona>();

	static {

		lista.add(new Persona("Joel", 20));
		lista.add(new Persona("Elmer", 21));
		lista.add(new Persona("Mariela", 18));
	}

	@GetMapping
	public List<Persona> buscarTodos() {
		return lista;
	}

	@PostMapping
	public ResponseEntity<Persona> insertar(@RequestBody Persona persona) {
		lista.add(persona);
		return new ResponseEntity<Persona>(persona,null,HttpStatus.CREATED);
	}
	

	
}
