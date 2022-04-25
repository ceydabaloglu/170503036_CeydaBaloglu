package com.example.ProjeINF202;
import java.io.IOException;
import java.sql.*;
import java.util.Set;

public class Database {
    public  static Connection conn = null;
    public static void connect() {
        try {
            // db parameters
            String url = "jdbc:sqlite:/Users/macbook/IdeaProjects/170503036_Ceyda_Baloglu/src/main/java/com/example/ProjeINF202/TourSystem.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM Person");
            if(res.next()){
                System.out.println("username: "+res.getString("person_name")+" Pass: "+res.getString("person_vorname"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
