package pdt.Thakare_Enterprises.jwtService;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import pdt.Thakare_Enterprises.entity.Users;

@Component
public class JwtTokenService {

	public String generateToken(Users users) {
		
		Map<String, Object> claims = new HashMap<>();
		
		return  Jwts.builder().addClaims(claims).setSubject(users.getUsername()).
				setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis()+60*60*30))
				.signWith( Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS256)).compact();
		
		
			}

	
}
