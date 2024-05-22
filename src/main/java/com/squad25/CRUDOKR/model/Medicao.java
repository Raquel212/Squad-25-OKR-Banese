package com.squad25.CRUDOKR.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Medicao {
	
	@Id
	@Column(name = "id")
	private Long id;
	
	@Column(name = "idKeyResult")
	private Long idKeyResult;
	
	@Column(name = "idMeta")
	private Long idMeta;
	
	@Column(name = "dataCadastro")
	private Date dataCadastro;
	
	@Column(name = "dataMedicao")
	private Date dataMedicao;
	
	@Column(name = "descricao")
	private String descricao;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getIdKeyResult() {
		return idKeyResult;
	}
	
	public void setIdKeyResult(Long idKeyResult) {
		this.idKeyResult = idKeyResult;
	}
	
	public Long getIdMeta() {
		return idMeta;
	}
	
	public void setIdMeta(Long idMeta) {
		this.idMeta = idMeta;
	}
	
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	public Date getDataMedicao() {
		return dataMedicao;
	}
	public void setDataMedicao(Date dataMedicao) {
		this.dataMedicao = dataMedicao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
	


	
}
