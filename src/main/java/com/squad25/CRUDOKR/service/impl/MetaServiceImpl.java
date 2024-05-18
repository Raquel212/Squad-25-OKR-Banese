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
    	return metaRepository.save(meta);
    }

    public Optional<Meta> buscarMeta(Long id) {
        return metaRepository.findById(id);
    }

    public void deletarMeta(Long id) {
        metaRepository.deleteById(id);
    }
    
    public Meta atualizarMeta(Long id, Meta metaAtualizada) {
    	Optional<Meta> metaExistente = metaRepository.findById(id);
    	if (metaExistente.isPresent()) {
    		Meta meta = metaExistente.get();
    		meta.setDescricao(metaAtualizada.getDescricao());
    		meta.setStatus(metaAtualizada.getStatus());
    		meta.setDataCadastro(metaAtualizada.getDataCadastro());
    		meta.setDataConclusao(metaAtualizada.getDataConclusao());
    		meta.setIdKeyResult(metaAtualizada.getIdKeyResult());
    		meta.setId(metaAtualizada.getid());
    		
    		metaRepository.save(meta);
    		return meta;
    	} else {
    		return null;
    	}
    }
}
