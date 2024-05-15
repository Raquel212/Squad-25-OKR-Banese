package com.squad25.CRUDOKR.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.squad25.CRUDOKR.model.KeyResult;
import com.squad25.CRUDOKR.service.KeyResultService;

import java.util.List;

@RestController
@RequestMapping("/key-results")
public class KeyResultController {

    private final KeyResultService keyResultService;

    public KeyResultController(KeyResultService keyResultService) {
        this.keyResultService = keyResultService;
    }

    @GetMapping
    public ResponseEntity<List<KeyResult>> listarKeyResults() {
        List<KeyResult> keyResults = keyResultService.listarKeyResults();
        return new ResponseEntity<>(keyResults, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<KeyResult> getKeyResultById(@PathVariable Long id) {
        KeyResult keyResult = keyResultService.getKeyResultById(id);
        return keyResult != null ? new ResponseEntity<>(keyResult, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<KeyResult> salvarKeyResult(@RequestBody KeyResult keyResult) {
        KeyResult novoKeyResult = keyResultService.salvarKeyResult(keyResult);
        return new ResponseEntity<>(novoKeyResult, HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<KeyResult> updateKeyResult(@PathVariable Long id, @RequestBody KeyResult keyResultDetails) {
        KeyResult keyResult = keyResultService.getKeyResultById(id);
        if (keyResult == null) {
            return ResponseEntity.notFound().build();
        }

        keyResult.setTipo(keyResultDetails.getTipo());
        keyResult.setDescricao(keyResultDetails.getDescricao());
        keyResult.setStatus(keyResultDetails.getStatus());
        keyResult.setIdResponsavel(keyResultDetails.getIdResponsavel());
        keyResult.setIdObjetivo(keyResultDetails.getIdObjetivo());
        keyResult.setDataCadastro(keyResultDetails.getDataCadastro());
        keyResult.setDataConclusao(keyResultDetails.getDataConclusao());

        KeyResult updatedKeyResult = keyResultService.salvarKeyResult(keyResult);
        return ResponseEntity.ok(updatedKeyResult);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarKeyResult(@PathVariable Long id) {
        keyResultService.deletarKeyResult(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
