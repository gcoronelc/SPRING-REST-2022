package com.osinergmin.app.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

	@GetMapping("/login")
	public ModelAndView login() {
		return new ModelAndView("login");
	}

	@GetMapping({ "/", "/home" })
	public String home(Model model) {
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("usuario", user.getUsername());
		model.addAttribute("roles", user.getAuthorities().toString());

		return "home";
	}



}
