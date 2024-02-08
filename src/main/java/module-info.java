module com.gcalculator.gcalculator {
    requires javafx.controls;
    requires javafx.fxml;

    requires jxl;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires org.controlsfx.controls;

    opens com.gcalculator.gcalculator to javafx.fxml;
    opens com.gcalculator.gcalculator.model;
    opens com.gcalculator.gcalculator.dao;
    opens com.gcalculator.gcalculator.service;
    exports com.gcalculator.gcalculator;
    exports com.gcalculator.gcalculator.controller;
    opens com.gcalculator.gcalculator.controller to javafx.fxml;
}