package com.squad25.CRUDOKR.controller;

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
import com.squad25.CRUDOKR.service.MedicaoService;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/api/medicoes")
public class MedicaoController {

    @Autowired
    private MedicaoService service;

    @GetMapping
    public List<Medicao> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medicao> getById(@PathVariable Long id) {
        Optional<Medicao> medicao = service.findById(id);
        return medicao.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Medicao create(@RequestBody Medicao medicao) {
        return service.save(medicao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medicao> update(@PathVariable Long id, @RequestBody Medicao medicao) {
        if (!service.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        medicao.setId(id);
        return ResponseEntity.ok(service.save(medicao));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!service.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}