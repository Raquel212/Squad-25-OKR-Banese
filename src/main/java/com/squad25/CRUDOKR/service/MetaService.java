package com.squad25.CRUDOKR.service;

import java.util.List;
import java.util.Optional;

import com.squad25.CRUDOKR.model.Meta;

public interface MetaService {
	
	 List<Meta> listarMetas();
	    
	 Meta criarMeta(Meta meta);

	 Optional<Meta> buscarMeta(Long id);

	 void deletarMeta(Long id);
	 
	 Meta atualizarMeta(Long id, Meta metaAtualizada);

}
