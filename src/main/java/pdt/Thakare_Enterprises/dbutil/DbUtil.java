package pdt.Thakare_Enterprises.dbutil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pdt.Thakare_Enterprises.entity.Users;
import pdt.Thakare_Enterprises.interfaces.IuserRepo;

@Component
public class DbUtil {

	@Autowired
	IuserRepo iuserRepo;
	
	

	Logger log = LoggerFactory.getLogger(this.getClass());

	public void save(Users user) {
		log.info("Enterd inside save method Dbutil");
		iuserRepo.save(user);
	}
	


}
