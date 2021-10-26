package com.Henrique.cocoBambu.Service;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Henrique.cocoBambu.Repositories.CategoriaRepository;
import com.Henrique.cocoBambu.Repositories.UsuarioRepository;
import com.Henrique.cocoBambu.domain.Categoria;
import com.Henrique.cocoBambu.domain.Usuario;

@Service
public class DBService {
	

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	
	public void instanciaBaseDeDados() {
		
		Categoria cat1 = new Categoria(null, "Informatica", "Livros de ti");
		
		Categoria cat2 = new Categoria(null, "Maria", "Cliente");
		
		Categoria cat3 = new Categoria(null, "José", "Cliente");
		
		
		Usuario l1 = new Usuario(null, "Clean code", "Robert Martin", "Lorem ipsum", cat1);
		Usuario l2 = new Usuario(null, "Nome usuario", "senha", "super Usuario", cat1);
		Usuario l3 = new Usuario(null, "Nome usuario", "senha", "super Usuario", cat2);
		Usuario l4 = new Usuario(null, "Nome usuario", "senha", "super Usuario", cat2);
		Usuario l5 = new Usuario(null, "Nome usuario", "senha", "super Usuario", cat3);
		Usuario l6 = new Usuario(null, "Nome usuario", "senha", "super Usuario", cat3);
		
		//getUsuario().addAll(Arrays.asList(l1, l2));
		//getUsuario().addAll(Arrays.asList(l3, l4, l5));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		usuarioRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5, l6));
	}


	//private List<Usuario> getUsuario() {
		// TODO Auto-generated method stub
		//return null;
	//}

}
