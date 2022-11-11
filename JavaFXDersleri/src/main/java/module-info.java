

module com.ilkerkeklik.javafxdersleri {
    requires javafx.controls;
    requires javafx.fxml;



    opens com.ilkerkeklik.javafxdersleri to javafx.fxml;


    exports com.ilkerkeklik.javafxdersleri;

}