package com.osinergmin.app.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo")
public class DemoController {

	@GetMapping({ "/saludo" })
	@PreAuthorize("hasRole('USER')")
	public String saludo() {
		return "saludo";
	}
	
	@GetMapping("/proceso")
	@PreAuthorize("hasRole('ADMIN')")
	public String proceso() {
		return "proceso";
	}
}

