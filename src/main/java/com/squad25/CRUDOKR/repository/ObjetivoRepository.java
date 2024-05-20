package com.squad25.CRUDOKR.repository;

import com.squad25.CRUDOKR.model.Objetivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ObjetivoRepository extends JpaRepository<Objetivo, Integer> {
    @Query("select ob from Objetivo ob where ob.id = :id")
    Optional<Objetivo> findByDescricao(@Param(value = "id") Integer id);
}