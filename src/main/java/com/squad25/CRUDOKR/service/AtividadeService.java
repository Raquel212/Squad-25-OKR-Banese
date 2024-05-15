package com.squad25.CRUDOKR.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.squad25.CRUDOKR.repository.AtividadeRepository;
import com.squad25.CRUDOKR.model.Atividade;

@Service
public class AtividadeService {

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
        atividadeAtualizada.getId(id);
        return atividadeRepository.save(atividadeAtualizada);
    }
}
