package com.squad25.CRUDOKR.service;

import com.squad25.CRUDOKR.model.Meta;
import com.squad25.CRUDOKR.repository.MetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MetaService {

    @Autowired
    private MetaRepository metaRepository;

    public List<Meta> findAll() {
        return metaRepository.findAll();
    }

    public Optional<Meta> findById(Long id) {
        return metaRepository.findById(id);
    }

    public Meta save(Meta meta) {
        return metaRepository.save(meta);
    }

    public void deleteById(Long id) {
        metaRepository.deleteById(id);
    }
}
