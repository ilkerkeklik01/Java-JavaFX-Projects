package com.example.hayatimdakiinsanlar;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;

public class Launcher extends Application {
    static Ben ben = new Ben("Ilker Keklik","Universite Ogrencisi",20,"Istanbul","Kendim");

    //program acildiginda yapilacak ilk islem
    @Override
    public void init() throws Exception {

        System.out.println("init metotu");


        //get datas from insanlar.txt file
        try(DataInputStream dataInputStream = new DataInputStream(
                new BufferedInputStream(new FileInputStream("insanlar.txt"))
        )){

            boolean dosyaSonu =false;



            while(!dosyaSonu){
               try{
                  ben.listemeInsanEkle(new Insan(dataInputStream.readUTF(),dataInputStream.readUTF(),
                          dataInputStream.readInt(),dataInputStream.readUTF(), dataInputStream.readUTF()));
               }
                catch (EOFException e){
                    dosyaSonu=true;
                }
            }//while end



        }

        catch (Exception e){
            e.printStackTrace();
        }

    }//init method end

    @Override
    public void start(Stage stage) throws IOException {


        System.out.println("Start metotu");

        FXMLLoader fxmlLoader = new FXMLLoader(Launcher.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1080, 720);
        stage.setTitle("Benim Uygulamam");
        stage.setScene(scene);
        stage.show();

    }

    //program kapanmadan once yapilacak son islem
    @Override
    public void stop() throws Exception {
        System.out.println("Stop metotu");
        //Uygulama kapanmadan once insanListesine eklenen veriler veri tabanina kaydedilir

        File file = new File("insanlar.txt");


        try(DataOutputStream dataOutputStream = new DataOutputStream(
                new BufferedOutputStream(new FileOutputStream("insanlar.txt"))
        )){
            //veri tabani temizlendi
                veriTabaniniTemizle();

                //veri tabanina insanlistesindeki veriler ataniyor
            for(Insan gecici:ben.listeyiSiralayipDondur()){
                dataOutputStream.writeUTF(gecici.getIsim());
                dataOutputStream.writeUTF(gecici.getMeslek());
                dataOutputStream.writeInt(gecici.getYas());
                dataOutputStream.writeUTF(gecici.getSehir());
                dataOutputStream.writeUTF(gecici.getNeyim());
            }


        }catch (Exception e){
        e.printStackTrace();

        }



    }//stop blocks end

    public static void main(String[] args) {
        launch();
    }
     static void veriTabaniniTemizle() throws FileNotFoundException {
        File file = new File("insanlar.txt");
        PrintWriter writer = new PrintWriter(file);
        writer.print("");
        writer.close();
    }


}