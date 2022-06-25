package com.example.ProjeINF202;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class KundeController   {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnLösche;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button bevorbuton;

    @FXML
    private Pane pane;

    @FXML
    private ListView<Kunde> kundelist;

    @FXML
    void onbevorbutonCliecked(ActionEvent event) throws IOException {
        root = FXMLLoader.load(homeController.class.getResource("homepage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void OnbtnAddCliecked(ActionEvent event) throws IOException {
        root = FXMLLoader.load(AddKundeController.class.getResource("AddKunde.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
