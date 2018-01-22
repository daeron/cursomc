package com.souza.cursomc.services;

import org.springframework.mail.SimpleMailMessage;
import com.souza.cursomc.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
}