package com.Henrique.cocoBambu.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Henrique.cocoBambu.Repositories.UsuarioRepository;
import com.Henrique.cocoBambu.Service.exceptions.ObjectNotFoundException;
import com.Henrique.cocoBambu.domain.Categoria;
import com.Henrique.cocoBambu.domain.Usuario;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private CategoriaService categoriaService;
 
	public Usuario findById(Integer id) {
		Optional<Usuario> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
	}

	public List<Usuario> findAll(Integer id_cat) {
		categoriaService.findById(id_cat);
		return repository.findAllByCategoria(id_cat);
	}

	public Usuario update(Integer id, Usuario obj) {
		Usuario newObj = findById(id);
		updateData(newObj, obj);
		return repository.save(newObj);
	}

	private void updateData(Usuario newObj, Usuario obj) {
		newObj.setTitulo(obj.getTitulo());
		newObj.setNome_autor(obj.getNome_autor());
		newObj.setTexto(obj.getTexto());
		
	}

	public Usuario create(Integer id_cat, Usuario obj) {
		obj.setId(null);
		Categoria cat = categoriaService.findById(id_cat);
		obj.setCategoria(cat);
		return repository.save(obj);
	}

	public void delete(Integer id) {
		Usuario obj = findById(id);
		repository.delete(obj);
		
	}
}
