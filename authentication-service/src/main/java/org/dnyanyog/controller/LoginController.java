package org.dnyanyog.controller;

import org.dnyanyog.dto.LoginRequest;
import org.dnyanyog.dto.LoginResponse;
import org.dnyanyog.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	@Autowired
	LoginService loginService;
	
	@GetMapping(
			path="/auth/validate",
			consumes= {"application/json","application/xml"},
			produces= {"application/json","application/xml"})
	
	public LoginResponse validate(@RequestBody LoginRequest request) {
		return loginService.validate(request);
		
	}
	
	

}
