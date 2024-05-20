package com.squad25.CRUDOKR.service;

import com.squad25.CRUDOKR.model.Objetivo;

import java.util.List;

public interface ObjetivoService {
    Objetivo createObjetivo(Objetivo objetivo);

    Objetivo getObjetivo(Integer id);

    List<Objetivo> getAllObjetivos();

    Objetivo updateObjetivo(Objetivo objetivo);

    void deleteObjetivo(Integer id);
}