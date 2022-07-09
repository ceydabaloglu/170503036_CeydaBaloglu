package com.example.ProjeINF202;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AddBüroPersonalController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField Adresse;

    @FXML
    private TextField Name;

    @FXML
    private TextField Vorname;

    @FXML
    private TextField benutzer_rolle;

    @FXML
    private TextField benutzername;

    @FXML
    private Button buttonsave;

    @FXML
    private TextField email;

    @FXML
    private TextField passwort;

    @FXML
    private Button ButtonZurück;

    @FXML
    void OnClickedButtonZurück(ActionEvent event) throws IOException {
        root = FXMLLoader.load(TourController.class.getResource("BüroPersonpage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

}
