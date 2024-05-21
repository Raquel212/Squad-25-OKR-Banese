package com.squad25.CRUDOKR.model;

import jakarta.persistence.Column;
import jakarta.persistence.*;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "Objetivo")
public class Objetivo {
	
    @Id
    private Integer id;

    @Column(name = "tipo")
    private String tipo;

    @Temporal(TemporalType.DATE)
    @Column(name = "dataCadastro")
    private Date dataCadastro;

    @Temporal(TemporalType.DATE)
    @Column(name = "dataPrevisao")
    private Date dataPrevisao;

    @Temporal(TemporalType.DATE)
    @Column(name = "dataConclusao")
    private LocalDate dataConclusao;

    @Column(name = "descricao", length = 300)
    private String descricao;


    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataPrevisao() {
        return dataPrevisao;
    }

    public void setDataPrevisao(Date dataPrevisao) {
        this.dataPrevisao = dataPrevisao;
    }

    public LocalDate getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDate dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
