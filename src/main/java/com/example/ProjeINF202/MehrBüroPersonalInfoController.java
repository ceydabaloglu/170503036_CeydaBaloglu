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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MehrBüroPersonalInfoController  implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
    private BüroPersonal büroPersonal;

    @FXML
    private Label AdresseLabel;

    @FXML
    private Label AlterLabel;

    @FXML
    private Label EmailLabel;

    @FXML
    private Label NameLabel;

    @FXML
    private Label RolleLabel;

    @FXML
    private Label TcLabel;

    @FXML
    private Label TelnoLabel;

    @FXML
    private Label VornameLabel;

    @FXML
    private Label benutzernameLabel;

    @FXML
    private Button zurückbutton;

    @FXML
    void OnClickedzurückbutton(ActionEvent event) throws IOException {
        root = FXMLLoader.load(homeController.class.getResource("BüroPersonpage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void setBüroPersonal(BüroPersonal büropersonal){
        büroPersonal = büropersonal;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(() -> {

            RolleLabel.setText(String.valueOf(büroPersonal.getRolle()));
            benutzernameLabel.setText(String.valueOf(büroPersonal.getBenutzername()));
            NameLabel.setText(büroPersonal.getName());
            VornameLabel.setText(büroPersonal.getVorname());
            EmailLabel.setText((büroPersonal.getEmail()));
            AdresseLabel.setText(büroPersonal.getAdress());
            AlterLabel.setText(String.valueOf(büroPersonal.getAlter()));
            TcLabel.setText(String.valueOf(büroPersonal.gettc_no()));
            TelnoLabel.setText(String.valueOf(büroPersonal.getTelefonnummer()));


        });



    }

}
