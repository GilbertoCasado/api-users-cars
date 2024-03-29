package br.com.apirest.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.apirest.project.model.Car;

public interface CarRepository  extends JpaRepository<Car, Long> {
	
	 List<Car> findAllByUserId(Long userId);

}
