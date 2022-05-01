package com.example.ProjeINF202;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class loginController  {


        private Stage stage;
        private Scene scene;
        private Parent root;


        @FXML
        private Button btnAnmeldung;

        @FXML
        private ImageView btnClose;

        @FXML
        private PasswordField pfPasswort;

        @FXML
        private TextField tfBenutzername;

        @FXML
        private Label errorMessageLabel;

        private String errorMessage = "";


        @FXML
        public void onbtnAnmeldungClick(ActionEvent event) throws Exception{

            System.out.println(tfBenutzername.getText());

            root = FXMLLoader.load(homeController.class.getResource("homepage.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

            System.out.println("Hellooo");
        }





    }

