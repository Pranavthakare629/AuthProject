package pdt.Thakare_Enterprises.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pdt.Thakare_Enterprises.controller.Exception.ApplicationError;
import pdt.Thakare_Enterprises.controller.dto.UserResponse;
import pdt.Thakare_Enterprises.dao.BusinessLogic;
import pdt.Thakare_Enterprises.entity.Users;
import pdt.Thakare_Enterprises.service.CustomUserDetailService;

@RestController("/home")
public class Controller {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private BusinessLogic businesslogic;
	
	@Autowired
	private CustomUserDetailService customUserDetailService;

	
	@GetMapping("/getHealth")
	public String getHealth() {
		return "OK";
	}
	
	
	@PostMapping("/signUp")
	public UserResponse signUp(@RequestBody Users user) {
		log.info("Enterd inside signUp in controller");
		UserResponse response = new UserResponse();
		ApplicationError applicationError = new ApplicationError();
		try {
			response =businesslogic.createUser(user);
			applicationError.setErrorCode("0");
			applicationError.setErrorDescription("Success");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			applicationError.setErrorCode("1");
			applicationError.setErrorDescription("failed");
			
		}
		return response;
	}
	
	@PostMapping("/login")
	public String login(@RequestBody Users users) {
		return businesslogic.verify(users);
	}
	
}
