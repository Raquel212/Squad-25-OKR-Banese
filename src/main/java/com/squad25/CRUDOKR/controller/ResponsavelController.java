package com.squad25.CRUDOKR.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.squad25.CRUDOKR.model.Responsavel;
import com.squad25.CRUDOKR.service.impl.ResponsavelServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/responsaveis")
public class ResponsavelController {

    @Autowired
    private ResponsavelServiceImpl responsavelService;

    @GetMapping
    public ResponseEntity<List<Responsavel>> listarResponsavel() {
        List<Responsavel> responsavel = responsavelService.listarResponsavel();
        if (responsavel.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(responsavel);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Responsavel> buscarResponsavel(@PathVariable Long id) {
        Optional<Responsavel> responsavel = responsavelService.buscarResponsavel(id);
        return responsavel.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Responsavel> criarResponsavel(@RequestBody Responsavel responsavel) {
        Responsavel responsavelCriada = responsavelService.criarResponsavel(responsavel);
        return ResponseEntity.status(HttpStatus.CREATED).body(responsavelCriada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Responsavel> atualizarResponsavel(@PathVariable Long id, @RequestBody Responsavel responsavelAtualizada) {
        Responsavel responsavel = responsavelService.atualizarResponsavel(id, responsavelAtualizada);
        if (responsavel != null) {
            return ResponseEntity.ok(responsavel);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarResponsavel(@PathVariable Long id) {
        responsavelService.deletarResponsavel(id);
        return ResponseEntity.noContent().build();
    }

}
    