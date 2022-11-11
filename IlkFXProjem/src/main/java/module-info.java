module com.example.ilkfxprojem {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;


    opens com.example.ilkfxprojem to javafx.fxml;
    exports com.example.ilkfxprojem;
}