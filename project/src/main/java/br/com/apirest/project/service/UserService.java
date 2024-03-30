package br.com.apirest.project.service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import br.com.apirest.project.dto.UserDTO;
import br.com.apirest.project.exception.FieldExistException;
import br.com.apirest.project.handlers.ErrorMessage;
import br.com.apirest.project.model.User;
import br.com.apirest.project.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
    private UserRepository userRepository;
	
	@Autowired
    private PasswordEncoder encoder;
	
	@Autowired
    private ModelMapper modelMapper;

	
	public ResponseEntity<?> add(User user) throws FieldExistException {
		if(this.userRepository.findByEmail(user.getEmail()) !=  null) throw new FieldExistException(new ErrorMessage(2, "Email already exists"));	
		if(this.userRepository.findByLogin(user.getLogin()) !=  null) throw new FieldExistException(new ErrorMessage(3, "Login already exists"));
		if(user.getFirstName() == "" || user.getLastName() == "" || user.getPhone() == "") {
	    	throw new FieldExistException(new ErrorMessage(4, "Invalid fields"));
	    }
	    if(user.getFirstName() == null || user.getLastName() == null || user.getBirthday() == null || user.getPhone() == null) {
	    	throw new FieldExistException(new ErrorMessage(5, "Missing fields"));
	    }

		user.setPassword(encoder.encode(user.getPassword()));
		userRepository.save(user);
		return ResponseEntity.ok().build();
	}

	public List<UserDTO> getAll() {
		List<User> listUser = userRepository.findAll();
		List<UserDTO> listUserDTO = new ArrayList<>();;
		for (User user : listUser) {
			listUserDTO.add(modelMapper.map(user, UserDTO.class));
		}
		return  listUserDTO;
	}
	
	public Optional<UserDTO> getbyId(Long id) {
		Optional<User> user = userRepository.findById(id);
		return user.map(u -> modelMapper.map(u, UserDTO.class));
	}
	
	public ResponseEntity<?> update(Long id, User user) throws FieldExistException {
		Optional<User> oldUserRecord = this.userRepository.findById(id);
					
		if(oldUserRecord.get().getEmail() != user.getEmail() && 
			this.userRepository.findByEmail(user.getEmail()) !=  null) 
			throw new FieldExistException(new ErrorMessage(2, "Email already exists"));	
		if(oldUserRecord.get().getLogin() != user.getLogin() && 
		    this.userRepository.findByLogin(user.getLogin()) !=  null) 
			throw new FieldExistException(new ErrorMessage(3, "Login already exists"));
		
		if(user.getFirstName() == "" || user.getLastName() == "" || user.getPhone() == "") {
	    	throw new FieldExistException(new ErrorMessage(4, "Invalid fields"));
	    }
	    if(user.getFirstName() == null || user.getLastName() == null || user.getBirthday() == null || user.getPhone() == null) {
	    	throw new FieldExistException(new ErrorMessage(5, "Missing fields"));
	    }
		user.setId(id);
		userRepository.save(user);
		return ResponseEntity.ok().build();
	}
	
	public ResponseEntity<?> delete(Long id) {
		userRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	public UserDTO me() throws FieldExistException {
		User user = this.getContextUser();
		
		if (user == null) {
			throw new FieldExistException(new ErrorMessage(6, "Invalid missing Token"));
		}
		return modelMapper.map(user, UserDTO.class);
	}
	
	private User getContextUser(){
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
