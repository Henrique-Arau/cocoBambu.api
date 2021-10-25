package com.Henrique.cocoBambu.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Henrique.cocoBambu.Repositories.CategoriaRepository;
import com.Henrique.cocoBambu.Service.exceptions.ObjectNotFoundException;
import com.Henrique.cocoBambu.domain.Categoria;
import com.Henrique.cocoBambu.dtos.CategoriaDTO;


@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repository;
	
	
	
	public Categoria findById(Integer id) {
		Optional<Categoria> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nâo encontrado! Id: " + id + ", Tipo:" + Categoria.class.getName()));
	}
	
	
	public List<Categoria> findAll() {
		return repository.findAll();
	}
	
	
	public Categoria create(Categoria obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Categoria create(Integer id, CategoriaDTO objDto) {
		Categoria obj = findById(id);
		obj.setNome(objDto.getNome());
		obj.setDescricao(objDto.getDescricao());
		return repository.save(obj);
	}

	public void delete(Integer id) {
		findById(id);
		try {
			repository.deleteById(id);
		} catch (Exception e) {
			throw new com.Henrique.cocoBambu.Service.exceptions.DataIntegrityViolationException("Categoria não pode ser deletado! Possui usuarios associado");
		}
		
	}

}
