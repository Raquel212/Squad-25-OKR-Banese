package com.squad25.CRUDOKR.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.squad25.CRUDOKR.model.KeyResult;
import com.squad25.CRUDOKR.model.Medicao;
import com.squad25.CRUDOKR.repository.KeyResultRepository;
import com.squad25.CRUDOKR.repository.MedicaoRepository;
import com.squad25.CRUDOKR.service.KeyResultService;
import com.squad25.CRUDOKR.dto.KeyResultProgressDTO;
import com.squad25.CRUDOKR.dto.KeyResultAverageDTO;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class KeyResultServiceImpl implements KeyResultService {
	
	@Autowired
    private KeyResultRepository keyResultRepository;
	
    @Autowired
    private MedicaoRepository medicaoRepository;

    @Override
    public List<KeyResult> listarKeyResults() {
        return keyResultRepository.findAll();
    }
  
    @Override
    public KeyResult criarKeyResult(KeyResult keyResult) {
    	  keyResult.setId(keyResult.getId());
    	  return keyResultRepository.save(keyResult);
    	}
    
    public Optional<KeyResult> buscarKeyResult(Long id) {
    	return keyResultRepository.findById(id);
    }
   
    @Override
    public void deletarKeyResult(Long id) {
        keyResultRepository.deleteById(id);
    }
    
    @Override
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
    
    @Override
    public KeyResultProgressDTO calculateProgress(Long keyResultId) {
        KeyResult keyResult = keyResultRepository.findById(keyResultId)
                .orElseThrow(() -> new NoSuchElementException("KeyResult not found"));
        List<Medicao> medicoes = medicaoRepository.findByIdKeyResult(keyResultId);

        double totalMedicoes = medicoes.stream().mapToDouble(medicao -> medicao.getValor()).sum();
        double progress = (totalMedicoes / keyResult.getMeta().getValor()) * 100;

        return new KeyResultProgressDTO(keyResultId, progress);
    }
    
    @Override
    public List<KeyResultAverageDTO> calculateAverageProgress() {
        List<KeyResult> keyResults = keyResultRepository.findAll();
        return keyResults.stream().map(kr -> {
            List<Medicao> medicoes = medicaoRepository.findByIdKeyResult(kr.getId());
            double totalMedicoes = medicoes.stream().mapToDouble(Medicao::getValor).sum();
            double averageProgress = totalMedicoes / medicoes.size();

            return new KeyResultAverageDTO(kr.getId(), averageProgress);
        }).collect(Collectors.toList());
    }
}
