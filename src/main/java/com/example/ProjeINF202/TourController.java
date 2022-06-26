package com.example.ProjeINF202;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    @FXML
    private ListView<String> TourList;

    @FXML
    private Label labelTourListen;

    @FXML
    private Button bevorbutton;

    @FXML
    private Button nextbutton;

    @FXML
    private Button AddTourButon;


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
    void onnextbuttonClicked(ActionEvent event) {


    }




   /* public void SetListView(){
        Database.connect();
        Tourlist.setItems(Database.getTourInfoFromDatabase());
        Tourlist.setCellFactory(new Callback<ListView<TourInformationen>, ListCell<TourInformationen>>()
        {
            @Override
            public ListCell<TourInformationen> call(ListView<TourInformationen> listView)
            {
                return new ListCell();
            }
        });

    }*/


}
