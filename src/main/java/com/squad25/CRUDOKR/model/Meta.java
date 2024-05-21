package com.squad25.CRUDOKR.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Meta {
	
    @Id
    @Column(name = "id")
    private Long id;
    
    @Column(name = "idKeyResult")
    private Long idKeyResult;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "dataCadastro")
    private Date dataCadastro;
    
    @Column(name = "status")
    private String status;
    
    @Column(name = "dataConclusao")
    private LocalDate dataConclusao;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "descricao")
    private String descricao;
    
    private double valor;
    
	public Long getIdKeyResult() {
		return idKeyResult;
	}
	public void setIdKeyResult(Long idKeyResult) {
		this.idKeyResult = idKeyResult;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
}