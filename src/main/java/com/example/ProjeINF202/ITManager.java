package com.example.ProjeINF202;

public class ITManager extends Person {

    public ITManager(int tc_no, String name, String vorname, int telefonnumber, String adress, String email, int alter, int passwort) {
        super(tc_no, name, vorname, telefonnumber, adress, email, alter);
        Passwort = passwort;
    }

    private String rolle;
    private String Benutzername;
    private int Passwort;

    public void ITManager(String rolle , String Benutzername){
        this.rolle = rolle;
        this.Benutzername = Benutzername;
    }

    public void setAll(String r ,String b ,int p ){
        rolle = r;
        Benutzername = b;
        Passwort = p;
    }
    public String getRolle(){
        return rolle;
    }
    public String getBenutzername(){
        return Benutzername;
    }

    //Die Fonksion der ITmanager Class
    public void erstellenkonto(){

    }

    public void control(){

    }
}
