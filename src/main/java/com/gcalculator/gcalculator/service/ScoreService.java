package com.gcalculator.gcalculator.service;

import com.gcalculator.gcalculator.dao.ScoreDao;
import com.gcalculator.gcalculator.dao.StudentDao;
import com.gcalculator.gcalculator.model.Score;
import com.gcalculator.gcalculator.model.Student;

import java.util.ArrayList;
import java.util.List;

public class ScoreService {
    private final ScoreDao scoreDao = new ScoreDao();
    private final StudentDao studentDao = new StudentDao();

    public void addScore(Score score) {
        scoreDao.add(score);
    }

    public List<Score> getScoreByStudentId(Long id) {
        Student student = studentDao.findById(id).orElse(null);
        if(student != null){
            return student.getScores();
        }
        return new ArrayList<>();
    }
}
