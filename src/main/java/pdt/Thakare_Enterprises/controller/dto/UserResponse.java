package pdt.Thakare_Enterprises.controller.dto;

import pdt.Thakare_Enterprises.controller.Exception.ApplicationError;
import pdt.Thakare_Enterprises.entity.Users;

public class UserResponse {
	
	private Users users;
	
	private ApplicationError ae;

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public ApplicationError getAe() {
		return ae;
	}

	public void setAe(ApplicationError ae) {
		this.ae = ae;
	}
	
	

}
