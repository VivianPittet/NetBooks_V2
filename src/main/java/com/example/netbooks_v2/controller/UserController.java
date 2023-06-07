package com.example.netbooks_v2.controller;

import com.example.netbooks_v2.HelloApplication;
import com.example.netbooks_v2.model.Book;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.Writer;
import java.util.*;

public class UserController  {
    @FXML
    private Label welcomeText;

    // Id for search method
    @FXML
    private ImageView SearchPicture;
    @FXML
    private ListView<String> bListView = new ListView<>();

    // Id for sort method
    @FXML
    private TextField SearchBar;
    //@FXML
   // private ImageView SearchPicture;
  // @FXML
  // private ChoiceBox<String> SearchW;
    @FXML
    private Label  Name= new Label();
    @FXML
    private Label Writer = new Label();
    @FXML
    private Label Type = new Label();
    @FXML
   private ArrayList<Book> TabSearch = HelloApplication.LibraryTest1.getBookLibrary();
   // @FXML
   //private Map<Article>, Integer> articles;

       // this.articles = new HashMap<Article, Integer>();
    @FXML
    private Book bookN;



//Méthode pour effacer la recherche
    @FXML
    protected void SearchChoiceSelected() {
        SearchBar.setDisable(false);
        SearchPicture.setVisible(false);
        bListView.getItems().clear();
        Name.setText("");
        Writer.setText("");
        Type.setText("");


    }


// Methode pour chercher des livres





 //Methode pour trier les livres

    public static void onSortButtonClickWriter(){
        List<String> nbookname = new ArrayList<>();
        //TabSearch = new ArrayList<~>();
        ArrayList<Book> TabSearch=  HelloApplication.LibraryTest1.getBookLibrary();
        String temp;
        Book bookn=




        for (int i=0;i<TabSearch.size();i++){
            while (Book)
            Collections.sort(TabSearch);


           // for (int j=i+1;j<TabSearch.size();j++){
                //if(TabSearch.get(i).compareTo(TabSearch.get(j))<0){
           /* if( TabSearch[i])
                   nbookname =TabSearch.get(i);
                    TabSearch.set(i,TabSearch.get(j));
                    TabSearch.set(j,nbookname);*/

        //        }
      //      }
        }
    System.out.println("liste par ordre Alphabetique"+TabSearch);

    }
    public static void onSortButtonClickName(){
        String temp;
        List<String> TabSearch= new ArrayList<String>();

        /*for (int i=0;i<TabSearch.size();i++){
            for (int j=i+1;j<TabSearch.size();j++){
                if(TabSearch.get(i).compareTo(TabSearch.get(j))<0){
                    temp=TabSearch.get(i);
                    TabSearch.set(i,TabSearch.get(j));
                    TabSearch.set(j,temp);

                }
            }
        }*/
        Collections.sort(TabSearch);
        System.out.println("la liste apès tris : " + TabSearch);

    }
   /* public static void btnsortBookName(ArrayList bListView){
        //stage mainWindow=(stage)Search.getScene();


    }
    public static void btnsortBookType(ArrayList bListView){
        //stage mainWindow=(stage)Search.getScene();


    }*/

    //methode de creation d'une pannier achat
   // public static void  Panier {



        public static void ajouterArticle(Book book, int qte) {
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

        public int calculerPanier() {
            int total = 0;
            Iterator<Entry<Book, Integer>> il = this.articles.entrySet().iterator();
            while (il.hasNext()) {
                Entry<Article, Integer> entry = il.next();
                total += entry.getKey().getPrix() * entry.getValue().intValue();
            }
            return total;
        }
    }




}