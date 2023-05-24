package com.example.netbooks_v2;

import com.example.netbooks_v2.model.Book;
import com.example.netbooks_v2.model.Library;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    public static Library LibraryTest1;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Book MikeHorn = new Book("Latitude 0",352,"MikeHorn","Adventure","BookPictures/LATITUDE0.png",22.8445f);
        Book cherub = new Book("100 jours en enfer", 448,"Robert Muchamore", "SF","BookPictures/cherub1.png", 8.2f);
        LibraryTest1 = new Library();
        LibraryTest1.addBook(MikeHorn);
        LibraryTest1.addBook(cherub);
        launch();
    }
}