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

public class AddTourController {

        private Stage stage;
        private Scene scene;
        private Parent root;

        @FXML
        private Button buttonsave;

        @FXML
        private Button buttonzurueck;

        @FXML
        private TextField hotel_field;

        @FXML
        private TextField kapazitat_field;

        @FXML
        private TextField name_field;

        @FXML
        private TextField ort_field;

        @FXML
        private TextField preis_field;

        @FXML
        private TextField tagesablauf_field;

        @FXML
        private TextField transport_field;

        @FXML
        private TextField zeitraum_field;

        @FXML
        private TextField ıd_field;

        @FXML
        private Label ErrorMessageLabel;


        @FXML
        void onbuttonsaveCliecked(ActionEvent event) throws IOException{
                if(ıd_field.getText().isEmpty() || name_field.getText().isEmpty() || zeitraum_field.getText().isEmpty()
                || kapazitat_field.getText().isEmpty() || transport_field.getText().isEmpty() || preis_field.getText().isEmpty()
                || transport_field.getText().isEmpty() || preis_field.getText().isEmpty() || tagesablauf_field.getText().isEmpty()
                || hotel_field.getText().isEmpty() || ort_field.getText().isEmpty() ){

                        ErrorMessageLabel.setText("Fehlende Informationen");
                }else {

                TourInformationen tourInfo = new TourInformationen(Integer.valueOf(ıd_field.getText()),
                        name_field.getText(),
                        zeitraum_field.getText(),
                        Integer.valueOf(kapazitat_field.getText()),
                        transport_field.getText(),
                        Integer.valueOf(preis_field.getText()),
                        tagesablauf_field.getText(),
                        hotel_field.getText(),
                        ort_field.getText());
                Database.CreateNewTourToDb(tourInfo);

                root = FXMLLoader.load(TourController.class.getResource("Tourenview.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                }
        }

        @FXML
        void onbuttonzurueckCliecked(ActionEvent event) throws IOException {
            root = FXMLLoader.load(TourController.class.getResource("Tourenview.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }



    }


