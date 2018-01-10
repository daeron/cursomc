package com.souza.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.souza.cursomc.domain.Categoria;
import com.souza.cursomc.exceptions.ObjectNotFoundException;
import com.souza.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {		
		Categoria obj = repo.findOne(id);
		if (obj ==null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: "+ id
					+ ", Tipo: " + Categoria.class.getName());
		}
		return obj;		
	}
}
