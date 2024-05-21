package com.squad25.CRUDOKR.repository;

import java.util.List;
import java.util.Optional;
import com.squad25.CRUDOKR.model.Medicao;

public interface MedicaoRepository extends JpaRepository<Medicao, Long> {

    @SuppressWarnings("null")
    List<Medicao> findAll();

    Optional<Medicao> findById(Long id);

    Medicao save(Medicao medicao);

    void deleteById(Long id);
}
