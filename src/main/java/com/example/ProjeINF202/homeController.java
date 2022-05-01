package com.example.ProjeINF202;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class homeController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button btnBüropersonal;

    @FXML
    private Button btnITManager;

    @FXML
    private Button btnKunde;

    @FXML
    private ChoiceBox<String> btnInfo;

    private String[] Aktionen = {"Add Kunde" , "Aktualisieren Kunde","Add BüroPersonal"};


    @FXML
    public void initialize() {

        btnInfo.getItems().addAll(Aktionen);
    }
    @FXML
    public void onbtnKundeClick (ActionEvent event) throws Exception {
        root = FXMLLoader.load(kundeController.class.getResource("kundepage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



}


