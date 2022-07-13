package com.example.ProjeINF202;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TourController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public TourController() {

        ObservableTourList = FXCollections.observableArrayList();
        for (TourInformationen tourInformationen : Database.getTourInfo()) {
            ObservableTourList.add(tourInformationen);
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Tourlist.setItems(ObservableTourList);
        Tourlist.setCellFactory(tourListView -> new TourListView());

    }
    @FXML
    private ListView<TourInformationen> Tourlist;

    private ObservableList<TourInformationen> ObservableTourList;

    @FXML
    private Button bevorbutton;

    @FXML
    private Button nextbutton;

    @FXML
    private Button AddTourButon;

    @FXML
    private Button ButtonLöschen;


    @FXML
    void onaddTourbuttonClicked(ActionEvent event) throws IOException {
        root = FXMLLoader.load(AddTourController.class.getResource("AddTour.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }


    @FXML
    void onbevorbuttonClicked(ActionEvent event) throws IOException {
        root = FXMLLoader.load(homeController.class.getResource("homepage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void OnClicekedButtonLöschen(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Warnung Operation");
        alert.setHeaderText("Löschen Sie diese Tourinformationen");
        //alert.setContentText("Wenden Sie sich dazu an den Administrator!");
        if(alert.showAndWait().get() == ButtonType.OK)   {
        Database.DeleteTourFromDb(Tourlist.getSelectionModel().getSelectedItem());
        Tourlist.getItems().remove(Tourlist.getSelectionModel().getSelectedItem());
        }
    }



    @FXML
    void onnextbuttonClicked(ActionEvent event) {


    }



}
