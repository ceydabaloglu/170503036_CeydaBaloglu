package com.example.ProjeINF202;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.Callback;

import java.net.URL;
import java.util.ResourceBundle;

public class TourController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        SetListView();
    }
    @FXML
    private ListView<TourInformationen> Tourlist;

    @FXML
    private Label labelTourListen;

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
