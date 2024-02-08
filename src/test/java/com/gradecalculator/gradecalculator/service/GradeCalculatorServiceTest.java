package com.gradecalculator.gradecalculator.service;

import com.gcalculator.gcalculator.service.CalculateGradeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GradeCalculatorServiceTest {
    private CalculateGradeService calculateGradeService;

    @BeforeEach
    public void setUp() {
        calculateGradeService = new CalculateGradeService();
    }

    @Test
    public void testCalculateGrade_APlus() {
        String grade = calculateGradeService.calculateGrade(9.5, 18.0, 18.0, 34.0, 4.0, 4.0);
        Assertions.assertEquals("A", grade);
    }

    @Test
    public void testCalculateGrade_B() {
        String grade = calculateGradeService.calculateGrade(7.0, 14.0, 16.0, 28.0, 3.0, 3.0);
        Assertions.assertEquals("C+", grade);
    }

    @Test
    public void testCalculateGrade_F() {
        String grade = calculateGradeService.calculateGrade(5.0, 9.0, 6.0, 10.0, 2.0, 2.0);
        Assertions.assertEquals("F", grade);
    }


    @Test
    public void testAssessTotalScore() {
        Double totalScore = calculateGradeService.assessTotalScore(8.0, 7.0, 9.0, 7.5);
        Assertions.assertEquals(7.5600000000000005, totalScore, 0.01);
    }
}