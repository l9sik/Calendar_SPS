module com.bestgroup.calendar {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires poi;
    requires java.desktop;

    opens com.bestgroup.calendar to javafx.fxml;
    exports com.bestgroup.calendar;
    exports com.bestgroup.calendar.controllers;
    opens com.bestgroup.calendar.controllers to javafx.fxml;
}