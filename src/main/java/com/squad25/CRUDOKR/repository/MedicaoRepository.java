package com.squad25.CRUDOKR.repository;

import com.squad25.CRUDOKR.model.Medicao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicaoRepository extends JpaRepository<Medicao, Long> {
    List<Medicao> findByIdKeyResult(Long idKeyResult);
}

