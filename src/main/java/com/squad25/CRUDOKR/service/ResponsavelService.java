package com.squad25.CRUDOKR.service;

import java.util.List;
import java.util.Optional;

import com.squad25.CRUDOKR.model.Responsavel;

public interface ResponsavelService {
	
    List<Responsavel> listarResponsavel();
    
    Responsavel criarResponsavel(Responsavel responsavel);

    Optional<Responsavel> buscarResponsavel(Long id);
    
    void deletarResponsavel(Long id);
    
    Responsavel atualizarResponsavel(Long id, Responsavel responsavelAtualizada);

}