package com.example.ProjeINF202;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class main  extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(main.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("TourSystem");
        stage.setScene(scene);
        stage.show();
        Database db = new Database();
        //db.createDatabase();
        db.connect();
        //db.createTourTable();
        //db.createBuroPersonal();
        //db.createKundeTable();


    }
    public static void main(String[] args) {
        launch();
    }

}
