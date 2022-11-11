package com.example.hayatimdakiinsanlar;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import java.util.Collections;

public class Ben extends Insan {

    private ObservableList<Insan> insanListem = FXCollections.observableArrayList();


    public Ben(String isim, String meslek, int yas, String sehir, String neyim) {
        super(isim, meslek, yas, sehir, neyim);
    }

    //insan listede yoksa basariyla eklenir ve true dondurur
    public boolean listemeInsanEkle(Insan insan){
        if(!insanListem.contains(insan)){
            insanListem.add(insan);
            return true;
        }
        return false;
    }

    //insan listesinde varsa basariyla cikarir ve false dondurur
    public boolean listemdenInsanCikart(Insan insan){
        if(insanListem.contains(insan)){
            insanListem.remove(insan);
            return true;
        }
        return false;
    }

    //listeyi siralar baska listeye kopyalar ardindan dondurur
    public ObservableList<Insan> listeyiSiralayipDondur(){
        Collections.sort(insanListem);
        ObservableList<Insan> insanlar = FXCollections.observableArrayList(insanListem);
        return insanlar;
    }

    public void listeyiBosalt(){
        insanListem.clear();
    }

    public ObservableList<Insan> getInsanListem() {

        // Listeye doğrudan erişime izin vermiyorum
        ObservableList<Insan> insans = FXCollections.observableArrayList(insanListem);

        return insans;
    }
}
