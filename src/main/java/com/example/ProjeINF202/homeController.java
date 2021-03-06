package com.example.ProjeINF202;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class homeController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Pane paneview;
    @FXML
    private Button btnBüroPerson;

    @FXML
    private Button btnKunden;

    @FXML
    private Button btnTouren;

    @FXML
    private AnchorPane Achpaneview;

    @FXML
    private Button LogoutButton;


    @FXML
    void OnclickedLogoutButton(ActionEvent event)  throws IOException{
        root = FXMLLoader.load(loginController.class.getResource("hello-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    void onTourenClicked(ActionEvent event) throws IOException {
        root = FXMLLoader.load(TourController.class.getResource("Tourenview.fxml"));
        if(paneview.getChildren() != null){
            paneview.getChildren().clear();
        }

        paneview.getChildren().add(root);

    }
    @FXML
    void onKundenClicked(ActionEvent event) throws IOException {
        FXMLLoader KundepageScreene = new FXMLLoader(KundeController.class.getResource("Kundepage.fxml"));
        if(paneview.getChildren() != null){
            paneview.getChildren().clear();
        }
        paneview.getChildren().add(KundepageScreene.load());
    }
    @FXML
    void onBüroClicked(ActionEvent event) throws IOException {
        root = FXMLLoader.load(BüroPersonController.class.getResource("BüroPersonpage.fxml"));
        if(paneview.getChildren() != null){
            paneview.getChildren().clear();
        }
        paneview.getChildren().add(root);

    }
}


