package org.dnyanyog.service;

import java.util.Optional;

import org.dnyanyog.dto.UserData;
import org.dnyanyog.dto.UserRequest;
import org.dnyanyog.dto.UserResponse;
import org.dnyanyog.entity.Users;
import org.dnyanyog.repo.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserManagementService {
	

	@Autowired
	UsersRepository repo;
	
	public UserResponse addUser(UserRequest request) {
		UserResponse response = new UserResponse();
		
		Users table = new Users();
		
		table.setUserName(request.getUserName());
		table.setPassword(request.getPassword());
		table.seteMail(request.geteMail());
		table.setAge(request.getAge());
		
		table = repo.save(table);//Ask repo to save the data from Users table to DB table
		
		response.setMessage("User added successfully");
		response.setStatus("Success");
		response.setUserId(table.getUserId());
		
		return response;
			
	}
	public UserData getSingleUser(Long userId) {
		Users user = repo.findById(userId).get();
		
		UserData data = new UserData();
		
		data.setStatus("Success");
		data.setMsg("user found!!");
		data.setUserName(user.getUserName());
		data.setPassword(user.getPassword());
		data.setEmail(user.geteMail());
		data.setAge(user.getAge());
		data.setUserId(user.getUserId());
		
		return data;
	}
	public UserData editUser(Long userId, UserRequest request) {
		UserData response = new UserData();
		
		Optional<Users> user = repo.findById(userId);
		
		if(user.isPresent()) {
			Users userTable = new Users();
			userTable.setUserName(request.getUserName());
			userTable.setPassword(request.getPassword());
			userTable.seteMail(request.geteMail());
			userTable.setAge(request.getAge());
			
			response.setStatus("Success");
			response.setMsg("User updated successfully!!");
			response.setUserName(userTable.getUserName());
			response.setPassword(userTable.getPassword());
			response.setEmail(userTable.geteMail());
			response.setAge(userTable.getAge());
			
			return response;
			
		}
		return null;
		
	}
	
	public String deleteUser(Long userId) {
		repo.deleteById(userId);
		return "Deleted :"+userId;
	}
	

}
