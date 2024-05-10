package com.squad25.CRUDOKR.controller;

import com.squad25.CRUDOKR.model.Objetivo;
import com.squad25.CRUDOKR.service.ObjetivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.squad25.CRUDOKR.service.ObjetivoService;

import java.util.List;

@RestController
@RequestMapping("/objetivos")
public class ObjetivoController {

    @Autowired
    private ObjetivoService objetivoService;

    @PostMapping
    public ResponseEntity<Objetivo> createObjetivo(@RequestBody Objetivo objetivo) {
        Objetivo createdObjetivo = objetivoService.createObjetivo(objetivo);
        return ResponseEntity.ok(createdObjetivo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Objetivo> getObjetivo(@PathVariable Long id) {
        Objetivo objetivo = objetivoService.getObjetivo(id);
        return ResponseEntity.ok(objetivo);
    }

    @GetMapping
    public ResponseEntity<List<Objetivo>> getAllObjetivos() {
        List<Objetivo> objetivos = objetivoService.getAllObjetivos();
        return ResponseEntity.ok(objetivos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Objetivo> updateObjetivo(@PathVariable Long id, @RequestBody Objetivo objetivo) {
        objetivo.setId(id);
        Objetivo updatedObjetivo = objetivoService.updateObjetivo(objetivo);
        return ResponseEntity.ok(updatedObjetivo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteObjetivo(@PathVariable Long id) {
        objetivoService.deleteObjetivo(id);
        return ResponseEntity.noContent().build();
    }
}
