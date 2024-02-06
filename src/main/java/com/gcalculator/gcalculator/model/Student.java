package com.gcalculator.gcalculator.model;

public class Student {
    private Long id;
    private String name;
    private String matricule;

    public Student(){}
    public Student(String name, String matricule){
        this.name = name;
        this.matricule = matricule;
    }
    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", matricule='" + matricule + '\'' +
                '}';
    }
}
