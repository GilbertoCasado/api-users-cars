package br.com.apirest.project.dto;

import java.time.LocalDate;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	
	private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private LocalDate birthday;
    private String login;
    private String password;
    private String phone;
}
