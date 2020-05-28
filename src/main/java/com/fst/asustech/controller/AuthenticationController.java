package com.fst.asustech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationController {

	@GetMapping("/login")
	public String listProduits() {
		return "authentication/login";
	}

	@GetMapping("/access-denied")
	public String accessDenied() {
		return "error/error-403";
	}
}
