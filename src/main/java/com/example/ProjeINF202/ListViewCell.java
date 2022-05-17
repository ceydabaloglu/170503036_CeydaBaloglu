package com.example.ProjeINF202;

import javafx.scene.chart.XYChart;
import javafx.scene.control.ListCell;

public class ListViewCell extends ListCell<TourInformationen> {
    @Override
    public void updateItem(TourInformationen string, boolean empty)
    {
        super.updateItem(string,empty);
        if(string != null)
        {
            XYChart.Data data = new XYChart.Data();
            data.setInfo(string);
            setGraphic(data.getBox());
        }
    }
}
