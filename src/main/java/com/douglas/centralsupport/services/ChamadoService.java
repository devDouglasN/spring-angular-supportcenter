package com.douglas.centralsupport.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douglas.centralsupport.domain.Chamado;
import com.douglas.centralsupport.domain.Cliente;
import com.douglas.centralsupport.domain.Tecnico;
import com.douglas.centralsupport.domain.dtos.ChamadoDTO;
import com.douglas.centralsupport.domain.enums.Prioridade;
import com.douglas.centralsupport.domain.enums.Status;
import com.douglas.centralsupport.repositories.ChamadoRepository;
import com.douglas.centralsupport.services.exceptions.ObjectnotFoundException;

import jakarta.validation.Valid;

@Service
public class ChamadoService {
	  
	@Autowired 
	private ChamadoRepository repository;
	
	@Autowired
	private TecnicoService tecnicoService;
	
	@Autowired
	private ClienteService clienteService;
	
	public Chamado findById(Integer id) {
		Optional<Chamado> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! ID: " + id));
	}

	public List<Chamado> findById() {
		return repository.findAll();
	}

	public Chamado create(@Valid ChamadoDTO objDTO) {
		return repository.save(newChamado(objDTO));
	}
	
	private  Chamado newChamado(ChamadoDTO obj) {
		Tecnico tecnico = tecnicoService.findById(obj.getTecnico());
		Cliente cliente = clienteService.findById(obj.getCliente());
		
		Chamado chamado = new Chamado();
		if(obj.getId() != null) {
			chamado.setId(obj.getId());
		}
		chamado.setTecnico(tecnico);
		chamado.setCliente(cliente);
		chamado.setPrioridade(Prioridade.toEnum(obj.getPrioridade()));
		chamado.setStatus(Status.toEnum(obj.getStatus()));
		chamado.setTítulo(obj.getTitulo());
		chamado.setObservaçoes(obj.getObservacoes());
		return chamado;
	}
}
