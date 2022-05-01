package com.example.ProjeINF202;

import java.sql.*;

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


}
