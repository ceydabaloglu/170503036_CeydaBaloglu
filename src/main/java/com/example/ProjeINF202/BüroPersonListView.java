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

public class BüroPersonListView extends ListCell<BüroPersonal> {

    private Stage stage;
    private Scene scene;
    private Parent root;
    private BüroPersonal büroPersonalInformationen;

    @FXML
    private Label EmailLabel;

    @FXML
    private Label NameLabel;

    @FXML
    private Label VornameLabel;

    @FXML
    private GridPane GridPane;

    private FXMLLoader mLLoader;

    @FXML
    private Button MehrButton;
    @FXML
    private Label ErrorMessageLabel;

    @FXML
    void OnClickedmehrButton(ActionEvent event) throws IOException {

        if(Database.rolle.equals("Reiseveranstalter")){
            ErrorMessageLabel.setText("Sie haben keine Erlaubnis  ");
            return ;
        }else{


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MehrBüroPersonalInfo.fxml"));
        root = (Parent)fxmlLoader.load();
        MehrBüroPersonalInfoController controller = fxmlLoader.<MehrBüroPersonalInfoController>getController();
        controller.setBüroPersonal(büroPersonalInformationen);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        }
    }

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
            büroPersonalInformationen = büropersonal;
            NameLabel.setText((büropersonal.getName()));
            VornameLabel.setText((büropersonal.getVorname()));
            EmailLabel.setText(büropersonal.getEmail());

            setText(null);
            setGraphic(GridPane);
        }

    }


}
