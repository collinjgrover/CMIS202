package com.example.reccomend;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class sortMovies {
    public sortMovies (){
        this.movieSelected1 = movieSelected1;
        this.movieSelected2 = movieSelected2;
        this.movieSelected3 = movieSelected3;

        this.rating1=rating1;
        this.rating2=rating2;
        this.rating3=rating3;
    }
    String movieSelected1 = "";
    String movieSelected2 = "";
    String movieSelected3 = "";
    double rating1 = 0;
    double rating2 = 0;
    double rating3 = 0;
    public String getMovieSelected1() {
        return movieSelected1;
    }

    public void setMovieSelected1(String movieSelected1) {
        this.movieSelected1 = movieSelected1;
    }

    public String getMovieSelected2() {
        return movieSelected2;
    }

    public void setMovieSelected2(String movieSelected2) {
        this.movieSelected2 = movieSelected2;
    }

    public String getMovieSelected3() {
        return movieSelected3;
    }

    public void setMovieSelected3(String movieSelected3) {
        this.movieSelected3 = movieSelected3;
    }

    public double getRating1() {
        return rating1;
    }

    public void setRating1(double rating1) {
        this.rating1 = rating1;
    }

    public double getRating2() {
        return rating2;
    }

    public void setRating2(double rating2) {
        this.rating2 = rating2;
    }

    public double getRating3() {
        return rating3;
    }

    public void setRating3(double rating3) {
        this.rating3 = rating3;
    }

    public ArrayList<String> getMovieNames() {
        ArrayList<String> output = new ArrayList<>();

        try {
            FileReader input = new FileReader("src/main/movieTable");
            Scanner sc = new Scanner(input);

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] fields = line.split("//");

                if (fields.length >= 1) {
                    output.add(fields[0]);
                }
            }
            sc.close();

            return output;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

public ArrayList <String> getMovieAttributes(String movieName, String attribute) {
        int index;
    ArrayList<String> output = new ArrayList();
    switch (attribute) {
        case  "year":
            index = 1;
        case "genre":
            index = 2;
        case "desc":
            index = 3;
        default:
            index = -1;
    }
    try {
        FileReader input = new FileReader("src/main/movieTable");
        Scanner sc = new Scanner(input);
        String line = sc.nextLine();
        while (sc.hasNextLine()) {
            if (line.contains(movieName)) {
                String[] fields = line.split("//");
                if (index == 2) {
                    output.add(Arrays.toString(fields[index].split(",")));
                }
                output.add(fields[index]);
            }
        }
        sc.close();

        return output;
    } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
    }
}

//    public <E> ArrayList<String> setMovieTable() {
//
//        String[] fields = new String[3];
//        String line;
//        int n = 3;
//        int m = 0;
//
//        try {
//            FileReader input = new FileReader("src/main/movieTable");
//            ArrayList<String> output = new ArrayList<>();
//            ArrayList<ArrayList<String>> movieData = new ArrayList<>();
//            Scanner sc = new Scanner(input);
//
//            while (sc.hasNextLine()) {
//                line = sc.nextLine();
//
//                m++;
//
//                ArrayList<String> row = new ArrayList<>();
//
//                fields = line.split("//");
//
//                                    for (int rows = 0; rows < 16; rows++){
//
//                        for(int col = 0; col < 3; col++) {
//                            fields.toString().split("\n");
//                            output.add(Arrays.toString(new String[]{fields[0]}));
//                            row.add(Arrays.toString(new String[]{Arrays.toString(fields)}));
//                        }
//                        movieData.add(row);
//                    }
//                System.out.println("output: " + output);
//            }
//            sc.close();
//
//            return output;
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public boolean searchMovieTable (String movieName){
        String line;
        String[] fields = new String[5];
        boolean isMovieFound = false;

        try {
            File fr = new File("src/main/movieTable");
            Scanner sc = new Scanner(fr);

            line = sc.nextLine();
            while (sc.hasNextLine()) {
                if (line.contains(movieName)){
                    isMovieFound = true;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return isMovieFound;
    }
}
