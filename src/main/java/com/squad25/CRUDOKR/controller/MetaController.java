package com.squad25.CRUDOKR.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.squad25.CRUDOKR.model.Meta;
import com.squad25.CRUDOKR.service.impl.MetaServiceImpl;

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
    private MetaServiceImpl metaService;

    @GetMapping
    public ResponseEntity<List<Meta>> listarMeta() {
        List<Meta> meta = metaService.listarMetas();
        if (meta.isEmpty()) {
        	return ResponseEntity.noContent().build();
        } else {
        	return ResponseEntity.ok(meta);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Meta> buscarMeta(@PathVariable Long id) {
        Optional<Meta> meta = metaService.buscarMeta(id);
        return meta.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Meta> criarMeta(@RequestBody Meta meta) {
    	Meta metaCriada = metaService.criarMeta(meta);
        return ResponseEntity.status(HttpStatus.CREATED).body(metaCriada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Meta> atualizarMeta(@PathVariable Long id, @RequestBody Meta metaAtualizada) {
        Meta meta = metaService.atualizarMeta(id, metaAtualizada);
        if (meta != null) {
        	return ResponseEntity.ok(meta);
        } else {
        	return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMeta(@PathVariable Long id) {
    	metaService.deletarMeta(id);
        return ResponseEntity.noContent().build();
    }
}
