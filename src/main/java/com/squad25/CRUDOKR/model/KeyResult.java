package com.squad25.CRUDOKR.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.sql.Date;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
public class KeyResult {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "idResponsavel")
    private Long idResponsavel;

    @Column(name = "tipo")
    private String tipo;
    
    @Column(name = "descricao", length = 300)
    private String descricao;

    @Column(name = "idObjetivo")
    private Long idObjetivo;
   
    @Column(name = "dataCadastro")
    private Date dataCadastro;

    @Temporal(TemporalType.DATE)
    @Column(name = "dataConclusao")
    private Date dataConclusao;

    @Column(name = "status")
    private String status;
    
    @OneToOne
    private Meta meta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdResponsavel() {
        return idResponsavel;
    }

    public void setIdResponsavel(Long idResponsavel) {
        this.idResponsavel = idResponsavel;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getIdObjetivo() {
        return idObjetivo;
    }

    public void setIdObjetivo(Long idObjetivo) {
        this.idObjetivo = idObjetivo;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(Date dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
	public Meta getMeta() {
		return meta;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
	}

}
