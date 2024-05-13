package com.squad25.CRUDOKR.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Atividade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "idKeyResult")
    private Long idKeyResult;

    @Temporal(TemporalType.DATE)
    @Column(name = "dataCadastro")
    private Date dataCadastro;

    @Column(name = "status")
    private String status;

    @Temporal(TemporalType.DATE)
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

	public void setId(Long id2) {
		// TODO Auto-generated method stub
		
	}

    // Getters and Setters
}
