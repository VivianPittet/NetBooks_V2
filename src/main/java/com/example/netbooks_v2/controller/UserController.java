package com.example.netbooks_v2.controller;

import com.example.netbooks_v2.HelloApplication;
import com.example.netbooks_v2.model.Book;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class UserController {
    @FXML
    private Label welcomeText;
    @FXML
    private TextField BooksName;
    @FXML
    private ImageView picture;

    @FXML
    protected void sortByName() {
        ArrayList<String> booksName = HelloApplication.LibraryTest1.sortByName();
        for (String s : booksName) {
            System.out.println(s);
        }
    }
    @FXML
    protected void sortByWriter() {
        ArrayList<String> writerName = HelloApplication.LibraryTest1.sortByWriter();
        for(String s:writerName){
            System.out.println(s);
        }
    }
    @FXML
    protected void sortByType() {
        ArrayList<String> TypeName = HelloApplication.LibraryTest1.sortByType();
        for (String s : TypeName) {
            System.out.println(s);
        }
    }
    @FXML
    protected void onSearchButtonClick(){
        String pathimage="not the good path";
        String bookname= BooksName.getText();
        System.out.println(HelloApplication.LibraryTest1.SearchName(bookname));
        for (Book b: HelloApplication.LibraryTest1.BookLibrary){
            if (b.getName().equals(bookname)){
                pathimage=b.getImagePath();
            }
        }
        try{
            Image img= new Image("file:"+pathimage);
            picture.setImage(img);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}