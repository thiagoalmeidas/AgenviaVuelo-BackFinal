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
import com.agencia.vuelo.model.Usuario;
import com.agencia.vuelo.repository.UsuarioRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/")
public class UsuarioController {
	@Autowired
	private UsuarioRepository usuarioRepository;

// get all usuario
	@GetMapping("/usuario")
	public List<Usuario> getAllUsuario() {
		return usuarioRepository.findAll();
	}

// get usuario by id rest api
	@GetMapping("/usuario/{id}")
	public ResponseEntity<Usuario> getUsuarioById(@PathVariable Integer id) {
		Usuario usuario = usuarioRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Usuario nao existe id :" + id));
		return ResponseEntity.ok(usuario);
	}
		
// create usuario rest api
	@PostMapping("/usuario")
	public Usuario createUsuario(@RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

// update usuario rest api
	@PutMapping("/usuario/{id}")
	public ResponseEntity<Usuario> updateUsuario(@PathVariable Integer id, @RequestBody Usuario usuarioDetails) {
		Usuario usuario = usuarioRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Usuario nao existe id :" + id));
		
		usuario.setNomeUsuario(usuarioDetails.getNomeUsuario());
		usuario.setEmailUsuario(usuarioDetails.getEmailUsuario());
		usuario.setSenhaUsuario(usuarioDetails.getSenhaUsuario());
		usuario.setTelefoneUsuario(usuarioDetails.getTelefoneUsuario());
		
		Usuario updatedUsuario = usuarioRepository.save(usuario);
		return ResponseEntity.ok(updatedUsuario);
	}

// delete usuario rest api
	@DeleteMapping("/usuario/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteUsuario(@PathVariable Integer id) {
		Usuario usuario = usuarioRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Usuario nao existe id :" + id));
		usuarioRepository.delete(usuario);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
