package com.squad25.CRUDOKR.service;

import com.squad25.CRUDOKR.model.Objetivo;

import java.util.List;

public interface ObjetivoService {
    public Objetivo createObjetivo(Objetivo objetivo);

    public Objetivo getObjetivo(Integer id);

    public List<Objetivo> getAllObjetivos();

    public Objetivo updateObjetivo(Objetivo objetivo);

    public void deleteObjetivo(Integer id);
}