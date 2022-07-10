package com.example.ProjeINF202;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AddKundeController {
        private Stage stage;
        private Scene scene;
        private Parent root;

        @FXML
        private TextField adresse_field;

        @FXML
        private TextField alter_field;

        @FXML
        private Button buttonsave;

        @FXML
        private Button buttonzurueck;

        @FXML
        private TextField email_field;

        @FXML
        private TextField name_field;

        @FXML
        private TextField tc_field;

        @FXML
        private TextField telefonnummer_field;

        @FXML
        private TextField vorname_field;

        @FXML
        private TextField kundennummer_field;


        @FXML
        void OnbuttonsaveCliecked(ActionEvent event) throws IOException {
                Kunde KundeInfo = new Kunde(
                        Integer.valueOf(tc_field.getText()) ,
                        name_field.getText(),
                        vorname_field.getText(),
                        Integer.valueOf(telefonnummer_field.getText()),
                        adresse_field.getText(),
                        email_field.getText() ,
                        Integer.valueOf(alter_field.getText()),
                        Integer.valueOf(kundennummer_field.getText()));
                Database.CreateNewKundeToDb(KundeInfo);

                root = FXMLLoader.load(KundeController.class.getResource("Kundepage.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();


        }

        @FXML
        void onbuttonZurueckClicked(ActionEvent event) throws IOException {
            root = FXMLLoader.load(KundeController.class.getResource("Kundepage.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }


}
