package com.gcalculator.gcalculator.service;

import com.gcalculator.gcalculator.dao.StudentDao;
import com.gcalculator.gcalculator.model.Student;

import java.util.List;

public class StudentService {
    private final StudentDao studentDao = new StudentDao();

    public List<Student> getAllStudents() {
        return studentDao.findAll();
    }

    public void addStudent(Student student) {
        studentDao.add(student);
    }
}
