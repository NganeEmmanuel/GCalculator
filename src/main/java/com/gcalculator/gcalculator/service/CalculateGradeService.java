package com.gcalculator.gcalculator.service;

public class CalculateGradeService {
    private final Double assignmentWeight;
    private final Double caWeight;
    private final Double projectWeight;
    private final Double examWeight;
    private final Double attendanceWeight;
    private final Double participationWeight;
    private final Double totalWeight;

    public CalculateGradeService() {
        this.assignmentWeight = 10.0; //converted to 2.0;
        this.caWeight = 20.0; //converted to 4.0;
        this.projectWeight = 20.0; //converted to 6.0;
        this.examWeight = 40.0; //converted to 8.0;
        this.attendanceWeight = 5.0; //converted to 2.0;
        this.participationWeight = 5.0; //converted to 2.0;
        this.totalWeight = 100.0; //converted to 24.0;
    }

    public String calculateGrade(Double homeWorkScore, Double caScore, Double projectScore, Double examScore, Double attendanceScore, Double participationScore) {
        double totalAverage = (assessTotalScore(homeWorkScore, caScore, projectScore, examScore, attendanceScore, participationScore)/ 6.0); //get the average student score based on assessment weight

        if(totalAverage >= 3.75){
            return "A+";
        }else if(totalAverage >= 3.5){
            return "A";
        }else if(totalAverage >= 3.25){
            return "B+";
        }else if(totalAverage >= 3.0){
            return "B";
        }else if(totalAverage >= 2.5){
            return "C+";
        }else if(totalAverage >= 2.0){
            return "C";
        }else if(totalAverage >= 1.75){
            return "D+";
        }else if(totalAverage >= 1.5){
            return "D";
        }else {
            return "F";
        }

    }


    public Double assessTotalScore(Double ... scores){
        Double total = 0.0;
        for(Double score: scores){
            total += score;
        }
        return ((total/100) * 24);
    }
}
