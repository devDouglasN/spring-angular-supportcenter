package com.douglas.centralsupport.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.douglas.centralsupport.domain.Tecnico;

public interface ChamadoRepository extends JpaRepository<Tecnico, Integer>{
}
