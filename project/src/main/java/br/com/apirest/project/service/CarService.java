package br.com.apirest.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.apirest.project.dto.CarDTO;
import br.com.apirest.project.dto.UserDTO;
import br.com.apirest.project.exception.FieldExistException;
import br.com.apirest.project.handlers.ErrorMessage;
import br.com.apirest.project.model.Car;
import br.com.apirest.project.model.User;
import br.com.apirest.project.repository.CarRepository;

@Service
public class CarService {
	
	@Autowired
    private CarRepository repository;
	
	@Autowired
    private ModelMapper modelMapper;
	
	public ResponseEntity<?> add(Car car) throws FieldExistException {
		User user = this.getContextUser(); 
		if(this.repository.findByLicensePlate(car.getLicensePlate()) !=  null) throw new FieldExistException(new ErrorMessage(3, "License plate already exists"));	
		if(car.getCarYear() == 0 || car.getColor() == "" || car.getLicensePlate() == "" || car.getModel() == "") {
	    	throw new FieldExistException(new ErrorMessage(4, "Invalid fields"));
	    }
	    if(car.getColor() == null || car.getLicensePlate() == null || car.getModel() == null) {
	    	throw new FieldExistException(new ErrorMessage(5, "Missing fields"));
	    }

		car.setUser(user);
		car = repository.save(car);
		return ResponseEntity.ok(car);
	}

	public List<CarDTO> getAll() {
		User user = this.getContextUser();
		
		List<Car> listCar = repository.findAllByUserId(user.getId());
		List<CarDTO> listCarDTO = new ArrayList<>();
		for (Car car : listCar) {
			listCarDTO.add(modelMapper.map(car, CarDTO.class));
		}
		return  listCarDTO;
	}
	
	public Optional<CarDTO> getbyId(Long id) {
		Optional<Car> car = repository.findById(id);
		return car.map(c -> modelMapper.map(c, CarDTO.class));
	}
	
	
	public ResponseEntity<?> update(Long id, Car car) throws FieldExistException {
		User user = this.getContextUser();
		if(this.repository.findByLicensePlate(car.getLicensePlate()) !=  null) throw new FieldExistException(new ErrorMessage(3, "License plate already exists"));	
		
		if(car.getCarYear() == 0 || car.getColor() == "" || car.getLicensePlate() == "" || car.getModel() == "") {
	    	throw new FieldExistException(new ErrorMessage(4, "Invalid fields"));
	    }
	    if(car.getColor() == null || car.getLicensePlate() == null || car.getModel() == null) {
	    	throw new FieldExistException(new ErrorMessage(5, "Missing fields"));
	    }
		
		
		car.setUser(user);
		car.setId(id);
		car = repository.save(car);
		return ResponseEntity.ok(car);
	}
	
	public ResponseEntity<?> delete(Long id) {
		repository.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	private User getContextUser(){
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}
