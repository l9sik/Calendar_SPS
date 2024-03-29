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

    opens com.bestgroup.calendar to javafx.fxml;
    exports com.bestgroup.calendar;
    exports com.bestgroup.calendar.Contollers;
    opens com.bestgroup.calendar.Contollers to javafx.fxml;
}