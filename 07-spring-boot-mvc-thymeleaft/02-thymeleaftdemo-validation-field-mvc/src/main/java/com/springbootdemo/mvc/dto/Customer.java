package com.springbootdemo.mvc.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Customer {
	
//	@NotNull(message = "is required")
	private String firstName;

	@NotNull(message = "is required")
	@Size(min = 2, message = "is required")
	private String lastName;

}
