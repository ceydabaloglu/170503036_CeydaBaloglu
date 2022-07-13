package com.example.ProjeINF202;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class KundeController  implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    public KundeController() {

        Observablekundelist = FXCollections.observableArrayList();
        for (Kunde kunde : Database.getKundeInfo()) {
            Observablekundelist.add(kunde);
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        kundelist.setItems(Observablekundelist);
        kundelist.setCellFactory(KundeListView -> new KundeListView());

    }
    @FXML
    private Button btnAdd;

    @FXML
    private Button btnLösche;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button bevorbuton;

    @FXML
    private Pane pane;

    @FXML
    private ListView<Kunde> kundelist;

    private ObservableList<Kunde> Observablekundelist;


    @FXML
    void onbevorbutonCliecked(ActionEvent event) throws IOException {
        root = FXMLLoader.load(homeController.class.getResource("homepage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void OnbtnAddCliecked(ActionEvent event) throws IOException {
        root = FXMLLoader.load(AddKundeController.class.getResource("AddKunde.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void OnClickedButtonLöschen(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Warnung");
        alert.setHeaderText("Löschen Sie diese Kunde Informationen");
        //alert.setContentText("Wenden Sie sich dazu an den Administrator!");
        if(alert.showAndWait().get() == ButtonType.OK)   {
        Database.DeleteKundeFromDb(kundelist.getSelectionModel().getSelectedItem());
        kundelist.getItems().remove(kundelist.getSelectionModel().getSelectedItem());
        }
    }

    @FXML
    void OnClickedButtonUpdate(ActionEvent event) throws  IOException{

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddKunde.fxml"));
        root = (Parent)fxmlLoader.load();
        AddKundeController controller = fxmlLoader.<AddKundeController>getController();
        controller.setKundeInfo(kundelist.getSelectionModel().getSelectedItem(),true);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
