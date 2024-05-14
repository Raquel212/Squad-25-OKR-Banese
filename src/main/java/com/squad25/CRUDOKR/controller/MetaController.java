package com.squad25.CRUDOKR.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.squad25.CRUDOKR.model.Meta;
import com.squad25.CRUDOKR.service.MetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/metas")
public class MetaController {

    @Autowired
    private MetaService metaService;

    @GetMapping
    public List<Meta> getAllMetas() {
        return metaService.findAll();
    }

    @GetMapping("/{id}")
    public Meta getMetaById(@PathVariable Long id) {
        return metaService.findById(id)
                .orElseThrow(() -> new RuntimeException("Meta não encontrada"));
    }

    @PostMapping
    public Meta createMeta(@RequestBody Meta meta) {
        return metaService.save(meta);
    }

    @PutMapping("/{id}")
    public Meta updateMeta(@PathVariable Long id, @RequestBody Meta meta) {
        meta.setId(id);
        return metaService.save(meta);
    }

    @DeleteMapping("/{id}")
    public void deleteMeta(@PathVariable Long id) {
        metaService.deleteById(id);
    }
}
