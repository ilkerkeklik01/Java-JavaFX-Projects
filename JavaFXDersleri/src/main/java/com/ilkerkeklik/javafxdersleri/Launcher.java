package com.ilkerkeklik.javafxdersleri;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launcher extends javafx.application.Application {

    @Override
    public void start(Stage stage) throws Exception {
        /*
        StackPane stackPane = new StackPane();
        Scene scene = new Scene(stackPane,500,400);
        stage.setResizable(true);
        stage.setTitle("Uygulamamin Basligi");
        stage.setScene(scene);
        stage.show();
        Button button = new Button("Butonum");
        stackPane.getChildren().add(button);
        Node colorPicker= new ColorPicker(Color.AQUA);
        colorPicker.setTranslateX(150);
        colorPicker.setTranslateY(-150);
        stackPane.getChildren().add(colorPicker);
        TextField textField = new TextField();
        stackPane.getChildren().add(textField);
        textField.setMaxWidth(50);
        textField.setTranslateX(-150);
        textField.setTranslateY(-150);


        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String s = textField.getText();
                System.out.println(s);
            }
        });

        button.setId("butonumBTN");

        String css = this.getClass().getResource("stil.css").toExternalForm();
        scene.getStylesheets().add(css);


        button.setStyle("-fx-text-fill:blue; -fx-background-color: yellow;");
      */

        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Parent root =loader.load();
        Scene scene = new Scene(root,900,600);
        stage.setTitle("Title");
        stage.setScene(scene);
        stage.show();



    }




}