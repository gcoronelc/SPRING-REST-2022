package pe.edu.uni.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.uni.app.dto.OperacionesDto;
import pe.edu.uni.app.service.MateService;

@RestController
public class AppController {
	
	@Autowired
	private MateService mateService;

	@GetMapping("/saludo")
	public String saludo() {
		return "Bienvenidos al munto RESTful";
	}
	
	@GetMapping("/sumar")
	public String sumar(int n1, int n2) {
		int suma = n1 + n2;
		String texto = "Suma = " + n1 + " + " + n2 + " = " + suma;
		return texto;
	}
	
	@PostMapping("/operar")
	public OperacionesDto operar(@RequestBody OperacionesDto dto) {
		dto=mateService.procesar(dto);
		return dto;
	}
	
	@GetMapping("/analizar/{num}")
	public String analizar(@PathVariable("num") int numero) {
		String texto;
		if(numero%2==0) {
			texto = numero + " es par.";
		} else {
			texto = numero + " es impar.";
		}
		return texto;
	}
	
	@GetMapping("/mayor")
	public String mayor(int num1, int num2) {
		int mayor = mateService.mayor(num1, num2);
		String texto = "Mayor: " + mayor;
		return texto;
	}
	
}
