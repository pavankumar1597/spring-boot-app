package com.concretepage;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AppController {
	@GetMapping("/app")
	public @ResponseBody String helloUser(Authentication authentication) {
		return "Welcome! " + authentication.getName();
	}
}
