package com.squad25.CRUDOKR.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.squad25.CRUDOKR.model.Responsavel;
import com.squad25.CRUDOKR.repository.ResponsavelRepository;
import com.squad25.CRUDOKR.service.ResponsavelService;

import java.util.List;
import java.util.Optional;

@Service
public class ResponsavelServiceImpl implements ResponsavelService {
	
	@Autowired
    private ResponsavelRepository responsavelRepository;

    public List<Responsavel> listarResponsavel() {
        return responsavelRepository.findAll();
    }
    
    public Responsavel criarResponsavel(Responsavel responsavel) {
    	  responsavel.setId(responsavel.getId());
    	  return responsavelRepository.save(responsavel);
    	}


    public Optional<Responsavel> buscarResponsavel(Long id) {
    	return responsavelRepository.findById(id);
    }
    
    public void deletarResponsavel(Long id) {
        responsavelRepository.deleteById(id);
    }
    
    public Responsavel atualizarResponsavel(Long id, Responsavel responsavelAtualizada) {
        return responsavelRepository.findById(id)
                .map(responsavelExistente -> {
                	responsavelExistente.setNome(responsavelAtualizada.getNome());
                    responsavelExistente.setId(responsavelAtualizada.getId());
                    return responsavelRepository.save(responsavelExistente);
                })
                .orElse(null);
    }

}