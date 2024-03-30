package br.com.apirest.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.apirest.project.dto.UserDTO;
import br.com.apirest.project.exception.FieldExistException;
import br.com.apirest.project.handlers.ErrorMessage;
import br.com.apirest.project.model.User;
import br.com.apirest.project.service.UserService;


@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
    private UserService userService;
	
	@GetMapping
    public ResponseEntity<List<UserDTO>> getAll() {
		return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UserDTO>> getById(@PathVariable Long id) {
    	return ResponseEntity.ok(userService.getbyId(id));
    }


    @PostMapping
    public ResponseEntity<?> add(@RequestBody User user)  {
    		try {
				userService.add(user);
				return ResponseEntity.ok().build();
			} catch (FieldExistException e) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getErrorMessage());
			}
        		
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable  Long id, @RequestBody User user)  {
    	try {
			userService.update(id, user);
			return ResponseEntity.ok().build();
		} catch (FieldExistException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getErrorMessage());
		}
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable Long id) {
    	userService.delete(id);
    	return ResponseEntity.ok().build();
    }

}
