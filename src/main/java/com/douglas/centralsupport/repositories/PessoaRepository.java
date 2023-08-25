package com.douglas.centralsupport.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.douglas.centralsupport.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{
}
