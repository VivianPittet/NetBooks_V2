package com.example.netbooks_v2.controller;

import com.example.netbooks_v2.HelloApplication;
import com.example.netbooks_v2.model.Book;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Collections;

public class UserController {
    @FXML
    private Label welcomeText;



    @FXML
    private TextField SearchBar;
    //@FXML
   // private ImageView SearchPicture;
   @FXML
   private ChoiceBox<String> SearchW;
    @FXML
    private Label bWriter = new Label();


   public static void btnsarchBookType(ArrayList bListView){
       //stage mainWindow=(stage)Search.getScene();


    }
    public static void btnsarchBookName(ArrayList bListView){
       // stage mainWindow=(stage)Search.getScene();


    }
    public static void btnsarchBookWriter(ArrayList bListView){
        //stage mainWindow=(stage)Search.getScene();


    }
    public static void btnsortBookWriter(ArrayList<String> bListView){
        //stage mainWindow=(stage)Search.getScene();
        ArrayList<String > ListView = new ArrayList<String>();
     ListView.addAll(bListView);
    //sort
        for(int i=0; i<ListView.size();i++)
            if (bListView.get(i).equals(bListView))

                for(i = 0; i < ListView.size(); i++)
                System.out.println( ListView.get(i).toString() + "\n");




    }
    public static void btnsortBookName(ArrayList bListView){
        //stage mainWindow=(stage)Search.getScene();


    }
    public static void btnsortBookType(ArrayList bListView){
        //stage mainWindow=(stage)Search.getScene();


    }



}