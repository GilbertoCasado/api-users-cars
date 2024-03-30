package br.com.apirest.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.apirest.project.dto.SignDTO;
import br.com.apirest.project.handlers.ErrorMessage;
import br.com.apirest.project.handlers.JwtResponse;
import br.com.apirest.project.model.User;
import br.com.apirest.project.service.JwtTokenService;

@RestController
@RequestMapping("api")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationManager am;
	
	@Autowired
	private JwtTokenService jtks;

	
	@PostMapping("/signin")
	public ResponseEntity<?> signin(@RequestBody SignDTO data) { 
		try {
	        var userPassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
	        var auth = this.am.authenticate(userPassword);
	        var token = jtks.generateToken((User)auth.getPrincipal());
	        return ResponseEntity.ok(new JwtResponse(token));
	    } catch (AuthenticationException e) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorMessage(1, "Invalid login or password"));
	    }
	}
	
	@PostMapping("/token")
	public ResponseEntity authToken(@RequestBody String data) { 
		String isValidToken =  jtks.validateToken(data);
        return ResponseEntity.ok(isValidToken);
	}
}