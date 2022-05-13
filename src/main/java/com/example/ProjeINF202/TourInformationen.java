package com.example.ProjeINF202;

public class TourInformationen  {
    private int Id;
    private String Tourname;
    private String Ort ;
    private String Hotels;
    private String Zeitraum;
    private int Kapazitat;
    private String Transportmittel;
    private int Preis;
    private String Tagesablauf;

    public int getId(){
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getTourname(){
        return Tourname;
    }

    public void setTourname(String tourname) {
        this.Tourname = tourname;
    }

    public String getOrt() {

        return Ort;
    }

    public void setOrt(String ort) {

        this.Ort = ort;
    }

    public String getHotels() {

        return Hotels;
    }

    public void setHotels(String hotels) {

        this.Hotels = hotels;
    }

    public String getZeitraum() {

        return Zeitraum;
    }

    public void setZeitraum(String zeitraum) {

        this.Zeitraum = zeitraum;
    }

    public int getKapazitat() {

        return Kapazitat;
    }

    public void setKapazitat(int kapazitat) {

        this.Kapazitat = kapazitat;
    }

    public String getTransportmittel() {

        return Transportmittel;
    }

    public void setTransportmittel(String transportmittel) {

        this.Transportmittel = transportmittel;
    }

    public int getPreis() {

        return Preis;
    }

    public void setPreis(int preis) {

        this.Preis = preis;
    }

    public String getTagesablauf() {

        return Tagesablauf;
    }

    public void setTagesablauf(String tagesablauf) {

        Tagesablauf = tagesablauf;
    }
    public void addHotels(){

    }
    public void addKunde(){
        //***
    }
    public void sucheOrt(){

    }
    public void sucheDatum(){

    }
}
