package com.souza.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.souza.cursomc.domain.Categoria;
import com.souza.cursomc.domain.Cidade;
import com.souza.cursomc.domain.Cliente;
import com.souza.cursomc.domain.Endereco;
import com.souza.cursomc.domain.Estado;
import com.souza.cursomc.domain.Produto;
import com.souza.cursomc.domain.enums.TipoCliente;
import com.souza.cursomc.repositories.CategoriaRepository;
import com.souza.cursomc.repositories.CidadeRepository;
import com.souza.cursomc.repositories.ClienteRepository;
import com.souza.cursomc.repositories.EnderecoRepository;
import com.souza.cursomc.repositories.EstadoRepository;
import com.souza.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));



		
		categoriaRepository.save(Arrays.asList(cat1, cat2));
		produtoRepository.save(Arrays.asList(p1, p2, p3));
		

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "Minas Gerais", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		estadoRepository.save(Arrays.asList(est1, est2));
		cidadeRepository.save(Arrays.asList(c1, c2, c3));
		
		Cliente cli1 = new Cliente(null, "Maria Silvia", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("27363323", "87549865"));
		
		Endereco e1 = new Endereco(null, "Rua juares", "150", "Apto 1", "Flores", "32165478", cli1, c1);
		Endereco e2 = new Endereco(null, "Av matos", "150", "Apto 3", "Floçres", "32165578", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.save(Arrays.asList(cli1));
		enderecoRepository.save(Arrays.asList(e1, e2));

	}
}
