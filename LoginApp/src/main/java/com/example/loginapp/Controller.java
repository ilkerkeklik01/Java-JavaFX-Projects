package com.example.loginapp;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;

public class Controller {

    @FXML
    private JFXButton buton;

    @FXML
    private TextField mail;

    @FXML
    private PasswordField sifre;

    @FXML
    private Label sonuc;

    @FXML
    void loginMetotu(ActionEvent event) {
        if(mail.getText().contains("@icloud.com")&&sifre.getText().equals("1234")){
            String s = "Oturum Acildi\n"+"E-mail: "+mail.getText()+" Password: "+sifre.getText();
            sonuc.setText(s);


        }else{
            sonuc.setText("Email/Sifre Hatali");
        }


    }

    @FXML
    void password(InputMethodEvent event) {

    }

    @FXML
    void username(InputMethodEvent event) {

    }


}