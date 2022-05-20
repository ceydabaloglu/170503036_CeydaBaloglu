package com.example.ProjeINF202;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

public class BüroPersonController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ListView<OfficePersonal> BüropersonaList;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnupdate;

    @FXML
    private Button btnzurück;

    @FXML
    void onbtnzurückCliecked(ActionEvent event) throws IOException {
        root = FXMLLoader.load(homeController.class.getResource("homepage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }


}
