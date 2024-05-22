package com.squad25.CRUDOKR.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.squad25.CRUDOKR.repository.AtividadeRepository;
import com.squad25.CRUDOKR.service.AtividadeService;
import com.squad25.CRUDOKR.model.Atividade;

@Service
public class AtividadeServiceImpl implements AtividadeService {

    @Autowired
    private AtividadeRepository atividadeRepository;

    public List<Atividade> listarAtividades() {
        return atividadeRepository.findAll();
    }

    public Atividade criarAtividade(Atividade atividade) {
    	  atividade.setId(atividade.getId());
    	  return atividadeRepository.save(atividade);
    	}


    public Optional<Atividade> buscarAtividade(Long id) {
        return atividadeRepository.findById(id);
    }

    public void deletarAtividade(Long id) {
        atividadeRepository.deleteById(id);
    }

    public Atividade atualizarAtividade(Long id, Atividade atividadeAtualizada) {
        return atividadeRepository.findById(id)
        		.map(atividadeExistente -> {
            atividadeExistente.setDescricao(atividadeAtualizada.getDescricao());
            atividadeExistente.setStatus(atividadeAtualizada.getStatus());
            atividadeExistente.setDataCadastro(atividadeAtualizada.getDataCadastro());
            atividadeExistente.setDataConclusao(atividadeAtualizada.getDataConclusao());
            atividadeExistente.setIdKeyResult(atividadeAtualizada.getIdKeyResult());
            atividadeExistente.setId(atividadeAtualizada.getId());
            return atividadeRepository.save(atividadeExistente);
            
        })
        		.orElse(null);
    }
}
