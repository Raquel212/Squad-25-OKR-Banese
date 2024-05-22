package com.squad25.CRUDOKR.dto;

public class KeyResultAverageDTO {
	private Long id;
    private Long keyResultId;
    private double averageProgress;
    private double monthlyAverageProgress;
    private double yearlyAverageProgress;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getMonthlyAverageProgress() {
		return monthlyAverageProgress;
	}

	public void setMonthlyAverageProgress(double monthlyAverageProgress) {
		this.monthlyAverageProgress = monthlyAverageProgress;
	}

	public double getYearlyAverageProgress() {
		return yearlyAverageProgress;
	}

	public void setYearlyAverageProgress(double yearlyAverageProgress) {
		this.yearlyAverageProgress = yearlyAverageProgress;
	}
}
