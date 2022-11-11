package com.ilkerkeklik.favorifilmlerim;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FilmData {

    private static FilmData instance= new FilmData();

    private ObservableList<Film> list = FXCollections.observableArrayList();

    private DateTimeFormatter formatter ;
    private FilmData(){
        formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }

    public static FilmData getInstance(){
        return instance;
    }

    public boolean filmEkle(Film film){
        return list.add(film);
    }
    public boolean filmSil(Film film){
        return list.remove(film);
    }

    public void veriTabanindanFilmleriOku(){
        try(BufferedReader reader= new BufferedReader(new FileReader("src/main/resources/com/ilkerkeklik/favorifilmlerim/filmler.txt"))){
            String film ;
            while((film=reader.readLine())!=null){

                String[] sep = film.split("\t");
                Film filmObject = new Film(sep[0],sep[1], LocalDate.parse(sep[2],formatter));
                list.add(filmObject);
            }
        }catch (IOException e){
            e.printStackTrace();
        }


    }

    public void veriTabaninaFilmleriYaz(){

        try(BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/com/ilkerkeklik/favorifilmlerim/filmler.txt"))){

            for(Film temp :list){

                writer.write(String.format("%s\t%s\t%s",temp.getBaslik(),temp.getDetay(),temp.getCikisTarihi().format(formatter)));
                writer.newLine();
            }


        }catch (IOException e){
            e.printStackTrace();
        }

    }


    public DateTimeFormatter getFormatter() {
        return formatter;
    }

    public ObservableList<Film> getList() {
        return list;
    }
}
