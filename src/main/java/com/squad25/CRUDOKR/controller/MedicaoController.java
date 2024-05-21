package com.squad25.CRUDOKR.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.squad25.CRUDOKR.model.Medicao;
import com.squad25.CRUDOKR.service.impl.MedicaoServiceImpl;
	
	@RestController
	@RequestMapping("/medicoes")
	public class MedicaoController {

	    @Autowired
	    private MedicaoServiceImpl medicaoService;

	    @GetMapping
	    public ResponseEntity<List<Medicao>> listarMedicao() {
	        List<Medicao> medicao = medicaoService.listarMedicoes();
	        if (medicao.isEmpty()) {
	        	return ResponseEntity.noContent().build();
	        } else {
	        	return ResponseEntity.ok(medicao);
	        }
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Medicao> buscarMedicao(@PathVariable Long id) {
	        Optional<Medicao> medicao = medicaoService.buscarMedicao(id);
	        return medicao.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }

	    @PostMapping
	    public ResponseEntity<Medicao> criarMeta(@RequestBody Medicao medicao) {
	    	Medicao medicaoCriada = medicaoService.criarMedicao(medicao);
	        return ResponseEntity.status(HttpStatus.CREATED).body(medicaoCriada);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Medicao> atualizarMedicao(@PathVariable Long id, @RequestBody Medicao medicaoAtualizada) {
	        Medicao medicao = medicaoService.atualizarMedicao(id, medicaoAtualizada);
	        if (medicao != null) {
	        	return ResponseEntity.ok(medicao);
	        } else {
	        	return ResponseEntity.notFound().build();
	        }
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deletarMedicao(@PathVariable Long id) {
	    	medicaoService.deletarMedicao(id);
	        return ResponseEntity.noContent().build();
	    }
	}
	
