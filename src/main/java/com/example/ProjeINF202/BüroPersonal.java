package com.example.ProjeINF202;

public class BüroPersonal extends Person {


    public BüroPersonal(String rolle, String benutzername, String password, String name, String vorname, String email, String adress, int tc_no, int alter,int telefonnumber) {
        super(tc_no, name, vorname, telefonnumber, adress, email, alter);
        Rolle = rolle;
        Benutzername = benutzername;
        Passwort = password;
    }





    protected String Rolle;
    protected String Benutzername;
    protected String Passwort;




    public String getRolle() {

        return Rolle;
    }

    public void setRolle(String rolle) {

        this.Rolle = rolle;
    }

    public String getBenutzername() {

        return Benutzername;
    }

    public void setBenutzername(String benutzername) {

        this.Benutzername = benutzername;
    }

    public void setPasswort(String passwort) {

        this.Passwort = passwort;
    }

    public String getPasswort() {

        return Passwort;
    }
    public void AddKunde(){


    }
    public void updateKundeInfo(){

    }
    public void updateTourInfo(){

    }

}