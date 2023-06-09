package com.example.netbooks_v2;

import com.example.netbooks_v2.model.Admin;
import com.example.netbooks_v2.model.Book;
import com.example.netbooks_v2.model.Library;
import com.example.netbooks_v2.model.Users;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    public static Library LibraryTest1;
    public static Admin Vivian;
    public static Admin Candice;
    public static Admin Himen;
    public static Users UserTest= new Users("UserTest","0");
    public static PersonList allPeople;

    public static Scene scene;
    public static Scene scene2;
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Admin-view.fxml"));
        scene = new Scene(fxmlLoader.load(), 1200, 600);

        FXMLLoader fxmlLoader2 = new FXMLLoader(HelloApplication.class.getResource("User-view.fxml"));
        scene2 = new Scene(fxmlLoader2.load(), 1200, 600);

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Vivian = new Admin("Vivian","0000");
        Candice = new Admin("Candice","0001");
        Himen = new Admin("Himen", "0002");
        allPeople= new PersonList(Vivian);
        allPeople.addPerson(new Admin("AdminTest","0"));
        allPeople.addPerson(UserTest);
        allPeople.addPerson(Candice);
        allPeople.addPerson(Himen);
        LibraryTest1 = new Library();
        LibraryTest1.readCSV("DataBooks/Resources_Data_Netbooks.csv");



        launch();
    }

    /**
     * Used to switch admin-view to user-view when logged
     * @param event use the click of the mouse
     */
    public static void switchScene (ActionEvent event){
        Stage stage2 = new Stage();
        ((Node)(event.getSource())).getScene().getWindow().hide();
        stage2.setScene(scene2);

        stage2.show();
    }
}

