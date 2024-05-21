package com.squad25.CRUDOKR.service;

import java.util.List;
import java.util.Optional;

import com.squad25.CRUDOKR.dto.KeyResultAverageDTO;
import com.squad25.CRUDOKR.dto.KeyResultProgressDTO;
import com.squad25.CRUDOKR.model.KeyResult;

public interface KeyResultService {
	
    public List<KeyResult> listarKeyResults();
    
    public KeyResult criarKeyResult(KeyResult keyResult);

    public Optional<KeyResult> buscarKeyResult(Long id);
    
    public void deletarKeyResult(Long id);
    
    public KeyResult atualizarKeyResult(Long id, KeyResult keyResultAtualizada);
    
    public KeyResultProgressDTO calculateProgress(Long keyResultId);
    
    public List<KeyResultAverageDTO> calculateAverageProgress();
}
