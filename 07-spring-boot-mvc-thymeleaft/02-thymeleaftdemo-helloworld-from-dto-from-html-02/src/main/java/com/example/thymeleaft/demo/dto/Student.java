package com.example.thymeleaft.demo.dto;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class Student {
	
	private String name, surName, age, favoriteLanguage, country; // favoriteSystem
	
	private List<String> favoriteSystem;

}
