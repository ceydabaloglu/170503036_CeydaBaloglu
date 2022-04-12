package com.example.ProjeINF202;

public class OfficePersonal extends Person {

    public  OfficePersonal(int tc_no, String name, String vorname, int telefonnumber, String adress, String email, int alter) {
        super(tc_no, name, vorname, telefonnumber, adress, email, alter);

    }

    protected String rolle;
    protected String Benutzername;
    protected int Passwort;


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

        Benutzername = benutzername;
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
