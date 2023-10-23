package com.example.reccomend;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    public void switchToScene2(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("scene2.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private ChoiceBox<String> dropdown1;

    @FXML
    private ChoiceBox<String> dropdown2;

    @FXML
    private ChoiceBox<String> dropdown3;

    @FXML
    private TextField welcomeText;

    @FXML
    private Slider slider1;

    @FXML
    private Slider slider2;

    @FXML
    private Slider slider3;



    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        sortMovies movieTable = new sortMovies();
        String[] movieNames = movieTable.getMovieNames().toArray(new String[0]);
        dropdown1.getItems().addAll(movieNames);
        dropdown2.getItems().addAll(movieNames);
        dropdown3.getItems().addAll(movieNames);
//        double rating1 = slider1.getValue();

        slider1.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {

                double rating1 = slider1.getValue();

                double rating2 = slider2.getValue();

                double rating3 = slider3.getValue();

            }
        });

    }

    @FXML
    void HelloController(MouseEvent event) throws IOException {

        sortMovies movieTable = new sortMovies();
        login login = new login();
        String[] moviesPicked = new String[3];
        double[] movieRatings = new double[3];
        movieRatings[0]=  slider1.getValue();
        movieRatings[1]=  slider2.getValue();
        movieRatings[2]=  slider3.getValue();
        moviesPicked[0]= dropdown1.getValue();
        moviesPicked[1]= dropdown2.getValue();
        moviesPicked[2]= dropdown3.getValue();
       movieTable.setMovieSelected1(moviesPicked[0]);
        movieTable.setMovieSelected2(moviesPicked[1]);
        movieTable.setMovieSelected3( moviesPicked[2]);


//
////        System.out.println("m1.r1"+movieSelected1+"."+rating1+ " m2.r2 "+movieSelected2+"."+rating3+" m3.r3: "+ movieSelected3+"."+rating3);
//
//       login.confirmLogin(moviesPicked,movieRatings);
////        root = FXMLLoader.load(getClass().getResource("scene2.fxml"));
    }

}