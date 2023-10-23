package com.example.reccomend;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class SceneTwoController extends HelloController implements Initializable {
    @FXML
    private Text movieRating1;

    @FXML
    private Text movieRating2;

    @FXML
    private Text movieRating3;

    @FXML
    private Text movieRecomendation1;

    @FXML
    private Text movieRecomendation2;

    @FXML
    private Text movieRecomendation3;

    @FXML
    private Text movieSelected1;

    @FXML
    private Text movieSelected2;

    @FXML
    private Text movieSelected3;
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        sortMovies movies = new sortMovies();

//        movieSelected1.setText();
//        movieSelected2.setText();
//        movieSelected3.setText();



// output controller, algorithm is not yet complete though so coming soon
    }

}
