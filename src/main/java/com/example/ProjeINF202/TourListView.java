package com.example.ProjeINF202;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class TourListView extends ListCell<TourInformationen> {

    @FXML
    private Label IdLabel;

    @FXML
    private Label PreisLabel;

    @FXML
    private Label TourNamelabel;

    @FXML
    private Label Zeitraumlabel;

    @FXML
    private GridPane gridPane;

    private FXMLLoader mLLoader;


    @Override
    protected void updateItem(TourInformationen tourInformationen, boolean empty) {
        super.updateItem(tourInformationen, empty);

        if(empty || tourInformationen == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("tourListViewCell.fxml"));
                mLLoader.setController(this);

                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            IdLabel.setText(String.valueOf(tourInformationen.getId()));
            PreisLabel.setText(String.valueOf(tourInformationen.getPreis()));
            TourNamelabel.setText(tourInformationen.getTourname());
            Zeitraumlabel.setText(String.valueOf(tourInformationen.getZeitraum()));

            setText(null);
            setGraphic(gridPane);
        }

    }




}
