package com.example.ProjeINF202;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;

public class Database {
    public  static Connection conn = null;
    public static Statement stmt;


    public static void connect() {
        try {
            // db parameters
            String url = "jdbc:sqlite:/Users/macbook/IdeaProjects/170503036_Ceyda_Baloglu/src/main/java/com/example/ProjeINF202/TourSystem.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");
            //Statement stmt = conn.createStatement();
            //ResultSet res = stmt.executeQuery("SELECT * FROM Person");
            /*if(res.next()){
                System.out.println("username: "+res.getString("person_name")+" Pass: "+res.getString("person_vorname"));
            }*/
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static Boolean containBüropersonal(String benutzername,String passwort){
        try{
            Statement stmt = conn.createStatement();
            ResultSet res =stmt.executeQuery("SELECT benutzername , passwort FROM Büropersonal");
            while(res.next()){
                String s1 = res.getString("Benutzername");
                String s2 = res.getString("Passwort");
                if(s1.equals(benutzername) && s2.equals(passwort)) {
                    return true;
                }
            }
        }catch (Exception e) {
            System.out.println(e);
        }
        return false;

    }
    public static ObservableList<TourInformationen> getTourInfo(){
        ObservableList<TourInformationen> arr = FXCollections.observableArrayList();
        try {
           // ObservableList<TourInformationen> List = FXCollections.observableArrayList();
            Statement stmt = conn.createStatement();
            ResultSet res =stmt.executeQuery("SELECT Id, Tourname, Zeitraum, Kapazität, Transportmitteln, Preis, Tagesablauf , Hotel, Ort  FROM TourInfo");
            while(res.next()){
            int s1 = res.getInt("Id");
            String s2 = res.getString("Tourname");
            String s3 = res.getString("Zeitraum");
            int s4 = res.getInt("Kapazität");
            String s5 = res.getString("Transportmitteln");
            int s6 = res.getInt("Preis");
            String s7 = res.getString("Tagesablauf");
            String s8 = res.getString("Hotel");
            String s9 = res.getString("Ort");

            arr.add(new TourInformationen(s1,s2,s3,s4,s5,s6,s7,s9,s8));
            }
            return arr;

        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }

    }

    public static ObservableList<BüroPersonal> getBüroPersonalnfo(){
        ObservableList<BüroPersonal> arr = FXCollections.observableArrayList();
        try{
            Statement stmt = conn.createStatement();
            ResultSet res =stmt.executeQuery("SELECT Büropersonal_name ,  Büropersonal_vorname ,Büropersonal_email FROM Büropersonal");
            while(res.next()){
                String s = res.getString("Büropersonal_name");
                String s1 =res.getString("Büropersonal_vorname");
                String s2 =res.getString("Büropersonal_email");

                arr.add(new BüroPersonal(s ,s1 ,s2));
            }
            return arr;
        }catch (SQLException e){
            System.out.println(e);
            return null;

        }

    }
}
