package com.squad25.CRUDOKR.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.squad25.CRUDOKR.model.Meta;
import com.squad25.CRUDOKR.service.MetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/metas")
public class MetaController {

    @Autowired
    private MetaService metaService;

    @GetMapping
    public ResponseEntity<List<Meta>> getAllMetas() {
        return ResponseEntity.ok(metaService.listarMetas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Meta> getMetaById(@PathVariable Long id) {
        Optional<Meta> meta = metaService.buscarMeta(id);
        return ResponseEntity.ok(meta.orElse(null));
    }

    @PostMapping
    public ResponseEntity<Meta> createMeta(@RequestBody Meta meta) {
    	Meta metaCriada = metaService.criarMeta(meta);
        return ResponseEntity.status(HttpStatus.CREATED).body(metaCriada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Meta> updateMeta(@PathVariable Long id, @RequestBody Meta metaAtualizada) {
        Meta meta = metaService.atualizarMeta(id, metaAtualizada);
        return ResponseEntity.ok(meta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMeta(@PathVariable Long id) {
    	metaService.deletarMeta(id);
        return ResponseEntity.noContent().build();
    }
}
