package com.example.ProjeINF202;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BüroPersonController  {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ListView<BüroPersonal> BüropersonaList;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnupdate;

    @FXML
    private Button btnzurück;
    @FXML
    private TableColumn<BüroPersonal, String> benutzername;

    @FXML
    private TableColumn<BüroPersonal, String> rolle;

    @FXML
    private TableView<String> table;

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


   /* @Override
    public void initialize(URL location, ResourceBundle resources) {

        rolle.setCellValueFactory(new PropertyValueFactory<BüroPersonal,String>("rolle"));
        benutzername.setCellValueFactory(new PropertyValueFactory<BüroPersonal,String>("benutzername"));

        //getBüroPersonalInfo.setItems(List());
    }
    @FXML
    public ObservableList List(){
        ObservableList arr = Database.getBüropersonal();
        return arr;
    } */
}
