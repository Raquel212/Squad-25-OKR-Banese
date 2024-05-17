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
        return atividadeRepository.save(atividade);
    }

    public Optional<Atividade> buscarAtividade(Long id) {
        return atividadeRepository.findById(id);
    }

    public void deletarAtividade(Long id) {
        atividadeRepository.deleteById(id);
    }

    public Atividade atualizarAtividade(Long id, Atividade atividadeAtualizada) {
        Optional<Atividade> atividadeExistente = atividadeRepository.findById(id);
        if (atividadeExistente.isPresent()) {
            Atividade atividade = atividadeExistente.get();
            atividade.setDescricao(atividadeAtualizada.getDescricao());
            atividade.setStatus(atividadeAtualizada.getStatus());
            atividade.setDataCadastro(atividadeAtualizada.getDataCadastro());
            atividade.setDataConclusao(atividadeAtualizada.getDataConclusao());
            atividade.setIdKeyResult(atividadeAtualizada.getIdKeyResult());
            atividade.setId(atividadeAtualizada.getid());
            
            atividadeRepository.save(atividade);
            return atividade;
        } else {
            return null;
        }
    }
}
