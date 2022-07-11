package com.example.ProjeINF202;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class MehrTourInfoController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private TourInformationen tourInfo;


    @FXML
    private Button ButtonSave;

    @FXML
    private Button ButtonZurück;

    @FXML
    private Button AddKundeButton;

    @FXML
    private Label HotelLabel;

    @FXML
    private Label IdLabel;

    @FXML
    private Label KapazitatLabel;

    @FXML
    private ListView<?> KundeInfoList;

    @FXML
    private Label NameLabel;

    @FXML
    private Label OrtLabel;

    @FXML
    private Label PreisLabel;

    @FXML
    private Label TagesablaufLabel;

    @FXML
    private Label TransportmittelnLabel;

    @FXML
    private Label ZeitraumLabel;

    @FXML
    private GridPane GridPane;

    @FXML
    void OnClickedButtonAddKunde(ActionEvent event) {

    }

    @FXML
    void OnClickedButtonSave(ActionEvent event) {

    }

    @FXML
    void OnClickedButtonZurück(ActionEvent event) throws IOException {

        root = FXMLLoader.load(homeController.class.getResource("Tourenview.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }
    public void setTourInfo(TourInformationen tourInformationen){
        tourInfo = tourInformationen;
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(() -> {

            IdLabel.setText(String.valueOf(tourInfo.getId()));
            PreisLabel.setText(String.valueOf(tourInfo.getPreis()));
            NameLabel.setText(tourInfo.getTourname());
            TagesablaufLabel.setText(tourInfo.getTagesablauf());
            KapazitatLabel.setText(String.valueOf(tourInfo.getKapazitat()));
            HotelLabel.setText(tourInfo.getHotels());
            OrtLabel.setText(tourInfo.getOrt());
            ZeitraumLabel.setText(String.valueOf(tourInfo.getZeitraum()));
            TransportmittelnLabel.setText(tourInfo.getTransportmittel());


        });



    }




}


