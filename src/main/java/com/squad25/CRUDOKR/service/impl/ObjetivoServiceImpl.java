package com.squad25.CRUDOKR.service.impl;


import com.squad25.CRUDOKR.model.Objetivo;
import com.squad25.CRUDOKR.repository.ObjetivoRepository;
import com.squad25.CRUDOKR.service.ObjetivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjetivoServiceImpl extends ObjetivoService   {

    @Autowired
    private ObjetivoRepository objetivoRepository;

    @Override
    public Objetivo createObjetivo(Objetivo objetivo) {
        return objetivoRepository.save(objetivo);
    }

    @Override
    public Objetivo getObjetivo(Long id) {
        return objetivoRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Objetivo> getAllObjetivos() {
        return objetivoRepository.findAll();
    }

    @Override
    public Objetivo updateObjetivo(Objetivo objetivo) {
        return objetivoRepository.save(objetivo);
    }

    @Override
    public void deleteObjetivo(Long id) {
        objetivoRepository.deleteById(id);
    }
}