package com.example.hayatimdakiinsanlar;

public class Insan implements Comparable<Insan> {
    private String isim;
    private String meslek;
    private int yas;
    private String sehir;
    private String neyim;

    public Insan(String isim, String meslek, int yas, String sehir, String neyim) {
        this.isim = isim;
        this.meslek = meslek;
        this.yas = yas;
        this.sehir = sehir;
        this.neyim = neyim;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getMeslek() {
        return meslek;
    }

    public void setMeslek(String meslek) {
        this.meslek = meslek;
    }

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }

    public String getSehir() {
        return sehir;
    }

    public void setSehir(String sehir) {
        this.sehir = sehir;
    }

    public String getNeyim() {
        return neyim;
    }

    public void setNeyim(String neyim) {
        this.neyim = neyim;
    }


    @Override
    public int compareTo(Insan o) {
        if(this.yas>o.yas){
            return 1;
        }else if(this.yas<o.yas){
            return -1;
        }else return 0;

    }

    @Override
    public String toString() {
        return "Insan{" +
                "isim='" + isim + '\'' +
                ", meslek='" + meslek + '\'' +
                ", yas=" + yas +
                ", sehir='" + sehir + '\'' +
                ", neyim='" + neyim + '\'' +
                '}';
    }
}
