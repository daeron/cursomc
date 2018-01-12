package com.souza.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.souza.cursomc.domain.Pedido;
import com.souza.cursomc.exceptions.ObjectNotFoundException;
import com.souza.cursomc.repositories.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;
	
	public Pedido buscar(Integer id) {		
		Pedido obj = repo.findOne(id);
		if (obj ==null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: "+ id
					+ ", Tipo: " + Pedido.class.getName());
		}
		return obj;		
	}
}
