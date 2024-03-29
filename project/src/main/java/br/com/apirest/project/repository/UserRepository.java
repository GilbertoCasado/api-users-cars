package br.com.apirest.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.apirest.project.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByLogin(String login);
	

}
