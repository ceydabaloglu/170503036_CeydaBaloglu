package com.example.ProjeINF202;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class KundeListView extends ListCell<Kunde> {
    @FXML
    private Label EmailLabel;

    @FXML
    private Label KundenoLabel;
    @FXML
    private Label NameLabel;

    @FXML
    private Label VornameLabel;

    @FXML
    private GridPane GridPane;

    private FXMLLoader mLLoader;

    @Override
    protected void updateItem(Kunde Kunde, boolean empty) {
        super.updateItem(Kunde, empty);

        if(empty || Kunde == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("kundeListViewCell.fxml"));
                mLLoader.setController(this);

                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            KundenoLabel.setText(String.valueOf(Kunde.getKundennummer()));
            NameLabel.setText(String.valueOf(Kunde.getName()));
            VornameLabel.setText(Kunde.getVorname());
            EmailLabel.setText(String.valueOf(Kunde.getEmail()));

            setText(null);
            setGraphic(GridPane);
        }

    }

}
