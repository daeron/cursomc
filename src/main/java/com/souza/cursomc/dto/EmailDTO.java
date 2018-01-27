package com.souza.cursomc.dto;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class EmailDTO {
	private static final long serialVersionUID = 1L;;
	private String email;
	
	
	@NotEmpty(message="Preenchimento obrigatorio")
	@Email(message="Email inválido")
	public EmailDTO() {		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}