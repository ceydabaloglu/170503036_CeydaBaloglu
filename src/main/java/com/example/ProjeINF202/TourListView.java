package com.example.ProjeINF202;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TourListView extends ListCell<TourInformationen> {

    private Stage stage;
    private Scene scene;
    private Parent root;
    private TourInformationen tourInfo;

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

    @FXML
    private Button ButtonMehr;

    @FXML
    void OnClickedButtonMehr(ActionEvent event)  throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MehrTourInfo.fxml"));
        root = (Parent)fxmlLoader.load();
        MehrTourInfoController controller = fxmlLoader.<MehrTourInfoController>getController();
        controller.setTourInfo(tourInfo);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

   


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
            tourInfo = tourInformationen;
            IdLabel.setText(String.valueOf(tourInformationen.getId()));
            PreisLabel.setText(String.valueOf(tourInformationen.getPreis()));
            TourNamelabel.setText(tourInformationen.getTourname());
            Zeitraumlabel.setText(String.valueOf(tourInformationen.getZeitraum()));

            setText(null);
            setGraphic(gridPane);
        }

    }




}
