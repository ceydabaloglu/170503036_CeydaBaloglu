package com.example.ProjeINF202;

public class BüroPersonal extends Person {


    public BüroPersonal(int tc_no, String name, String vorname, int telefonnumber, String adress, String email, int alter) {
        super(tc_no, name, vorname, telefonnumber, adress, email, alter);

    }

    protected String rolle;
    protected String Benutzername;
    protected int Passwort;
   // private String Büropersonal_name;
   // private String Büropersonal_vorname;
    //private String Büropersonal_email;
    //private String Büropersonal_adresse;



    public String getRolle() {

        return rolle;
    }

    public void setRolle(String rolle) {

        this.rolle = rolle;
    }

    public String getBenutzername() {

        return Benutzername;
    }

    public void setBenutzername(String benutzername) {

        this.Benutzername = benutzername;
    }

    public void setPasswort(int passwort) {

        this.Passwort = passwort;
    }

    public int getPasswort() {

        return Passwort;
    }
    public void AddKunde(){


    }
    public void updateKundeInfo(){

    }
    public void updateTourInfo(){

    }

}
