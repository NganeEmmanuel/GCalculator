package com.gcalculator.gcalculator;

import com.gcalculator.gcalculator.dao.StudentDao;
import com.gcalculator.gcalculator.model.Student;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainView extends Application {
    Student student = new Student("Sample Student", "ICTU20221982");
    private final StudentDao studentDao = new StudentDao();

    @Override
    public void start(Stage stage) throws IOException {
        studentDao.add(student);
        FXMLLoader fxmlLoader = new FXMLLoader(MainView.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1100, 600);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}