package com.squad25.CRUDOKR.service.impl;

import com.squad25.CRUDOKR.model.Medicao;
import com.squad25.CRUDOKR.repository.MedicaoRepository;
import com.squad25.CRUDOKR.service.MedicaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicaoServiceImpl implements MedicaoService {

    @Autowired
    private MedicaoRepository medicaoRepository;

    public List<Medicao> listarMedicoes() {
        return medicaoRepository.findAll();
    }
    
    public Medicao criarMedicao(Medicao medicao) {
    	  medicao.setId(medicao.getId());
    	  return medicaoRepository.save(medicao);
    	}


    public Optional<Medicao> buscarMedicao(Long id) {
        return medicaoRepository.findById(id);
    }

    public void deletarMedicao(Long id) {
        medicaoRepository.deleteById(id);
    }
    
    public Medicao atualizarMedicao(Long id, Medicao medicaoAtualizada) {
    	 return medicaoRepository.findById(id)
    	 	.map(medicaoExistente -> {
    		medicaoExistente.setDescricao(medicaoAtualizada.getDescricao());
    		medicaoExistente.setDataCadastro(medicaoAtualizada.getDataCadastro());
    		medicaoExistente.setIdKeyResult(medicaoAtualizada.getIdKeyResult());
    		medicaoExistente.setId(medicaoAtualizada.getId());
    		medicaoExistente.setIdMeta(medicaoAtualizada.getIdMeta());
    		medicaoExistente.setDataMedicao(medicaoAtualizada.getDataMedicao());
    		medicaoExistente.setValor(medicaoAtualizada.getValor());
    		return medicaoRepository.save(medicaoExistente);
    	})
    	.orElse(null);
}
}