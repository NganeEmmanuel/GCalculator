package com.gcalculator.gcalculator.controller;

import com.gcalculator.gcalculator.model.Score;
import com.gcalculator.gcalculator.model.Student;
import com.gcalculator.gcalculator.service.CalculateGradeService;
import com.gcalculator.gcalculator.service.InputValidator;
import com.gcalculator.gcalculator.service.ScoreService;
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
    private TableView<Score> performanceTable;

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
    private final CalculateGradeService calculateGradeService = new CalculateGradeService();
    private final ScoreService scoreService = new ScoreService();

    @FXML
    void addScore(MouseEvent event) {
        addNewScoreToStudent(studentTable.getSelectionModel().getSelectedItem());
    }

    private void addNewScoreToStudent(Student student){
        Double assignment = InputValidator.isDouble(assignmentInput.getText()) ? Double.parseDouble(assignmentInput.getText()) : 0.00231;
        Double ca = InputValidator.isDouble(caInput.getText()) ? Double.parseDouble(caInput.getText()) : 0.00231;
        Double project = InputValidator.isDouble(projectInput.getText()) ? Double.parseDouble(projectInput.getText()) : 0.00231;
        Double exam = InputValidator.isDouble(examInput.getText()) ? Double.parseDouble(examInput.getText()) : 0.00231;
        Double attendance = InputValidator.isDouble(attendanceInput.getText()) ? Double.parseDouble(attendanceInput.getText()) : 0.00231;
        Double participation = InputValidator.isDouble(participationInput.getText()) ? Double.parseDouble(participationInput.getText()) : 0.00231;
        if (assignment != 0.00231 && ca != 0.00231 && project != 0.00231 && exam != 0.00231 && attendance != 0.00231 && participation != 0.00231) {
            Score score = new Score();
            score.setStudent(student);
            score.setAssignmentScore(assignment);
            score.setCaScore(ca);
            score.setAttendanceScore(attendance);
            score.setProjectScore(project);
            score.setExamScore(exam);
            score.setParticipationScore(participation);
            score.setGrade(calculateGradeService.calculateGrade(assignment, ca, project, exam, attendance, participation));
            scoreService.addScore(score);
            if (score.getId() != null) {
                assignmentInput.setText("0");
                caInput.setText("0");
                projectInput.setText("0");
                examInput.setText("0");
                attendanceInput.setText("0");
                participationInput.setText("0");
                AddScoreErroMessage.setText("Score added successfully!");
                studentTable.getSelectionModel().getSelectedItem().getScores().add(score);
                performanceTable.getItems().add(score);
            }
        } else {
            AddScoreErroMessage.setText("Please fill in the form properly");
        }
    }

    private Student addNewStudent(){
        if(!studentNameInput.getText().isBlank() && !studentMatriculeInput.getText().isBlank()){
            Student student = new Student(studentNameInput.getText(), studentMatriculeInput.getText());
            studentService.addStudent(student);
            if(student.getId() != null){
                studentTable.getItems().add(student);
                studentNameInput.setText("");
                studentMatriculeInput.setText("");
                addStudentWarningMessage.setText("Student added successfully");
                performanceTable.getItems().clear();
                studentTable.getSelectionModel().select(student);
                addScoreBtn.setDisable(false);
                return student;
            }
        }
        addStudentWarningMessage.setText("Please fill all require student information");
        return null;
    }

    @FXML
    void addStudent(MouseEvent event) {
        addNewStudent();
    }

    @FXML
    void showScores(MouseEvent event) {
        performanceTable.getItems().clear();
        addScoreBtn.setDisable(false);
        Student selectedStudent = studentTable.getSelectionModel().getSelectedItem();
        if (selectedStudent != null) {
            performanceTable.getItems().addAll(scoreService.getScoreByStudentId(selectedStudent.getId()));

        }
    }

    @FXML
    void addStudentAndScore(MouseEvent event) {
        Student student = addNewStudent();
        addNewScoreToStudent(student);
    }

    @FXML
    void clearFields(MouseEvent event) {
        studentNameInput.setText("");
        studentMatriculeInput.setText("");
        assignmentInput.setText("");
        examInput.setText("");
        caInput.setText("");
        projectInput.setText("");
        attendanceInput.setText("");
        participationInput.setText("");
        AddScoreErroMessage.setText("");
        addStudentWarningMessage.setText("");
    }

    private final StudentService studentService = new StudentService();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        studentNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        studentMatriculeColumn.setCellValueFactory(new PropertyValueFactory<>("matricule"));

        //map the score/performance table columns to the data
        assignmentColumn.setCellValueFactory(new PropertyValueFactory<>("assignmentScore"));
        caColumn.setCellValueFactory(new PropertyValueFactory<>("caScore"));
        projectColumn.setCellValueFactory(new PropertyValueFactory<>("projectScore"));
        examColumn.setCellValueFactory(new PropertyValueFactory<>("examScore"));
        attendanceColumn.setCellValueFactory(new PropertyValueFactory<>("attendanceScore"));
        participationColumn.setCellValueFactory(new PropertyValueFactory<>("participationScore"));
        gradeColumn.setCellValueFactory(new PropertyValueFactory<>("grade"));

        //get students from db
        studentTable.getItems().addAll(studentService.getAllStudents());
    }
}