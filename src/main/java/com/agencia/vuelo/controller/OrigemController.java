package com.agencia.vuelo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agencia.vuelo.ResourceNotFoundException;
import com.agencia.vuelo.model.Origem;
import com.agencia.vuelo.repository.OrigemRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/")
public class OrigemController {
	@Autowired
	private OrigemRepository origemRepository;

// get all origem
	@GetMapping("/origem")
	public List<Origem> getAllOrigem() {
		return origemRepository.findAll();
	}

// get origem by id rest api
	@GetMapping("/origem/{id}")
	public ResponseEntity<Origem> getOrigemById(@PathVariable Integer id) {
		Origem origem = origemRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Origem not exist with id :" + id));
		return ResponseEntity.ok(origem);
	}
		
// create origem rest api
	@PostMapping("/origem")
	public Origem createOrigem(@RequestBody Origem origem) {
		return origemRepository.save(origem);
	}

// update origem rest api
	@PutMapping("/origem/{id}")
	public ResponseEntity<Origem> updateOrigem(@PathVariable Integer id, @RequestBody Origem origemDetails) {
		Origem origem = origemRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Origem not exist with id :" + id));
		
		origem.setOrigemPais(origemDetails.getOrigemPais());
		origem.setOrigemCidade(origemDetails.getOrigemCidade());
		origem.setValor(origemDetails.getValor());
		
		Origem updatedOrigem = origemRepository.save(origem);
		return ResponseEntity.ok(updatedOrigem);
	}

// delete origem rest api
	@DeleteMapping("/origem/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteOrigem(@PathVariable Integer id) {
		Origem origem = origemRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Origem not exist with id :" + id));
		origemRepository.delete(origem);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
