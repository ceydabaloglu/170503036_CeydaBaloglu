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
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TourController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        SetListView();
    }
    @FXML
    private ListView<TourInformationen> Tourlist;

    @FXML
    private Label labelTourListen;

    @FXML
    private Button bevorbutton;

    @FXML
    private Button nextbutton;
    @FXML
    private ImageView bevor;


        @FXML
        void onnextbuttonClicked(ActionEvent event) throws IOException {
            root = FXMLLoader.load(KundeController.class.getResource("Kundepage.fxml"));
            if(pane.getChildren() != null){
                pane.getChildren().remove(pane.getChildren().get(0));
            }

            pane.getChildren().add(root);

        }



    public void SetListView(){
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

    }


}
