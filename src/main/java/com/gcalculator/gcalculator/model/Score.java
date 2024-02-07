package com.gcalculator.gcalculator.model;

import jakarta.persistence.*;

@Entity
public class Score {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Student student;
    @Column(name = "assignment_score")
    private Double assignmentScore;
    @Column(name = "ca_score")
    private Double caScore;
    @Column(name = "project_score")
    private Double projectScore;
    @Column(name = "exam_score")
    private Double examScore;
    @Column(name = "participation_score")
    private Double participationScore;
    @Column(name = "attendance_score")
    private Double attendanceScore;
    private String grade;
    public Score(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Double getAssignmentScore() {
        return assignmentScore;
    }

    public void setAssignmentScore(Double assignmentScore) {
        this.assignmentScore = assignmentScore;
    }

    public Double getCaScore() {
        return caScore;
    }

    public void setCaScore(Double caScore) {
        this.caScore = caScore;
    }

    public Double getProjectScore() {
        return projectScore;
    }

    public void setProjectScore(Double projectScore) {
        this.projectScore = projectScore;
    }

    public Double getExamScore() {
        return examScore;
    }

    public void setExamScore(Double examScore) {
        this.examScore = examScore;
    }

    public Double getParticipationScore() {
        return participationScore;
    }

    public void setParticipationScore(Double participationScore) {
        this.participationScore = participationScore;
    }

    public Double getAttendanceScore() {
        return attendanceScore;
    }

    public void setAttendanceScore(Double attendanceScore) {
        this.attendanceScore = attendanceScore;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Score{" +
                "id=" + id +
                ", assignmentScore=" + assignmentScore +
                ", caScore=" + caScore +
                ", projectScore=" + projectScore +
                ", examScore=" + examScore +
                ", participationScore=" + participationScore +
                ", attendanceScore=" + attendanceScore +
                ", grade='" + grade + '\'' +
                '}';
    }
}
