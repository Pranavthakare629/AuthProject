package pdt.Thakare_Enterprises.validator;

import org.springframework.stereotype.Component;

import pdt.Thakare_Enterprises.Exception.CustomException;
import pdt.Thakare_Enterprises.entity.Users;

@Component
public class ValidationLogic {

	public void validate(Users user) throws CustomException {
		if (user.getPassword().isBlank()) {
			throw new CustomException("WSH100","Please validate feild");
		}
		
	}

}
