package com.example.ProjeINF202;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class TourController {

    @FXML
    private ListView<TourInformationen> Tourlist;

    @FXML
    private Label tourname;

    @FXML
    private Label zeitraum;

    @FXML
    private Label ıd;

    public void setTour(TourInformationen t) {
        tourname.setText(t.getTourname() );
        zeitraum.setText(t.getZeitraum());
        //ıd.setText(t.getId());
    }

}
