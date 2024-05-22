package com.squad25.CRUDOKR.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.squad25.CRUDOKR.model.Responsavel;

@Repository
public interface ResponsavelRepository extends JpaRepository<Responsavel, Long> {
}