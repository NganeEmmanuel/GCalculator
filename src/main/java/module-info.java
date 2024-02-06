module com.gcalculator.gcalculator {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.gcalculator.gcalculator to javafx.fxml;
    exports com.gcalculator.gcalculator;
}