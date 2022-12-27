package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

	@GetMapping({ "/", "/home" })
	public String home(Model model) {
		model.addAttribute("titulo", "PAGINA PRINCIPAL");
		model.addAttribute("mensaje","Hola mundo");
		return "home";
	}

}