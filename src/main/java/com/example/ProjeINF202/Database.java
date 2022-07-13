package com.example.ProjeINF202;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;

public class Database {
    public  static Connection conn = null;
    public static Statement stmt;
    public static String rolle;


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
            ResultSet res =stmt.executeQuery("SELECT benutzername , passwort ,Büropersonal_rolle FROM Büropersonal");
            while(res.next()){
                String s1 = res.getString("Benutzername");
                String s2 = res.getString("Passwort");
                if(s1.equals(benutzername) && s2.equals(passwort)) {
                    rolle = res.getString("Büropersonal_rolle");
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
            ResultSet res =stmt.executeQuery("SELECT Büropersonal_rolle,benutzername,passwort,Büropersonal_name ,  Büropersonal_vorname ,Büropersonal_email , Büropersonal_adresse,Büropersonal_tc,Büropersonal_alter,Büropersonal_telefonnum FROM Büropersonal");
            while(res.next()){
                String s = res.getString("Büropersonal_rolle");
                String s1 = res.getString("benutzername");
                String s2 =res.getString("passwort");
                String s3 = res.getString("Büropersonal_name");
                String s4 =res.getString("Büropersonal_vorname");
                String s5 =res.getString("Büropersonal_email");
                String s6 =res.getString("Büropersonal_adresse");
                int s7 =res.getInt("Büropersonal_tc");
                int s8 =res.getInt("Büropersonal_alter");
                int s9 =res.getInt("Büropersonal_telefonnum");

                arr.add(new BüroPersonal(s,s1,s2,s3,s4,s5,s6,s7,s8,s9));
            }
            return arr;
        }catch (SQLException e){
            System.out.println(e);
            return null;

        }

    }
    public static ObservableList<Kunde> getKundeInfo(){
        ObservableList<Kunde> arr = FXCollections.observableArrayList();
        try{
            Statement stmt = conn.createStatement();
            ResultSet res =stmt.executeQuery("SELECT Kundennummer, TC_nummer,Telefonnummer,Name ,  Vorname ,Adresse,Email ,KundeAge FROM Kunde");
            while(res.next()){
                int s = res.getInt("Kundennummer");
                int s1 =res.getInt("TC_nummer");
                int s2 =res.getInt("Telefonnummer");
                String s3 =res.getString("Name");
                String s4 =res.getString("Vorname");
                String s5 =res.getString("Adresse");
                String s6 =res.getString("Email");
                int s7 =res.getInt("KundeAge");


                arr.add(new Kunde(s,s1 ,s2,s3,s4,s5,s6,s7));
            }
            return arr;
        }catch (SQLException e){
            System.out.println(e);
            return null;

        }

    }
    public static void CreateNewTourToDb(TourInformationen tourInfo){


        String sql = "INSERT INTO TourInfo(Id ,Tourname, Zeitraum, Kapazität, Transportmitteln, Preis, Tagesablauf , Hotel, Ort) VALUES(?,?,?,?,?,?,?,?,?)";

        try (

                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, tourInfo.getId());

            pstmt.setString(2, tourInfo.getTourname());

            pstmt.setString(3, tourInfo.getZeitraum());

            pstmt.setInt(4, tourInfo.getKapazitat());

            pstmt.setString(5, tourInfo.getTransportmittel());

            pstmt.setInt(6, tourInfo.getPreis());

            pstmt.setString(7, tourInfo.getTagesablauf());

            pstmt.setString(8, tourInfo.getHotels());

            pstmt.setString(9, tourInfo.getOrt());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void DeleteTourFromDb(TourInformationen tourInfo){
        String sql = "DELETE FROM TourInfo WHERE id = ?";

        try (
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setInt(1, tourInfo.getId());
            // execute the delete statement
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void CreateNewKundeToDb(Kunde KundeInfo){


        String sql = "INSERT INTO Kunde( Kundennummer,TC_nummer ,Telefonnummer, Name ,Vorname, Adresse, Email, KundeAge) VALUES(?,?,?,?,?,?,?,?)";

        try (

                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, KundeInfo.getKundennummer());

            pstmt.setInt(2, KundeInfo.gettc_no());

            pstmt.setInt(3, KundeInfo.getTelefonnummer());

            pstmt.setString(4, KundeInfo.getName());

            pstmt.setString(5, KundeInfo.getVorname());

            pstmt.setString(6, KundeInfo.getAdress());

            pstmt.setString(7, KundeInfo.getEmail());

            pstmt.setInt(8, KundeInfo.getAlter());






            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void DeleteKundeFromDb(Kunde kunde){
        String sql = "DELETE FROM Kunde WHERE Kundennummer = ?";

        try (
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setInt(1, kunde.getKundennummer());
            // execute the delete statement
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void CreateNewBüroPersonalToDb(BüroPersonal büroPersonal){


        String sql = "INSERT INTO Büropersonal( Büropersonal_rolle,benutzername ,passwort, Büropersonal_name ,Büropersonal_vorname, Büropersonal_email, Büropersonal_adresse,Büropersonal_tc,Büropersonal_alter,Büropersonal_telefonnum) VALUES(?,?,?,?,?,?,?,?,?,?)";

        try (

                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, büroPersonal.getRolle());

            pstmt.setString(2, büroPersonal.getBenutzername());

            pstmt.setString(3, büroPersonal.getPasswort());

            pstmt.setString(4, büroPersonal.getName());

            pstmt.setString(5, büroPersonal.getVorname());

            pstmt.setString(6, büroPersonal.getEmail());

            pstmt.setString(7, büroPersonal.getAdress());

            pstmt.setInt(8, büroPersonal.gettc_no());

            pstmt.setInt(9, büroPersonal.getAlter());

            pstmt.setInt(10, büroPersonal.getTelefonnummer());


            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void DeleteBüroPersonalFromDb(BüroPersonal büroPersonal){
        String sql = "DELETE FROM Büropersonal WHERE Büropersonal_name = ?";

        try (
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, büroPersonal.getName());
            // execute the delete statement
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void addTourKundeInfo (Integer TourId, Integer Kundennummer){

       String sql = "INSERT INTO TourInfoKunde (TourId,Kundennummer ) VALUES(?,?)";
        try (

                PreparedStatement pstmt = conn.prepareStatement(sql)) {


            pstmt.setInt(1,TourId);

            pstmt.setInt(2, Kundennummer);


            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static ObservableList<Kunde> getKundenVonTour(int TourId){

        ObservableList<Kunde> arr = FXCollections.observableArrayList();
        String sql = "SELECT Kundennummer "
                + "FROM TourInfoKunde WHERE TourId = ?";

        try (
                PreparedStatement pstmt  = conn.prepareStatement(sql)){

            // set the value
            pstmt.setInt(1,TourId);
            //
            ResultSet rs  = pstmt.executeQuery();

            // loop through the result set
            while (rs.next()) {
                Kunde x = getKundefromDb(rs.getInt("Kundennummer"));
                arr.add(x);
            }
            return arr;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public static Kunde getKundefromDb(int Kundennummer){
        String sql = "SELECT Kundennummer, TC_nummer,Telefonnummer,Name ,  Vorname ,Adresse,Email ,KundeAge FROM Kunde WHERE Kundennummer = ?";

        try (
                PreparedStatement pstmt  = conn.prepareStatement(sql)){

            // set the value
            pstmt.setDouble(1,Kundennummer);
            //
            ResultSet res  = pstmt.executeQuery();

            // loop through the result set
            while (res.next()) {
                int s = res.getInt("Kundennummer");
                int s1 =res.getInt("TC_nummer");
                int s2 =res.getInt("Telefonnummer");
                String s3 =res.getString("Name");
                String s4 =res.getString("Vorname");
                String s5 =res.getString("Adresse");
                String s6 =res.getString("Email");
                int s7 =res.getInt("KundeAge");

                return new Kunde(s,s1 ,s2,s3,s4,s5,s6,s7);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return null;
    }


}
