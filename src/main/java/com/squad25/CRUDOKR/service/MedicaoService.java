package com.squad25.CRUDOKR.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.squad25.CRUDOKR.model.Medicao;
import com.squad25.CRUDOKR.repository.MedicaoRepository;
import java.util.List;
import java.util.Optional;

@Service
public class MedicaoService {

    @Autowired
    private MedicaoRepository repository;

    public List<Medicao> findAll() {
        return repository.findAll();
    }

    public Optional<Medicao> findById(Long id) {
        return repository.findById(id);
    }

    public Medicao save(Medicao medicao) {
        return repository.save(medicao);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
