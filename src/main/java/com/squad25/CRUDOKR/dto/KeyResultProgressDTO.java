package com.squad25.CRUDOKR.dto;

import java.time.LocalDate;

public class KeyResultProgressDTO {
    private Long keyResultId;
    private double progress;
    private Long id;
    private LocalDate updateDate;

    // Construtor padrão
    public KeyResultProgressDTO() {}

    // Construtor com parâmetros
    public KeyResultProgressDTO(Long keyResultId, double progress) {
        this.keyResultId = keyResultId;
        this.progress = progress;
    }

    // Getters e Setters
    public Long getKeyResultId() {
        return keyResultId;
    }

    public void setKeyResultId(Long keyResultId) {
        this.keyResultId = keyResultId;
    }

    public double getProgress() {
        return progress;
    }

    public void setProgress(double progress) {
        this.progress = progress;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDate updateDate) {
		this.updateDate = updateDate;
	}
}
