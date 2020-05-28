package com.fst.asustech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationController {

	@GetMapping("/login")
	public String listProduits() {
		return "dashboard/authentication/login";
	}

	@GetMapping("/access-denied")
	public String accessDenied() {
		return "dashboard/error/error-403";
	}
}
