package com.example.ProjeINF202;

public class Person {

    private int tc_no;
    private String Name;
    private String Vorname;
    private int Telefonnummer;
    private String Adress;
    private String Email;
    private int Alter;



    public Person(int tc_no, String name,String vorname , int telefonnumber,
                  String adress,String email,int alter ) {
        this.tc_no = tc_no;
        this.Adress = adress;
        this.Name = name;
        this.Vorname = vorname;
        this.Telefonnummer = telefonnumber;
        this.Email = email;
        this.Alter = alter;
    }
    //SADECE GENEL BİLGİ VERMEK İÇİN
    public Person(String name,String vorname, String email){
        this.Name = name;
        this.Vorname = vorname;
        this.Email = email;
    }
    public void setAll(int tc ,String ad, String n ,String v, int tel, String e , int al){
        this.tc_no = tc;
        this.Adress = ad;
        this.Name = n;
        this.Vorname = v;
        this.Telefonnummer = tel;
        this.Email = e;
        this.Alter = al;
    }
    //name-vorname-adress lenght belirle
    //yaş sınırı ayarla

    public int gettc_no(){

        return tc_no;
    }
    public String getVorname(){
        return Vorname;

    }

    public String getName(){

        return Name;
    }
    public int getAlter(){
        return Alter;
    }

    public int getTelefonnummer(){
        return Telefonnummer;
    }
    public String getAdress(){
        return Adress;
    }
    public String getEmail(){
        return Email;
    }
}