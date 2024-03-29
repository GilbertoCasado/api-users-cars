package br.com.apirest.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.apirest.project.model.User;
import br.com.apirest.project.service.UserService;


@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
    private UserService userService;
	
	@GetMapping
    public ResponseEntity<List<User>> getAll() {
		return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getById(@PathVariable Long id) {
    	return ResponseEntity.ok(userService.getbyId(id));
    }


    @PostMapping
    public ResponseEntity add(@RequestBody User user) {
    	userService.add(user);
    	return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable  Long id, @RequestBody User user)  {
    	userService.update(id, user);
    	return ResponseEntity.ok().build();
    	
    }

    @DeleteMapping("/{id}")
    public ResponseEntity remover(@PathVariable Long id) {
    	userService.delete(id);
    	return ResponseEntity.ok().build();
    }

}
