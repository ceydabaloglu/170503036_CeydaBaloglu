module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ProjeINF202 to javafx.fxml;
    exports com.example.ProjeINF202;
}