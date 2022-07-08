package com.example.ProjeINF202;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class BüroPersonListView extends ListCell<BüroPersonal> {

    @FXML
    private Label EmailLabel;

    @FXML
    private Label NameLabel;

    @FXML
    private Label VornameLabel;

    @FXML
    private GridPane GridPane;

    private FXMLLoader mLLoader;

    @Override
    protected void updateItem(BüroPersonal büropersonal, boolean empty) {
        super.updateItem(büropersonal, empty);

        if(empty || büropersonal == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("büropersonListViewCell.fxml"));
                mLLoader.setController(this);

                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            NameLabel.setText((büropersonal.getName()));
            VornameLabel.setText((büropersonal.getVorname()));
            EmailLabel.setText(büropersonal.getEmail());

            setText(null);
            setGraphic(GridPane);
        }

    }


}
