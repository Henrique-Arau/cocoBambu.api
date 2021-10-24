package com.Henrique.cocoBambu.Service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Henrique.cocoBambu.Repositories.CategoriaRepository;
import com.Henrique.cocoBambu.Repositories.LivroRepository;
import com.Henrique.cocoBambu.domain.Categoria;
import com.Henrique.cocoBambu.domain.Livro;

@Service
public class DBService {
	

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;
	
	public void instanciaBaseDeDados() {
		Categoria cat1 = new Categoria(null, "Informatica", "Livros de ti");
		Categoria cat2 = new Categoria(null, "Maria", "Cliente");
		Categoria cat3 = new Categoria(null, "José", "Cliente");
		
		
		Livro l1 = new Livro(null, "Clean code", "Robert Martin", "Lorem ipsum", cat1);
		Livro l2 = new Livro(null, "Nome usuario", "senha", "super Usuario", cat1);
		Livro l3 = new Livro(null, "Nome usuario", "senha", "super Usuario", cat2);
		Livro l4 = new Livro(null, "Nome usuario", "senha", "super Usuario", cat2);
		Livro l5 = new Livro(null, "Nome usuario", "senha", "super Usuario", cat3);
		Livro l6 = new Livro(null, "Nome usuario", "senha", "super Usuario", cat3);
		
		cat1.getLivros().addAll(Arrays.asList(l1, l2));
		cat2.getLivros().addAll(Arrays.asList(l3, l4, l5));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5, l6));
	}

}
