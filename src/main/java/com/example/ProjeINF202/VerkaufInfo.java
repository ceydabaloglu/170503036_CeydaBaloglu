package com.example.ProjeINF202;

import javafx.fxml.FXML;

import java.util.Date;
//implement veya interface aralarında bir bağ var ama ne olduğuna tekrar bak !!
//
public class VerkaufInfo {

    private int Preis;
    private Date Datum;
    private String NameTour;
    private String NameKunde;
    private int Kundennummer;

    public int getPreis() {
        return Preis;
    }

    public void setPreis(int preis) {

        Preis = preis;
    }

    public Date getDatum() {

        return Datum;
    }

    public void setDatum(Date datum) {

        Datum = datum;
    }

    public String getNameTour() {

        return NameTour;
    }

    public void setNameTour(String nameTour) {

        NameTour = nameTour;
    }

    public String getNameKunde() {

        return NameKunde;
    }

    public void setNameKunde(String nameKunde) {

        NameKunde = nameKunde;
    }

    public int getKundennummer() {

        return Kundennummer;
    }

    public void setKundennummer(int kundennummer) {

        Kundennummer = kundennummer;
    }
}
