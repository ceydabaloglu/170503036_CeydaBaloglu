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
    private Button ButtonZurück;

    @FXML
    private TextField adresse_field;

    @FXML
    private TextField alter_field;

    @FXML
    private TextField benutzer_rolle_field;

    @FXML
    private TextField benutzername_field;

    @FXML
    private Button buttonsave;

    @FXML
    private TextField email_field;

    @FXML
    private TextField name_field;

    @FXML
    private TextField passwort_field;

    @FXML
    private TextField tc_field;

    @FXML
    private TextField telefonnum_field;

    @FXML
    private TextField vorname_field;

    @FXML
    void OnClickedButtonZurück(ActionEvent event) throws IOException {
        root = FXMLLoader.load(TourController.class.getResource("BüroPersonpage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    void OnClickedButtonSave(ActionEvent event) throws IOException {
        BüroPersonal büroPersonal = new BüroPersonal(
                Integer.valueOf(tc_field.getText()),
                name_field.getText(),
                vorname_field.getText(),
                Integer.valueOf(telefonnum_field.getText()),
                adresse_field.getText(),
                email_field.getText(),
                Integer.valueOf(alter_field.getText()),
                benutzer_rolle_field.getText(),
                benutzername_field.getText(),
                passwort_field.getText());

        Database.CreateNewBüroPersonalToDb(büroPersonal);

        root = FXMLLoader.load(BüroPersonController.class.getResource("BüroPersonpage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
