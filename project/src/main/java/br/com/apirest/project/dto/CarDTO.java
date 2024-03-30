package br.com.apirest.project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarDTO {
	private Long id;

    private Integer carYear;
    private String licensePlate;
    private String model;
    private String color;

}
