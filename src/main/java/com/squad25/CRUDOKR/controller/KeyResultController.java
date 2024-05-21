package com.squad25.CRUDOKR.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.squad25.CRUDOKR.model.KeyResult;
import com.squad25.CRUDOKR.service.impl.KeyResultServiceImpl;
import com.squad25.CRUDOKR.dto.KeyResultProgressDTO;
import com.squad25.CRUDOKR.dto.KeyResultAverageDTO;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/key-results")
public class KeyResultController {

    @Autowired
    private KeyResultServiceImpl keyResultService;

    @GetMapping
    public ResponseEntity<List<KeyResult>> listarKeyResults() {
        List<KeyResult> keyResults = keyResultService.listarKeyResults();
        if (keyResults.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(keyResults);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<KeyResult> buscarKeyResult(@PathVariable Long id) {
        Optional<KeyResult> keyResult = keyResultService.buscarKeyResult(id);
        return keyResult.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<KeyResult> criarKeyResult(@RequestBody KeyResult keyResult) {
        KeyResult keyResultCriada = keyResultService.criarKeyResult(keyResult);
        return ResponseEntity.status(HttpStatus.CREATED).body(keyResultCriada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<KeyResult> atualizarKeyResult(@PathVariable Long id, @RequestBody KeyResult keyResultAtualizada) {
        KeyResult keyResult = keyResultService.atualizarKeyResult(id, keyResultAtualizada);
        if (keyResult != null) {
            return ResponseEntity.ok(keyResult);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarKeyResult(@PathVariable Long id) {
        keyResultService.deletarKeyResult(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/{id}/progress")
    public ResponseEntity<KeyResultProgressDTO> getProgress(@PathVariable Long id) {
        KeyResultProgressDTO progress = keyResultService.calculateProgress(id);
        return ResponseEntity.ok(progress);
    }

    @GetMapping("/progress/average")
    public ResponseEntity<List<KeyResultAverageDTO>> getAverageProgress() {
        List<KeyResultAverageDTO> averages = keyResultService.calculateAverageProgress();
        return ResponseEntity.ok(averages);
    }

}
    
