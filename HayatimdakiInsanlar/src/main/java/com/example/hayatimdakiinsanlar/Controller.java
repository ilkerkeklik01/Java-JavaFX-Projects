package com.example.hayatimdakiinsanlar;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.FileNotFoundException;

public class Controller {

    @FXML
    private Label benKimimLabel;

    @FXML
    private Button cikisButonu;

    @FXML
    private TextField inputIsim;

    @FXML
    private TextField inputNeyim;

    @FXML
    private TextField inputSehir;

    @FXML
    private TextField inputMeslek;

    @FXML
    private TextField inputYas;

    @FXML
    private Button listeneEkleButon;

    @FXML
    private Label mesajLabel;

    @FXML
    private   Label tamListaLabel;

    @FXML
    private Label topLabel;

    @FXML
    private Button listedenSilButonu;
    @FXML
    private TextField silinenTextField;

    @FXML
    void listedenSilBasildi(ActionEvent event) {


        int index =Integer.parseInt(silinenTextField.getText())-1;

        Launcher.ben.listemdenInsanCikart(Launcher.ben.getInsanListem().get(index));
        System.out.println(index
        );


        /*
        for(int i=0;i<Launcher.ben.getInsanListem().size();i++){
            if(i==index){

            }
        }
*/

        /*
        for(Insan insan:Launcher.ben.getInsanListem()){
            if(insan.getIsim().equals(silinenTextField.getText())){
                Launcher.ben.listemdenInsanCikart(insan);
            }
        }*/


    }
    @FXML
    void cikisButonunaBasildi(ActionEvent event) throws Exception {
        System.out.println("Sistemden cikiliyor");
        new Launcher().stop();
        System.exit(0);
    }

    @FXML
    void listeneEkleButonunaBasildi(ActionEvent event) {
        Insan insan;
        String isim="Atanmamis";
        String meslek="Atanmamis";
        String sehir="Atanmamis";
        String neyim="Atanmamis";
        int yas=-1;

        if(inputIsim.getText()!=null&&!inputIsim.getText().equals("")){
            System.out.println("get text: "+inputIsim.getText());
            isim = inputIsim.getText();
        }else {

            mesajLabel.setText("Please fill isim input correctly");
            return;
        }

        if(inputMeslek.getText()!=null&&!inputMeslek.getText().equals("")){
            meslek = inputMeslek.getText();
        }else {
            mesajLabel.setText("Please fill meslek input correctly");
            return;
        }

        if(inputSehir.getText()!=null&&!inputSehir.getText().equals("")){
            sehir= inputSehir.getText();

        }else {
            mesajLabel.setText("Please fill sehir input correctly");
            return;
        }

        if(inputNeyim.getText()!=null&&!inputNeyim.getText().equals("")){
            neyim= inputNeyim.getText();
        }else {
            mesajLabel.setText("Please fill neyim input correctly");
            return;
        }

        if(inputYas.getText()!=null){
            try{
                yas = Integer.parseInt(inputYas.getText());
            }catch (NumberFormatException e){
                mesajLabel.setText("Please fill yas input with valid numbers");
                System.out.println(e);
                return;
            }
        }else{
            mesajLabel.setText("Please fill int input correctly");
            return;
        }


         Launcher.ben.listemeInsanEkle(new Insan(isim,meslek,yas,sehir,neyim));
        mesajLabel.setText( isim+" eklendi");


    }

    @FXML
    public  void listeyiYazdir(MouseEvent event){
        String yazi = "Tam Liste\n";
        int i=1;
        for(Insan insan:Launcher.ben.listeyiSiralayipDondur()){
            yazi+= i+"-->";
            yazi+=insan.toString()+"\n";
        i++;
        }
        tamListaLabel.setText(yazi);

    }



    @FXML
    void listeyiTemizleButonunaBasildi(ActionEvent event) throws FileNotFoundException {
        System.out.println("Listeyi temizle butonuna basildi");
        Launcher.ben.listeyiBosalt();

    }

    @FXML
    void benKimimYazdir(MouseEvent event){
        String s = "Ben Kimim\n";
        s+="Ismim: "+Launcher.ben.getIsim()+"\n";
        s+="Meslegim: "+Launcher.ben.getMeslek()+"\n";
        s+="Yasadigim Sehir: "+Launcher.ben.getSehir()+"\n";
        s+="Yasim: "+Launcher.ben.getYas()+"\n";
        benKimimLabel.setText(s);
    }

}
