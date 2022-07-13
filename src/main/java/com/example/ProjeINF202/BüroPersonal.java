package com.example.ProjeINF202;

public class BüroPersonal extends Person {


    public BüroPersonal(int tc_no, String name, String vorname, int telefonnumber, String adress, String email, int alter, String rolle, String benutzername,String password) {
        super(tc_no, name, vorname, telefonnumber, adress, email, alter);
        Rolle = rolle;
        Benutzername = benutzername;
        Passwort = password;
    }

    public BüroPersonal(String name, String vorname, String email){
        super(name, vorname, email);

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