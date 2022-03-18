package com.agencia.vuelo.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agencia.vuelo.model.Origem;



@Repository
public interface OrigemRepository extends JpaRepository<Origem, Integer>{



}