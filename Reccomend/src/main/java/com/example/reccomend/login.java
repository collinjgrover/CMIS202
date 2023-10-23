package com.example.reccomend;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class login{

    public login() {
        this.username = username;
        this.password = password;
    }
    ArrayList userData = new ArrayList();
    public void confirmLogin (String[] moviesSelected, double[] movieRatings){
        this.loginCount++;
        try {
            FileWriter login = new FileWriter("loginData.txt", true);

            if (!(isValidUser(this.username, this.password))){
                System.out.println(moviesSelected[0]+"."+moviesSelected[1]+"."+moviesSelected[2]);
                userData.add(String.format("%s//%s//%d//%d//%s//%s//%d//%s//%d\n", this.username, this.password, this.loginCount, moviesSelected[0].toString(),moviesSelected[1].toString(),moviesSelected[2].toString(),
                        movieRatings[0],movieRatings[1],movieRatings[2]));
                login.append(userData.toString().replace("[", "").replace("]", ""));

                login.close();
            } else {

                if (userData.contains(this.username+"//"+this.password)) {
                    userData.remove(String.format("%s//%s//%d//%d//%s//%s//%d//%s//%d\n", this.username, this.password, this.loginCount, moviesSelected[0],moviesSelected[1],moviesSelected[2],
                            movieRatings[0],movieRatings[1],movieRatings[2]));
                    userData.set(userData.size()-1, String.format("%s//%s//%d//%d//%s//%s//%d//%s//%d\n", this.username, this.password, this.loginCount, moviesSelected[0],moviesSelected[1],moviesSelected[2],
                            movieRatings[0],movieRatings[1],movieRatings[2]));
                    login.write(userData.toString().replace("[", "").replace("]", ""));

                    login.close();
                } else {

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
public void saveOutput(String[] moviesSelected, double[] movieRatings,String[] moviesRecommended) {
    try {
        FileWriter login = new FileWriter("loginData.txt", true);

        userData.add(String.format("%s//%s//%d//%d//%s//%s//%d//%s//%d\n", this.username, this.password, this.loginCount, moviesSelected[0], moviesSelected[1], moviesSelected[1],
                movieRatings[0], movieRatings[1], movieRatings[3], moviesRecommended[0], moviesRecommended[1], moviesRecommended[2]));
        login.append(userData.toString().replace("[", "").replace("]", ""));

        login.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    private String username;
    private String password;
    int loginCount = 1;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public  boolean isValidUser(String user, String pass) throws IOException {
        boolean isValid = false;
        String line;
        String[] fields;
        String userN;
        String passW;
        String logCount;
        int lineCount =0;
        try {

            File fr = new File("C:\\Users\\bacon\\IdeaProjects\\Reccomend\\src\\main\\java\\loginData.txt");


            Scanner sc = new Scanner(fr);

            while (sc.hasNextLine()) {

                line = sc.nextLine();
                if (line.contains(user) && line.contains(pass)) {
                    fields = line.split("//", lineCount);


                    isValid = true;
                    return isValid;
                } else if (!(line.contains(user) && line.contains(pass))) {

                    isValid = false;
                    return isValid;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        return isValid;
    }

}