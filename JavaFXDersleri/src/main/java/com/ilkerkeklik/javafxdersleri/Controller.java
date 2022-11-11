package com.ilkerkeklik.javafxdersleri;


        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.scene.control.*;
        import javafx.scene.input.KeyEvent;

public class Controller {

    @FXML
    private ListView<String> listView;

    @FXML
    private Button tasiButonu;

    @FXML
    private TextArea textArea;
    @FXML
    private CheckBox checkBox;
    @FXML
    private Label label;
    @FXML
    private Button hoscakalButonu;

    @FXML
    private Button merhabaButonu;

    @FXML
    private TextField textField;

    @FXML
    void listeElemanlariniTasi(ActionEvent event) {

        String str="";
        for(String s:listView.getSelectionModel().getSelectedItems()){
            str+=s+"\n";
        }
        textArea.setText(str);

    }

    @FXML
    public void initialize(){
        hoscakalButonu.setDisable(true);
        merhabaButonu.setDisable(true);

        listView.getItems().addAll("Domates","Sucuk","Kasar","Misir","Biber","Zeytin");
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }


    @FXML
    public void metinGirildi(KeyEvent event){
        String isim = textField.getText();

        boolean butlaridiableet=isim.isEmpty()||isim.trim().isEmpty();

        hoscakalButonu.setDisable(butlaridiableet);
        merhabaButonu.setDisable(butlaridiableet);
    }
    @FXML
    void secenekSecildi(ActionEvent event) {

    }


    @FXML
    void turuncuButon(ActionEvent event) {
        if(((Button)event.getSource()).getId().equals("merhabaButonu")){
                label.setText("Merhaba "+textField.getText());
        }else{
            label.setText("Hoscakal "+textField.getText());
        }

        if(checkBox.isSelected()){
            textField.clear();
            hoscakalButonu.setDisable(true);
            merhabaButonu.setDisable(true);
        }

    }

    @FXML
    public void banaTiklaMetotu(ActionEvent actionEvent){
        String butonYazisi = ((Button)(actionEvent.getSource())).getText();

        System.out.println(butonYazisi+" tiklandi");

    }


}
