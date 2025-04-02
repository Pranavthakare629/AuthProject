package pdt.Thakare_Enterprises.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import pdt.Thakare_Enterprises.controller.Exception.ApplicationError;
import pdt.Thakare_Enterprises.controller.dto.UserResponse;
import pdt.Thakare_Enterprises.dbutil.DbUtil;
import pdt.Thakare_Enterprises.entity.Users;
import pdt.Thakare_Enterprises.jwtService.JwtTokenService;
import pdt.Thakare_Enterprises.validator.ValidationLogic;

@Component
public class BusinessLogic {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ValidationLogic validator;
	
	@Autowired
	private JwtTokenService jwtService;
	
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private DbUtil dbutil;

	public UserResponse createUser(Users user) {
		logger.info("Enterd inside createUser in businessLogic");
		UserResponse response = new UserResponse();
		ApplicationError ae = new ApplicationError();
		try {
			validator.validate(user);
			dbutil.save(user);
			response.setUsers(user);
			ae.setErrorCode("0");
			ae.setErrorDescription("Success");
			response.setAe(ae);
			System.out.println("Done");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			ae.setErrorCode("1");
			ae.setErrorDescription("Failed");
		}

		return response;
	}
	
public String verify(Users users) {
		
		Authentication authentication =authenticationManager.authenticate
				(new UsernamePasswordAuthenticationToken(users.getUsername(), users.getPassword()));
		
				if(authentication.isAuthenticated()){
				return jwtService.generateToken(users);
				}
		return "fails";
	}

	

}
