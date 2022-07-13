package com.example.ProjeINF202;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class KundeListView extends ListCell<Kunde> {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Kunde kundeInfo;

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

    @FXML
    private Button moreButton;

    @FXML
    void OnClickedMoreButton(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MehrKundeInfo.fxml"));
        root = (Parent)fxmlLoader.load();
        MehrKundeInfoController controller = fxmlLoader.<MehrKundeInfoController>getController();
        controller.setKundeInfo(kundeInfo);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }



  /*  @FXML
    void OnClickedMehrButton(ActionEvent event)  throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MehrKundeInfo.fxml"));
        root = (Parent)fxmlLoader.load();
        MehrKundeInfoController controller = fxmlLoader.<MehrKundeInfoController>getController();
        controller.setKundeInfo(kundeInfo);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }*/



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
            kundeInfo = Kunde;
            KundenoLabel.setText(String.valueOf(Kunde.getKundennummer()));
            NameLabel.setText(String.valueOf(Kunde.getName()));
            VornameLabel.setText(Kunde.getVorname());
            EmailLabel.setText(String.valueOf(Kunde.getEmail()));

            setText(null);
            setGraphic(GridPane);
        }

    }

}
