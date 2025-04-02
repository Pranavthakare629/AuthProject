package pdt.Thakare_Enterprises.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import pdt.Thakare_Enterprises.entity.Users;

public interface IuserRepo extends JpaRepository<Users, Integer> {

	Users findByusername(String username);

}
