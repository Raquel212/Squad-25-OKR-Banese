package com.squad25.CRUDOKR.dto;

public class KeyResultAverageDTO {
    private Long keyResultId;
    private double averageProgress;

    // Construtor padrão
    public KeyResultAverageDTO() {}

    // Construtor com parâmetros
    public KeyResultAverageDTO(Long keyResultId, double averageProgress) {
        this.keyResultId = keyResultId;
        this.averageProgress = averageProgress;
    }

    // Getters e Setters
    public Long getKeyResultId() {
        return keyResultId;
    }

    public void setKeyResultId(Long keyResultId) {
        this.keyResultId = keyResultId;
    }

    public double getAverageProgress() {
        return averageProgress;
    }

    public void setAverageProgress(double averageProgress) {
        this.averageProgress = averageProgress;
    }
}
