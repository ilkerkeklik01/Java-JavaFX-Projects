package com.ilkerkeklik.favorifilmlerim;

import com.jfoenix.controls.JFXListView;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private ContextMenu listeSilMenusu;
    @FXML
    private MenuItem aboutButton;

    @FXML
    private MenuItem addMovieButton;

    @FXML
    private MenuItem closeButton;
    @FXML
    private TextArea textArea;
    @FXML
    private MenuItem deleteButton;

    @FXML
    private JFXListView<Film> listView;

    @FXML
    private BorderPane mainWindow;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        listView.setItems(FilmData.getInstance().getList());
        listeSilMenusu = new ContextMenu();
        MenuItem filmSil = new MenuItem("Filmi Listeden Kaldir");
        filmSil.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ObservableList<Film> silinecekler =listView.getSelectionModel().getSelectedItems();

                secilenleriSil(silinecekler);

            }
        });

        listeSilMenusu.getItems().add(filmSil);
        listView.setContextMenu(listeSilMenusu);

        textArea.setEditable(false);



    }

    private void secilenleriSil(ObservableList<Film> silinecekler) {

    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Emin Misiniz");
        Optional<ButtonType> s = alert.showAndWait();

        if(s.get()==ButtonType.OK){
            for(Film film:silinecekler){
                FilmData.getInstance().getList().remove(film);
            }
        }

        System.out.println(FilmData.getInstance().getList());

    }

    @FXML
    void aboutButtonClicked(ActionEvent event) { //halledicem yeni dialog penceresiyle

    }

    @FXML
    void addMovieButtonClicked(ActionEvent event) throws IOException {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainWindow.getScene().getWindow());
        dialog.setTitle("Add a Movie");

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("dialog.fxml"));
        dialog.getDialogPane().setContent(fxmlLoader.load());

        dialog.getDialogPane().getButtonTypes().add(ButtonType.APPLY);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> sonuc = dialog.showAndWait();
        if(sonuc.get()==ButtonType.APPLY){
            DialogController dialogController = fxmlLoader.getController();
            Film eklenenFilm =dialogController.clickedApplyButton();
            listView.getSelectionModel().select(eklenenFilm);
        }


        System.out.println(FilmData.getInstance().getList());


    }

    @FXML
    void closeButtonClicked(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void deleteButtonClicked(ActionEvent event) {
        ObservableList<Film> s =listView.getSelectionModel().getSelectedItems();
        secilenleriSil(s);



    }
    @FXML
    void filmSecildi(MouseEvent event) {
        String s="";

        for(Film each:(listView.getSelectionModel().getSelectedItems())){
            s += each.filmiYazdir();
            s += "\n\n";
        }
        textArea.setText(s);

    }



}