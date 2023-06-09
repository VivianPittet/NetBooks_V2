package com.example.netbooks_v2.controller;

import com.example.netbooks_v2.HelloApplication;
import com.example.netbooks_v2.model.Book;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.Writer;
import java.util.*;

public class UserController  {
    @FXML
    private Label welcomeText;

    // Id for search method



    // Id for sort method
    @FXML
    private ImageView SearchPicture;

    @FXML
    private Label  Name;
    @FXML
    private Label Writer;
    @FXML
    private Label Type;
    @FXML
    private ListView  showList;
    @FXML
   private ArrayList<Book> TabSearch = HelloApplication.LibraryTest1.getBookLibrary();

    private Book bookN;



//Méthode pour effacer la recherche
    @FXML
    protected void SearchChoiceSelected() {

        SearchPicture.setVisible(false);
        Name.setText("");
        Writer.setText("");
        Type.setText("");


    }


// Methode pour chercher des livres


    public static void btnsortBookName(ArrayList bListView){
        //stage mainWindow=(stage)Search.getScene();


    }
    public static void btnsortBookType(ArrayList bListView){
        //stage mainWindow=(stage)Search.getScene();


    }



 //Methode pour trier les livres

    protected void onSortButtonClickWriter(){

        ArrayList<String> nbookname = HelloApplication.Fred.sortByName(TabSearch); //List of book sort by name

        ArrayList<Book> TabSearch=  HelloApplication.LibraryTest1.getBookLibrary();  // book library
        //String temp;
       if(nbookname!=null){
        for (int i=0;i<nbookname.size();i++){
           Collections.sort(nbookname);
           System.out.println("la liste trier"+nbookname);

           Name.setText("Name: "+ showList.getName());
           Writer.setText("Writer: " + showList.getWriter());
           Type.setText("Type: " + showList.getType());



        }
           // for (int j=i+1;j<TabSearch.size();j++){
                //if(TabSearch.get(i).compareTo(TabSearch.get(j))<0){
           /* if( TabSearch[i])
                   nbookname =TabSearch.get(i);
                    TabSearch.set(i,TabSearch.get(j));
                    TabSearch.set(j,nbookname);*/

        //        }
      //      }
        }


    }
    public static void onSortButtonClickName(){
        ArrayList<Book> temp= new ArrayList<>();
        ArrayList<Book> TabSearch=  HelloApplication.LibraryTest1.getBookLibrary();


        for (int i=0;i<TabSearch.size();i++){
            for (int j=i+1;j<TabSearch.size();j++){
                if(TabSearch.get(i).getType().compareTo(TabSearch.get(j).getType())<0){
                    temp =TabSearch.get(i);
                    TabSearch.set(i,TabSearch.get(j));
                    TabSearch.set(j,temp);

                }
            }
        }
        //Collections.sort(TabSearch);
        System.out.println("la liste apès tris : " + TabSearch);

    }


    //methode de creation d'une pannier achat
   // public static void  Panier {



     /*  public static void ajouterArticle(Book book, int qte) {
            Integer quantity = ajouterArticle().get(book);
            if (quantity == null) {
                quantity = Integer.valueOf(0);

            }
            quantity = Integer.valueOf(quantity.intValue() + 1);
            ajouterArticle().put(book, quantity);
        }

        public static void supprimerArticle(Book book) {
            supprimerArticle().remove(book);
        }

     /*   public int calculerPanier() {
            int total = 0;
            Iterator<Entry<Book, Integer>> il = this.articles.entrySet().iterator();
            while (il.hasNext()) {
                Entry<Article, Integer> entry = il.next();
                total += entry.getKey().getPrix() * entry.getValue().intValue();
            }
            return total;
        }
    }*/




}