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
import com.agencia.vuelo.model.Destino;
import com.agencia.vuelo.repository.DestinoRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/")
public class DestinoController {
	@Autowired
	private DestinoRepository destinoRepository;

// get all destino
	@GetMapping("/destino")
	public List<Destino> getAllDestino() {
		return destinoRepository.findAll();
	}

// get destino by id rest api
	@GetMapping("/destino/{id}")
	public ResponseEntity<Destino> getDestinoById(@PathVariable Integer id) {
		Destino destino = destinoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Destino not exist with id :" + id));
		return ResponseEntity.ok(destino);
	}
		
// create destino rest api
	@PostMapping("/destino")
	public Destino createDestino(@RequestBody Destino destino) {
		return destinoRepository.save(destino);
	}

// update destino rest api
	@PutMapping("/destino/{id}")
	public ResponseEntity<Destino> updateDestino(@PathVariable Integer id, @RequestBody Destino destinoDetails) {
		Destino destino = destinoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Destino not exist with id :" + id));
		
		destino.setDestinoPais(destinoDetails.getDestinoPais());
		destino.setDestinoCidade(destinoDetails.getDestinoCidade());
		destino.setValor(destinoDetails.getValor());
		
		Destino updatedDestino = destinoRepository.save(destino);
		return ResponseEntity.ok(updatedDestino);
	}

// delete destino rest api
	@DeleteMapping("/destino/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteDestino(@PathVariable Integer id) {
		Destino destino = destinoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Destino not exist with id :" + id));
		destinoRepository.delete(destino);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
