package com.gcalculator.gcalculator.controller;

import com.gcalculator.gcalculator.model.Score;
import com.gcalculator.gcalculator.model.Student;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class MainViewController {

    @FXML
    private Label AddScoreErroMessage;

    @FXML
    private TableColumn<Student, String> studentNameColumn;

    @FXML
    private TableColumn<Score, Double> attendanceColumn;

    @FXML
    private Button addScoreBtn;

    @FXML
    private Label addStudentWarningMessage;

    @FXML
    private TableColumn<Score, Double> assignmentColumn;

    @FXML
    private TextField assignmentInput;

    @FXML
    private TextField attendanceInput;

    @FXML
    private TableColumn<Score, Double> caColumn;

    @FXML
    private TextField caInput;

    @FXML
    private TableColumn<Score, Double> examColumn;

    @FXML
    private TextField examInput;

    @FXML
    private TableColumn<Score, String> gradeColumn;

    @FXML
    private TableColumn<Score, Double> participationColumn;

    @FXML
    private TextField participationInput;

    @FXML
    private TableView<?> performanceTable;

    @FXML
    private TableColumn<Score, Double> projectColumn;

    @FXML
    private TextField projectInput;

    @FXML
    private TableColumn<Student, String> studentMatriculeColumn;

    @FXML
    private TextField studentMatriculeInput;

    @FXML
    private TextField studentNameInput;

    @FXML
    private TableView<Student> studentTable;

    @FXML
    void addScore(MouseEvent event) {

    }

    @FXML
    void addStudent(MouseEvent event) {

    }

    @FXML
    void addStudentAndScore(MouseEvent event) {

    }

    @FXML
    void clearFields(MouseEvent event) {

    }
}