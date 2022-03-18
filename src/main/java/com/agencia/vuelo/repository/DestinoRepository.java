package com.agencia.vuelo.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agencia.vuelo.model.Destino;



@Repository
public interface DestinoRepository extends JpaRepository<Destino, Integer>{



}