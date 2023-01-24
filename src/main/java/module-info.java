module com.example.dw_1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.dw_1 to javafx.fxml;
    exports com.example.dw_1;
    opens com.example.dw_1.controllerGrafico to javafx.fxml;
    exports com.example.dw_1.controllerGrafico;
}