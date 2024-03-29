package br.com.apirest.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.apirest.project.dto.SignDTO;
import br.com.apirest.project.infra.JwtResponse;
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
	public ResponseEntity<JwtResponse> signin(@RequestBody SignDTO data) { 
		var userPassword =  new UsernamePasswordAuthenticationToken(data.login(), data.password());
		
		var auth =  this.am.authenticate(userPassword);
		
		var  token  =  jtks.generateToken((User)auth.getPrincipal());
		
        return ResponseEntity.ok(new JwtResponse(token));
	}
	
	@PostMapping("/token")
	public ResponseEntity authToken(@RequestBody String data) { 
		String isValidToken =  jtks.validateToken(data);
        return ResponseEntity.ok(isValidToken);
	}
}