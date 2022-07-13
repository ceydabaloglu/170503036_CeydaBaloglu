package com.example.ProjeINF202;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddBüroPersonalController  implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
    private BüroPersonal büroPersonalInfo;
    private boolean IsUpdate = false;

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
    private Label ErrorMessageLabel;

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
        if(Database.rolle.equals("Reiseveranstalter")){
            ErrorMessageLabel.setText("Sie haben keine Erlaubnis  ");
            return ;
        }

        if(tc_field.getText().isEmpty() || name_field.getText().isEmpty() || vorname_field.getText().isEmpty() ||
           telefonnum_field.getText().isEmpty() || adresse_field.getText().isEmpty() || email_field.getText().isEmpty()
          || benutzer_rolle_field.getText().isEmpty() || benutzername_field.getText().isEmpty() || passwort_field.getText().isEmpty()) {

            ErrorMessageLabel.setText("Fehlende Informationen");
        }else {
            if(IsUpdate == true){
                büroPersonalInfo.setAll(Integer.valueOf(tc_field.getText()) ,
                        adresse_field.getText(),
                        name_field.getText(),
                        vorname_field.getText(),
                        Integer.valueOf(telefonnum_field.getText()),
                        email_field.getText() ,
                        Integer.valueOf(alter_field.getText()));
                Database.UpdateBüroPersonal(büroPersonalInfo);

            }else{
                BüroPersonal büroPersonal = new BüroPersonal(
                        benutzer_rolle_field.getText(),
                        benutzername_field.getText(),
                        passwort_field.getText(),
                        name_field.getText(),
                        vorname_field.getText(),
                        email_field.getText(),
                        adresse_field.getText(),
                        Integer.valueOf(tc_field.getText()),
                        Integer.valueOf(alter_field.getText()),
                        Integer.valueOf(telefonnum_field.getText()));

                Database.CreateNewBüroPersonalToDb(büroPersonal);
            }



        root = FXMLLoader.load(BüroPersonController.class.getResource("BüroPersonpage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        }
    }

    public void setBüroPersonInfo(BüroPersonal büroPersonal,boolean Isupdate){
        büroPersonalInfo = büroPersonal;
        IsUpdate = Isupdate;

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Platform.runLater(() -> {
            if(IsUpdate){
                benutzer_rolle_field.setText((büroPersonalInfo.getRolle()));
                benutzername_field.setText((büroPersonalInfo.getBenutzername()));
                passwort_field.setText(büroPersonalInfo.getPasswort());
                name_field.setText(büroPersonalInfo.getName());
                vorname_field.setText(büroPersonalInfo.getVorname());
                email_field.setText(büroPersonalInfo.getEmail());
                adresse_field.setText(büroPersonalInfo.getAdress());
                tc_field.setText(String.valueOf(büroPersonalInfo.gettc_no()));
                telefonnum_field.setText(String.valueOf(büroPersonalInfo.getTelefonnummer()));
                alter_field.setText(String.valueOf(büroPersonalInfo.getAlter()));

            }



        });
    }

}
