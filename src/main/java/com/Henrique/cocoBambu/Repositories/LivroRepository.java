package com.Henrique.cocoBambu.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Henrique.cocoBambu.domain.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer>{

}
