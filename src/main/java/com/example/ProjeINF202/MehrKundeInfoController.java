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
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MehrKundeInfoController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
    private Kunde kundeInfo;

    @FXML
    private Label AdressLabel;

    @FXML
    private Label AlterLabel;

    @FXML
    private Label EmailLabel;

    @FXML
    private Label KundeNoLabel;

    @FXML
    private Label NameLabel;

    @FXML
    private Label TcLabel;

    @FXML
    private Label TelefonnumLabel;

    @FXML
    private Label VornameLabel;

    @FXML
    private Button buttonZurück;

    @FXML
    private GridPane GridPane;



    public void setKundeInfo(Kunde kunde){

        kundeInfo = kunde;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(() -> {

            KundeNoLabel.setText(String.valueOf(kundeInfo.getKundennummer()));
            TcLabel.setText(String.valueOf(kundeInfo.gettc_no()));
            NameLabel.setText(kundeInfo.getName());
            VornameLabel.setText(kundeInfo.getVorname());
            TelefonnumLabel.setText(String.valueOf(kundeInfo.getTelefonnummer()));
            AdressLabel.setText(kundeInfo.getAdress());
            EmailLabel.setText(kundeInfo.getEmail());
            AlterLabel.setText(String.valueOf(kundeInfo.getAlter()));



        });
    }

    @FXML
    void OnClickedButtonZurück(ActionEvent event) throws IOException {
        root = FXMLLoader.load(homeController.class.getResource("Kundepage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}
