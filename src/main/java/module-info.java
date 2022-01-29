module io.alekhanov.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires telegrambots;
    requires telegrambots.meta;

    opens io.alekhanov.demo to javafx.fxml;
    exports io.alekhanov.demo;
}