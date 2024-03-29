package br.com.apirest.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.apirest.project.model.User;
import br.com.apirest.project.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
    private UserRepository userRepository;
	
	@Autowired
    private PasswordEncoder encoder;
	
	public ResponseEntity<?> add(User user) {
		if(this.userRepository.findByLogin(user.getLogin()) !=  null) return ResponseEntity.badRequest().build();	    
				
		user.setPassword(encoder.encode(user.getPassword()));
		userRepository.save(user);
		return ResponseEntity.ok().build();
	}

	public List<User> getAll() {
		return userRepository.findAll();
	}
	
	public Optional<User> getbyId(Long id) {
		return userRepository.findById(id);
	}
	
	
	public ResponseEntity<?> update(Long id, User user) {
		user.setId(id);
		userRepository.save(user);
		return ResponseEntity.ok().build();
	}
	
	public ResponseEntity<?> delete(Long id) {
		userRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
