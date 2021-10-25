package com.Henrique.cocoBambu.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Henrique.cocoBambu.Repositories.UsuarioRepository;
import com.Henrique.cocoBambu.Service.exceptions.ObjectNotFoundException;
import com.Henrique.cocoBambu.domain.Usuario;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
 
	public Usuario findById(Integer id) {
		Optional<Usuario> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
	}
}
