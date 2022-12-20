package pe.edu.uni.app.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class AppController {

	@GetMapping("/hello")
	ResponseEntity<String> hello() {
		return new ResponseEntity<>("Hello World!", HttpStatus.OK);
	}
	
	@GetMapping("/hello2")
	ResponseEntity<String> hello2() {
	    return ResponseEntity.ok("Hello World!");
	}

	@GetMapping("/age")
	ResponseEntity<String> age(@RequestParam("yearOfBirth") int yearOfBirth) {

		if (yearOfBirth>2022) {
			return new ResponseEntity<>("El año de nacimiento no puede ser futuro.", HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>("Tu edad es " + (2022 - yearOfBirth) + ".", HttpStatus.OK);
	}
	
	@GetMapping("/age2")
	ResponseEntity<String> age2(@RequestParam("yearOfBirth") int yearOfBirth) {
	    if (yearOfBirth>2022) {
	        return ResponseEntity.badRequest()
	            .body("El año de nacimiento no puede ser futuro.");
	    }
	    return ResponseEntity.status(HttpStatus.OK)
	        .body("Tu edad es " + (2022 - yearOfBirth) + ".");
	}
	
	
	@GetMapping("/customHeader")
	ResponseEntity<String> customHeader() {
	    HttpHeaders headers = new HttpHeaders();
	    headers.add("Custom-Header", "foo");
	        
	    return new ResponseEntity<>(
	      "Custom header set", headers, HttpStatus.OK);
	}
	
	@GetMapping("/customHeader2")
	ResponseEntity<String> customHeader2() {
	    return ResponseEntity.ok()
	        .header("Custom-Header", "foo")
	        .body("Custom header set");
	}
	
}
