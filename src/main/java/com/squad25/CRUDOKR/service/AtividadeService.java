package com.squad25.CRUDOKR.service;

import java.util.List;
import java.util.Optional;
import com.squad25.CRUDOKR.model.Atividade;

public interface AtividadeService {
	
	List<Atividade> listarAtividades();

    Atividade criarAtividade(Atividade atividade);
    
    Optional<Atividade> buscarAtividade(Long id);

    void deletarAtividade(Long id);

    Atividade atualizarAtividade(Long id, Atividade atividadeAtualizada);
}
