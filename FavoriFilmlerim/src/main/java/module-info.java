module com.ilkerkeklik.favorifilmlerim {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;


    opens com.ilkerkeklik.favorifilmlerim to javafx.fxml;
    exports com.ilkerkeklik.favorifilmlerim;
}