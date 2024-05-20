package com.squad25.CRUDOKR.service;

import java.util.List;
import java.util.Optional;

import com.squad25.CRUDOKR.model.Medicao;

public interface MedicaoService {

	 List<Medicao> listarMedicoes();
	    
	 Medicao criarMedicao(Medicao medicao);

	 Optional<Medicao> buscarMedicao(Long id);

	 void deletarMedicao(Long id);
	    
	 Medicao atualizarMedicao(Long id, Medicao medicaoAtualizada);
	
}
