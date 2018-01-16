package com.souza.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.souza.cursomc.domain.Cliente;
import com.souza.cursomc.exceptions.ObjectNotFoundException;
import com.souza.cursomc.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
	
	public Cliente find(Integer id) {		
		Cliente obj = repo.findOne(id);
		if (obj ==null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: "+ id
					+ ", Tipo: " + Cliente.class.getName());
		}
		return obj;		
	}
}
