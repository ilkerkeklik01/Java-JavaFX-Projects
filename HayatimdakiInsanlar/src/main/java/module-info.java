module com.example.hayatimdakiinsanlar {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.hayatimdakiinsanlar to javafx.fxml;
    exports com.example.hayatimdakiinsanlar;
}