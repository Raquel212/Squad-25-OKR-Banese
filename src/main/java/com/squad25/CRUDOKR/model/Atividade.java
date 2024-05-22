package com.squad25.CRUDOKR.model;

import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Atividade {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "idKeyResult")
    private Long idKeyResult;

    @Temporal(TemporalType.DATE)
    @Column(name = "dataCadastro")
    private Date dataCadastro;
    
    @Column(name = "dataConclusao")
    private Date dataConclusao;

    @Column(name = "status")
    private String status;

    @Column(name = "descricao")
    private String descricao;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
	public Date getDataConclusao() {
		return dataConclusao;
	}
	public void setDataConclusao(Date dataConclusao) {
		this.dataConclusao = dataConclusao;
	}
}
