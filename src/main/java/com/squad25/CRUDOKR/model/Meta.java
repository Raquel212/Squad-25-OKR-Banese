package com.squad25.CRUDOKR.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;

@Entity
public class Meta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "idKeyResult")
    private Long idKeyResult;
    @Column(name = "dataCadastro")
    private Date dataCadastro;
    @Column(name = "status")
    private String status;
    @Column(name = "dataConclusao")
    private Date dataConclusao;
    @Column(name = "descricao")
    private String descricao;
    
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
	public Date getDataConclusao() {
		return dataConclusao;
	}
	public void setDataConclusao(Date dataConclusao) {
		this.dataConclusao = dataConclusao;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Long getId(Long id) { return id;}
	
}