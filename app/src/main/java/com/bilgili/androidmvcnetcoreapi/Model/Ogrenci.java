package com.bilgili.androidmvcnetcoreapi.Model;

public class Ogrenci {

    private Integer Numara;
    private String Sifre;


    public Ogrenci(){

    }

    public Ogrenci(Integer numara, String sifre) {
        Numara = numara;
        Sifre = sifre;
    }

    public Integer getNumara() {
        return Numara;
    }

    public void setNumara(Integer numara) {
        Numara = numara;
    }

    public String getSifre() {
        return Sifre;
    }

    public void setSifre(String sifre) {
        Sifre = sifre;
    }
}