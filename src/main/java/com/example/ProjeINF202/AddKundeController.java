package com.example.ProjeINF202;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddKundeController implements Initializable {
        private Stage stage;
        private Scene scene;
        private Parent root;
        private Kunde kundeInfo;
        private boolean IsUpdate = false;


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
        private Label errorMessageLabel;


        @FXML
        void OnbuttonsaveCliecked(ActionEvent event) throws IOException {


                if( name_field.getText().isEmpty() || vorname_field.getText().isEmpty() ||
                        email_field.getText().isEmpty() || alter_field.getText().isEmpty() || tc_field.getText().isEmpty()
                        || telefonnummer_field.getText().isEmpty() || kundennummer_field.getText().isEmpty())  {

                        errorMessageLabel.setText("Fehlende Informationen");

                }else{
                        if(IsUpdate == true){
                            kundeInfo.setAll(Integer.valueOf(tc_field.getText()) ,
                                    adresse_field.getText(),
                                    name_field.getText(),
                                    vorname_field.getText(),
                                    Integer.valueOf(telefonnummer_field.getText()),
                                    email_field.getText() ,
                                    Integer.valueOf(alter_field.getText()));
                            System.out.println("bURDAYIM");
                            Database.UpdateKunde(kundeInfo);
                        }else{
                                Kunde KundeInfo = new Kunde(
                                        Integer.valueOf(kundennummer_field.getText()),
                                        Integer.valueOf(tc_field.getText()) ,
                                        Integer.valueOf(telefonnummer_field.getText()),
                                        name_field.getText(),
                                        vorname_field.getText(),
                                        adresse_field.getText(),
                                        email_field.getText() ,
                                        Integer.valueOf(alter_field.getText())
                                );
                                Database.CreateNewKundeToDb(KundeInfo);
                        }


                root = FXMLLoader.load(KundeController.class.getResource("Kundepage.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                }


        }

        @FXML
        void onbuttonZurueckClicked(ActionEvent event) throws IOException {
            root = FXMLLoader.load(KundeController.class.getResource("Kundepage.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

        public void setKundeInfo(Kunde kunde,boolean Isupdate){
                kundeInfo = kunde;
                IsUpdate = Isupdate;
        }

        @Override
        public void initialize(URL location, ResourceBundle resources) {

                Platform.runLater(() -> {
                        if(IsUpdate){
                                kundennummer_field.setText(String.valueOf(kundeInfo.getKundennummer()));
                                tc_field.setText(String.valueOf(kundeInfo.gettc_no()));
                                name_field.setText(kundeInfo.getName());
                                vorname_field.setText(kundeInfo.getVorname());
                                telefonnummer_field.setText(String.valueOf(kundeInfo.getTelefonnummer()));
                                adresse_field.setText(kundeInfo.getAdress());
                                email_field.setText(kundeInfo.getEmail());
                                alter_field.setText(String.valueOf(kundeInfo.getAlter()));

                        }



                });
        }
}
