package br.com.apirest.project.service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import br.com.apirest.project.model.User;

@Service
public class JwtTokenService {
	
	@Value("${api.security.token.secret}")
	private String secret;
	private String issuer =  "API";
	
	public String generateToken(User user) {
		try {
			Algorithm algorithm =  Algorithm.HMAC256(secret);
			return JWT.create()
					.withIssuer(issuer)
					.withSubject(user.getLogin())
	                .withExpiresAt(LocalDateTime.now().plusHours(1).toInstant(ZoneOffset.of("-03:00")))
					.sign(algorithm);	
		}catch (JWTCreationException e) {
			throw new RuntimeException("Erro na criação do token", e);
		}

	}
	
	public String validateToken(String token) {
		try {
			Algorithm algorithm =  Algorithm.HMAC256(secret);
			return JWT.require(algorithm)
					.withIssuer(issuer)
					.build()
					.verify(token)
					.getSubject();
			
			
					
		}catch (JWTVerificationException e) {
			return "Token Invalido";
		}

	}
	
	

}
