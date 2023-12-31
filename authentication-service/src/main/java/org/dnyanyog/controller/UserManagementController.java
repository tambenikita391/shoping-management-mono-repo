package org.dnyanyog.controller;

import org.dnyanyog.dto.UserData;
import org.dnyanyog.dto.UserRequest;
import org.dnyanyog.dto.UserResponse;
import org.dnyanyog.service.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserManagementController {
	
	@Autowired
	UserManagementService service;
	
	@PostMapping(
			path="/api/v1/user",
			consumes= {"application/json","application/xml"},
			produces= {"application/json","application/xml"})
	public UserResponse addUser(@RequestBody UserRequest request) {
		return service.addUser(request);
	}
	
	@GetMapping("/api/v1/user/{userId}")
	public UserData getSingleUser(@PathVariable Long userId) {
		return service.getSingleUser(userId);
	}
	
	@PutMapping("/api/v1/user/{userId}")
	public UserData editUser(@PathVariable Long userId, @RequestBody UserRequest request) {
		return service.editUser(userId, request);
	}
	
	@DeleteMapping("/api/v1/user/{userId}")
	public String deleteUser(@PathVariable long userId) {
		
		return service.deleteUser(userId);
	}


}
