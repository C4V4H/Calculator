module com.company.calculator {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.company.calculator to javafx.fxml;
    exports com.company.calculator;
}