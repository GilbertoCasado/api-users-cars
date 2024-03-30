package br.com.apirest.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.apirest.project.dto.UserDTO;
import br.com.apirest.project.exception.FieldExistException;
import br.com.apirest.project.model.User;
import br.com.apirest.project.service.UserService;

@RestController
@RequestMapping("/api/me")
public class MeController {
	
	@Autowired
    private UserService userService;
	
	@GetMapping
    public ResponseEntity<?> me() {
		try {
			return ResponseEntity.ok(userService.me());
		} catch (FieldExistException e) {

			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getErrorMessage());
		}
		
    }

}
