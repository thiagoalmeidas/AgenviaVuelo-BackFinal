package com.agencia.vuelo.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agencia.vuelo.model.Usuario;



@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{



}