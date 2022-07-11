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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BüroPersonController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    public BüroPersonController() {

        ObservableBüropersonalList = FXCollections.observableArrayList();
        for (BüroPersonal  büropersonal :Database.getBüroPersonalnfo()) {
            ObservableBüropersonalList.add(büropersonal);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        BüropersonalList.setItems(ObservableBüropersonalList);
        BüropersonalList.setCellFactory(tourListView -> new BüroPersonListView());

    }

    @FXML
    private ListView<BüroPersonal> BüropersonalList;

    private ObservableList<BüroPersonal> ObservableBüropersonalList;


    @FXML
    private Button btnAdd;

    @FXML
    private Button btnupdate;

    @FXML
    private Button btnzurück;

    @FXML
    private Button btnLöschen;

    @FXML
    private Label ErrorMessageLabel;



    @FXML
    void onbtnzurückCliecked(ActionEvent event) throws IOException {
        root = FXMLLoader.load(homeController.class.getResource("homepage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    void OnbtnAddCliecked(ActionEvent event) throws IOException {
        root = FXMLLoader.load(AddBüroPersonalController.class.getResource("AddBüroPersonal.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void OnbtnLöschenCliecked(ActionEvent event) {


            Database.DeleteBüroPersonalFromDb(BüropersonalList.getSelectionModel().getSelectedItem());
            BüropersonalList.getItems().remove(BüropersonalList.getSelectionModel().getSelectedItem());


    }


}
