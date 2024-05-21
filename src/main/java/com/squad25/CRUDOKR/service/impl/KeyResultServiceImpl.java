package com.squad25.CRUDOKR.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.squad25.CRUDOKR.model.KeyResult;
import com.squad25.CRUDOKR.repository.KeyResultRepository;
import com.squad25.CRUDOKR.service.KeyResultService;

import java.util.List;
import java.util.Optional;

@Service
public class KeyResultServiceImpl implements KeyResultService {
	
	@Autowired
    private KeyResultRepository keyResultRepository;

    public List<KeyResult> listarKeyResults() {
        return keyResultRepository.findAll();
    }
    
    public KeyResult criarKeyResult(KeyResult keyResult) {
    	  keyResult.setId(keyResult.getId());
    	  return keyResultRepository.save(keyResult);
    	}


    public Optional<KeyResult> buscarKeyResult(Long id) {
    	return keyResultRepository.findById(id);
    }
    
    public void deletarKeyResult(Long id) {
        keyResultRepository.deleteById(id);
    }
    
    public KeyResult atualizarKeyResult(Long id, KeyResult keyResultAtualizada) {
        return keyResultRepository.findById(id)
                .map(keyResultExistente -> {
                    keyResultExistente.setDescricao(keyResultAtualizada.getDescricao());
                    keyResultExistente.setStatus(keyResultAtualizada.getStatus());
                    keyResultExistente.setDataCadastro(keyResultAtualizada.getDataCadastro());
                    keyResultExistente.setDataConclusao(keyResultAtualizada.getDataConclusao());
                    keyResultExistente.setIdObjetivo(keyResultAtualizada.getIdObjetivo());
                    keyResultExistente.setIdResponsavel(keyResultAtualizada.getIdResponsavel());
                    keyResultExistente.setTipo(keyResultAtualizada.getTipo());
                    return keyResultRepository.save(keyResultExistente);
                })
                .orElse(null);
    }

}
