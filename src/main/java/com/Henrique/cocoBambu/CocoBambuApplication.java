package com.Henrique.cocoBambu;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.Henrique.cocoBambu.Repositories.CategoriaRepository;
import com.Henrique.cocoBambu.Repositories.LivroRepository;
import com.Henrique.cocoBambu.domain.Categoria;
import com.Henrique.cocoBambu.domain.Livro;

@SpringBootApplication
public class CocoBambuApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;

	public static void main(String[] args) {
		SpringApplication.run(CocoBambuApplication.class, args);
	}
		
	
	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informatica", "Livros de ti");
		
		Livro l1 = new Livro(null, "Clean code", "Robert Martin", "Lorem ipsum", cat1);
		
		cat1.getLivros().addAll(Arrays.asList(l1));
		
		this.categoriaRepository.saveAll(Arrays.asList(cat1));
		this.livroRepository.saveAll(Arrays.asList(l1));
	}
	
}
