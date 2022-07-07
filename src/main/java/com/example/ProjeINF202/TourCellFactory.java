package com.example.ProjeINF202;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class TourCellFactory implements Callback<ListView<TourInformationen>, ListCell<TourInformationen>> {
    @Override
    public ListCell<TourInformationen> call(ListView<TourInformationen> param) {
        return new ListCell<>(){
            @Override
            public void updateItem(TourInformationen person, boolean empty) {
                super.updateItem(person, empty);
                if (empty || person == null) {
                    setText(null);
                } else {
                    setText(person.getTourname() + " " + person.getOrt());
                }
            }
        };
    }
}

