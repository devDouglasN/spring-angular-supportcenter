package com.douglas.centralsupport.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douglas.centralsupport.domain.Tecnico;
import com.douglas.centralsupport.services.TecnicoService;

@RestController
@RequestMapping("/tecnicos")
public class TecnicoResource {
	
	@Autowired
	private TecnicoService service;

	@GetMapping("/{id}")
	public ResponseEntity<Tecnico> findById(@PathVariable Integer id) {
		Tecnico obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
