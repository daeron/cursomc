package com.souza.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.souza.cursomc.domain.Cliente;
import com.souza.cursomc.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
	
	void sendNewPasswordEmail(Cliente cliente, String newPass);
}