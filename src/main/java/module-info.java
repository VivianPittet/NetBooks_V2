module com.example.netbooks_v2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.netbooks_v2 to javafx.fxml;
    exports com.example.netbooks_v2;
    exports com.example.netbooks_v2.controller;
    opens com.example.netbooks_v2.controller to javafx.fxml;
}