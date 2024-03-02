package com.example.demo.security;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;

@Component
public class JwtUtils {

	private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(JwtUtils.class);
	
	public boolean validateJwt(String authToken) {
		try {
			Jwts.parser().setSigningKey(
					"myseedkodaodaodaj901j01dj0ida90dk901kdladk01ko0akdadd1k0k0kd1d1dadakzkod19kada") 
					.parseClaimsJws(authToken);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			LOG.error("ERROR AL VALIDAR EL TOKEN JWT", e);
		}
		return false;

	}

	public String getUserNameFromjwtToken(String token) {
		return Jwts.parser().setSigningKey(
				"myseedkodaodaodaj901j01dj0ida90dk901kdladk01ko0akdadd1k0k0kd1d1dadakzkod19kada")
				.parseClaimsJws(token).getBody().getSubject();
	}
}
