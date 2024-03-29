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

import br.com.apirest.project.model.Car;
import br.com.apirest.project.service.CarService;


@RestController
@RequestMapping("/api/cars")
public class CarController {
	
	@Autowired
    private CarService carService;
	
	@GetMapping
    public ResponseEntity<List<Car>> getAll() {
		return ResponseEntity.ok(carService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Car>> getById(@PathVariable Long id) {
    	return ResponseEntity.ok(carService.getbyId(id));
    }


    @PostMapping
    public ResponseEntity add(@RequestBody Car car) {
    	return ResponseEntity.ok(carService.add(car));
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable  Long id, @RequestBody Car car)  {
    	return ResponseEntity.ok(carService.update(id, car));
    	
    }

    @DeleteMapping("/{id}")
    public ResponseEntity remover(@PathVariable Long id) {
    	carService.delete(id);
    	return ResponseEntity.ok().build();
    }

}
