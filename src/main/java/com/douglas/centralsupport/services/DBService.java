package com.douglas.centralsupport.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douglas.centralsupport.domain.Chamado;
import com.douglas.centralsupport.domain.Cliente;
import com.douglas.centralsupport.domain.Tecnico;
import com.douglas.centralsupport.domain.enums.Perfil;
import com.douglas.centralsupport.domain.enums.Prioridade;
import com.douglas.centralsupport.domain.enums.Status;
import com.douglas.centralsupport.repositories.ChamadoRepository;
import com.douglas.centralsupport.repositories.ClienteRepository;
import com.douglas.centralsupport.repositories.TecnicoRepository;

@Service
public class DBService {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ChamadoRepository chamadoRepository;
	
	public void instanciDB() {
		Tecnico tec1 = new Tecnico(null, "Douglas do Nascimento", "079.822.910-15", "douglasN@mail.com", "123");
		tec1.addPerfil(Perfil.ADMIN);
		
		Cliente cli1 = new Cliente(null, "Antonio Vasquez", "575.651.370-14", "Vasquez80@mail.com", "123");
		
		Chamado c1 = new Chamado(null, Prioridade.ALTA, Status.ANDAMENTO, "Chamado 01", "Primeiro chamado", tec1, cli1 );
		
		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));	
	}
}
