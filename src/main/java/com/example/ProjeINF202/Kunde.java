package com.example.ProjeINF202;

public class Kunde extends Person {


    public Kunde(int tc_no, String name, String vorname, int telefonnumber, String adress, String email, int alter, int kundennummer) {
        super(tc_no, name, vorname, telefonnumber, adress, email, alter);

        Kundennummer = kundennummer;

    }

    public Kunde(int kundennummer,int tc_no,int telefonnumber,String name, String vorname,String adress, String email,int alter){

        super(name, vorname, email);
        Kundennummer = kundennummer;
    }


    protected int Kundennummer;

    public void setKundennummer(int kundenummer){

        this.Kundennummer = kundenummer;
    }
    public int getKundennummer(){

        return Kundennummer;
    }
}
