package com.example.ProjeINF202;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddKundetoTourController implements Initializable {

    private TourInformationen tourInfo;
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button ButtonAdd;

    @FXML
    private Button ButtonZurück;

    public AddKundetoTourController() {

        ObservableKundeList = FXCollections.observableArrayList();
        for (Kunde kundeInfo : Database.getKundeInfo()) {
            ObservableKundeList.add(kundeInfo);
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        KundeListView.setItems(ObservableKundeList);
        KundeListView.setCellFactory(kundeListView -> new KundeListView());

    }
    @FXML
    private ListView<Kunde> KundeListView;
    private ObservableList<Kunde> ObservableKundeList;


    @FXML
    void OnClickedButtonZurück(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MehrTourInfo.fxml"));
        root = (Parent)fxmlLoader.load();
        MehrTourInfoController controller = fxmlLoader.<MehrTourInfoController>getController();
        controller.setTourInfo(tourInfo);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setTourInfo(TourInformationen tourInformationen){
        tourInfo = tourInformationen;
    }

    @FXML
    void OnClickedButtonAdd(ActionEvent event) throws IOException{

        Kunde x = KundeListView.getSelectionModel().getSelectedItem();
        Database.addTourKundeInfo(tourInfo.getId(),x.getKundennummer());


    }



}
