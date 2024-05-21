package com.squad25.CRUDOKR.dto;

public class KeyResultProgressDTO {
    private Long keyResultId;
    private double progress;

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
}
