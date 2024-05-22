package com.squad25.CRUDOKR.dto.test;

import com.squad25.CRUDOKR.dto.KeyResultAverageDTO;
import com.squad25.CRUDOKR.dto.KeyResultProgressDTO;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class DtoTest {

    @Test
    public void testKeyResultProgressDTO() {
        Long keyResultId = 1L;
        double progress = 0.75;

        KeyResultProgressDTO dto = new KeyResultProgressDTO(keyResultId, progress);

        assertEquals(keyResultId, dto.getKeyResultId());
        assertEquals(progress, dto.getProgress());
    }

    @Test
    public void testKeyResultAverageDTO() {
        Long keyResultId = 2L;
        double averageProgress = 0.8;
        double monthlyProgress = 0.9;
        double yearlyProgress = 0.85;

        KeyResultAverageDTO dto = new KeyResultAverageDTO(keyResultId, averageProgress);
        dto.setMonthlyAverageProgress(monthlyProgress);
        dto.setYearlyAverageProgress(yearlyProgress);

        assertEquals(keyResultId, dto.getKeyResultId());
        assertEquals(averageProgress, dto.getAverageProgress());
        assertEquals(monthlyProgress, dto.getMonthlyAverageProgress());
        assertEquals(yearlyProgress, dto.getYearlyAverageProgress());
    }
}
