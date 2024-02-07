package com.gcalculator.gcalculator.controller;

import com.gcalculator.gcalculator.model.Score;
import com.gcalculator.gcalculator.model.Student;
import com.gcalculator.gcalculator.service.StudentService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

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
        if(!studentNameInput.getText().isBlank() && !studentMatriculeInput.getText().isBlank()){
            Student student = new Student(studentNameInput.getText(), studentMatriculeInput.getText());
            studentService.addStudent(student);
            if(student.getId() != null){
                studentTable.getItems().add(student);
                studentNameInput.setText("");
                studentMatriculeInput.setText("");
                addStudentWarningMessage.setText("Student added successfully");
            }
        }else{
            addStudentWarningMessage.setText("Please fill all require student information");
        }
    }

    @FXML
    void addStudentAndScore(MouseEvent event) {

    }

    @FXML
    void clearFields(MouseEvent event) {

    }

    private final StudentService studentService = new StudentService();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        studentNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        studentMatriculeColumn.setCellValueFactory(new PropertyValueFactory<>("matricule"));

        //get students from db
        studentTable.getItems().addAll(studentService.getAllStudents());
    }
}