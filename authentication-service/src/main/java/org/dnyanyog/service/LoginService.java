package org.dnyanyog.service;

import java.util.List;

import org.dnyanyog.dto.LoginRequest;
import org.dnyanyog.dto.LoginResponse;
import org.dnyanyog.dto.UserData;
import org.dnyanyog.repo.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class LoginService {
	
	@Autowired
	UsersRepository repo;
	public LoginResponse validate(LoginRequest request) {
		
		LoginResponse response = new LoginResponse();
		
		List<UserData> data = repo.findByUserNameAndPassword(request.getUserName(), request.getPassword());
		if(data.size()==1) {
			response.setStatus("Success");
			response.setMessage("Login successfull!!");
		}else {
			response.setStatus("Fail");
			response.setMessage("Login fail");
		}
		return response;
		

}
}
