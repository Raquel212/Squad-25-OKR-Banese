package com.squad25.CRUDOKR.service.impl;


import com.squad25.CRUDOKR.model.Objetivo;
import com.squad25.CRUDOKR.repository.ObjetivoRepository;
import com.squad25.CRUDOKR.service.ObjetivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ObjetivoServiceImpl implements ObjetivoService   {

    @Autowired
    private ObjetivoRepository objetivoRepository;

    @Override
    public Objetivo createObjetivo(Objetivo objetivo) {
        Optional<Objetivo> obj = objetivoRepository.findByDescricao(objetivo.getId());
        if (obj.isPresent())
            return null;
        return objetivoRepository.save(objetivo);
    }

    @Override
    public Objetivo getObjetivo(Integer id) {
        return objetivoRepository.findById(id).orElseThrow(() -> new RuntimeException("Objetivo não encontrado"));
    }

    @Override
    public List<Objetivo> getAllObjetivos() {
        return objetivoRepository.findAll();
    }

    @Override
    public Objetivo updateObjetivo(Objetivo objetivo) {
        Optional<Objetivo> obj = objetivoRepository.findByDescricao(objetivo.getId());
        if (obj.isPresent() && !obj.get().getId().equals(objetivo.getId())) {
            return null;
        }
        return objetivoRepository.save(objetivo);
    }



    @Override
    public void deleteObjetivo(Integer id) {
        objetivoRepository.deleteById(id);
    }
}