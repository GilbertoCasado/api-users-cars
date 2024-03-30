package br.com.apirest.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.apirest.project.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	
	Optional<User> findById(Long id);
	
	User findByLogin(String login);
	
	User findByEmail(String email);

}
