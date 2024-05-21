package com.squad25.CRUDOKR.service.impl;

import com.squad25.CRUDOKR.model.Meta;
import com.squad25.CRUDOKR.repository.MetaRepository;
import com.squad25.CRUDOKR.service.MetaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MetaServiceImpl implements MetaService {

    @Autowired
    private MetaRepository metaRepository;

    public List<Meta> listarMetas() {
        return metaRepository.findAll();
    }
    
    public Meta criarMeta(Meta meta) {
    	  meta.setId(meta.getId());
    	  return metaRepository.save(meta);
    	}


    public Optional<Meta> buscarMeta(Long id) {
        return metaRepository.findById(id);
    }

    public void deletarMeta(Long id) {
        metaRepository.deleteById(id);
    }
    
    public Meta atualizarMeta(Long id, Meta metaAtualizada) {
    	 return metaRepository.findById(id)
    	 	.map(metaExistente -> {
    		metaExistente.setDescricao(metaAtualizada.getDescricao());
    		metaExistente.setStatus(metaAtualizada.getStatus());
    		metaExistente.setDataCadastro(metaAtualizada.getDataCadastro());
    		metaExistente.setDataConclusao(metaAtualizada.getDataConclusao());
    		metaExistente.setIdKeyResult(metaAtualizada.getIdKeyResult());
    		metaExistente.setId(metaAtualizada.getId());
    		return metaRepository.save(metaExistente);
    	})
    	.orElse(null);
}
}
