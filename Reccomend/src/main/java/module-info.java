module com.example.reccomend {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.reccomend to javafx.fxml;
    exports com.example.reccomend;
}