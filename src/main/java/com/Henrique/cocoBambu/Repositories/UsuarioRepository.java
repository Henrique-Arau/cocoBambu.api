package com.Henrique.cocoBambu.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Henrique.cocoBambu.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    
	@Query("SELECT obj FROM Usuario obj WHERE obj.categoria.id = :id_cat ORDER BY titulo ")
	List<Usuario> findAllByCategoria(@Param(value = "id_cat") Integer id_cat);
    
}
