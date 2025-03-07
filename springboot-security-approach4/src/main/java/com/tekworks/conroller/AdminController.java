package com.tekworks.conroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

	@GetMapping("/register")
	public String registerUser() {
		return "register";
	}
}
