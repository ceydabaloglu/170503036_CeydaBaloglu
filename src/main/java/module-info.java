module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.ProjeINF202 to javafx.fxml;
    exports com.example.ProjeINF202;
}