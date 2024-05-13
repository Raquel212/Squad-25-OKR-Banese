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

import com.squad25.CRUDOKR.service.AtividadeService;
import com.squad25.CRUDOKR.model.Atividade;

@RestController
@RequestMapping("/atividades")
public class AtividadeController {

    @Autowired
    private AtividadeService atividadeService;

    @GetMapping
    public List<Atividade> listarAtividades() {
        return atividadeService.listarAtividades();
    }

    @PostMapping
    public ResponseEntity<Atividade> criarAtividade(@RequestBody Atividade atividade) {
        Atividade atividadeCriada = atividadeService.criarAtividade(atividade);
        return ResponseEntity.status(HttpStatus.CREATED).body(atividadeCriada);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Atividade> buscarAtividade(@PathVariable Long id) {
        Optional<Atividade> atividade = atividadeService.buscarAtividade(id);
        return atividade.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Atividade> atualizarAtividade(@PathVariable Long id, @RequestBody Atividade atividadeAtualizada) {
        Atividade atividade = atividadeService.atualizarAtividade(id, atividadeAtualizada);
        return ResponseEntity.ok(atividade);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAtividade(@PathVariable Long id) {
        atividadeService.deletarAtividade(id);
        return ResponseEntity.noContent().build();
    }
}
