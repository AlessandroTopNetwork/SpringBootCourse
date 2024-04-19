package com.springbootdemo.mvc.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
	
	@NotNull(message = "is required")
	@Min(value = 1, message = "must be geater than or equels to zero")
	@Max(value = 10, message = "must be less than or equels to ten")
	private Integer codeId; // to integer to accept null value input in java
	
	// regex regola da ripsettare per accetare il valore può avere un valore da a a z
	// minusca e maiuscola e da 0 a 9 come numeri ed in fine tra graffe c'è specificato
	// la lunghezza accetata del valore ovvero in questo case 5 char non meno e neppure 
	// più di 5 carratteri ma solo 5 caratteri srano accetati in questo caso
//	@NotNull
//	@NotEmpty
	@NotNull(message = "is required 5 char")
	@Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 chars/digits")
	private String postCode;

}
