package com.ilkerkeklik.favorifilmlerim;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class Launcher extends Application {

    @Override
    public void init() throws Exception {
        FilmData.getInstance().veriTabanindanFilmleriOku();
        super.init();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Launcher.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 600 );
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();



    }

    public static void main(String[] args) {
        launch();
    }


    @Override
    public void stop() throws Exception {
        FilmData.getInstance().veriTabaninaFilmleriYaz();
        super.stop();
    }

}