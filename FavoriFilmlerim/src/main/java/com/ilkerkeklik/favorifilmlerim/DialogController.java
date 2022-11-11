package com.ilkerkeklik.favorifilmlerim;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class DialogController {

    @FXML
    private DatePicker datePicker;

    @FXML
    private TextArea explanationField;

    @FXML
    private TextField movieNameField;

    public Film clickedApplyButton() {
        Film temp =new Film(movieNameField.getText().trim(),explanationField.getText().trim(),
                datePicker.getValue());
        FilmData.getInstance().filmEkle(temp);
        return temp;
    }

}
