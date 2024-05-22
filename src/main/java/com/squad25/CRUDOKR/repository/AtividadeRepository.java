package com.squad25.CRUDOKR.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.squad25.CRUDOKR.model.Atividade;

@Repository
public interface AtividadeRepository extends JpaRepository<Atividade, Long> {

}
