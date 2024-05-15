package com.squad25.CRUDOKR.service;

import org.springframework.stereotype.Service;

import com.squad25.CRUDOKR.model.KeyResult;
import com.squad25.CRUDOKR.repository.KeyResultRepository;

import java.util.List;

@Service
public class KeyResultService {

    private final KeyResultRepository keyResultRepository;

    public KeyResultService(KeyResultRepository keyResultRepository) {
        this.keyResultRepository = keyResultRepository;
    }

    public List<KeyResult> listarKeyResults() {
        return keyResultRepository.findAll();
    }

    public KeyResult getKeyResultById(Long id) {
        return keyResultRepository.findById(id).orElse(null);
    }

    public KeyResult salvarKeyResult(KeyResult keyResult) {
        return keyResultRepository.save(keyResult);
    }

    public void deletarKeyResult(Long id) {
        keyResultRepository.deleteById(id);
    }
}
