package com.example.ProjeINF202;

public class Kunde extends Person {


    protected int Kundennummer;

    public Kunde(int tc_no, String name, String vorname, int telefonnumber, String adress, String email, int alter) {
        super(tc_no, name, vorname, telefonnumber, adress, email, alter);
    }

    public void setKundennummer(int kundeno){

        this.Kundennummer = kundeno;
    }
    public int getKundennummer(){

        return Kundennummer;
    }
}
