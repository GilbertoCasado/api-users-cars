package br.com.apirest.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.apirest.project.model.Car;
import br.com.apirest.project.model.User;
import br.com.apirest.project.repository.CarRepository;

@Service
public class CarService {
	
	@Autowired
    private CarRepository repository;
	
	public ResponseEntity add(Car car) {
		User user = this.getContextUser(); 
		car.setUser(user);
		car = repository.save(car);
		return ResponseEntity.ok(car);
	}

	public List<Car> getAll() {
		User user = this.getContextUser(); 
		return repository.findAllByUserId(user.getId());
	}
	
	public Optional<Car> getbyId(Long id) {
		return repository.findById(id);
	}
	
	
	public ResponseEntity update(Long id, Car car) {
		User user = this.getContextUser();
		car.setUser(user);
		car.setId(id);
		car = repository.save(car);
		return ResponseEntity.ok(car);
	}
	
	public ResponseEntity delete(Long id) {
		repository.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	private User getContextUser(){
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}
