package com.example.netbooks_v2.controller;

import com.example.netbooks_v2.HelloApplication;
import com.example.netbooks_v2.model.Book;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.*;

public class UserController implements Initializable {
    @FXML
    private Label welcomeText;

    // Id for search method
    ArrayList<Book> blib = HelloApplication.LibraryTest1.getBookLibrary();
    @FXML
    private Label bName;
    @FXML
    private Label bWriter;
    @FXML
    private Label bType;
    @FXML
    private Label bPages;
    @FXML
    private ChoiceBox<String> SearchChoice;
    private String[] CBName = {"Name", "Writer", "Type"};
    @FXML
    private TextField SearchBar;
    @FXML
    private ImageView SearchPicture;
    @FXML
    private ListView<String> bListView = new ListView<>();
  /* @FXML
    private ScrollPane bScrollPane;
    @FXML
    private Button ShowBook;
    @FXML
    private Button backButton;*/
    @FXML
    private Book bookToShow;



    // Id for sort method
   // @FXML
   // private ImageView SearchPicture;

    @FXML
    private Label  sort;
    @FXML
    private Button Ok;

    @FXML
    private ListView <String> showList;
    @FXML
   private ArrayList<Book> TabSearch = HelloApplication.LibraryTest1.getBookLibrary();
   @FXML
   private ChoiceBox<String> SChoice;
   private String[] choice = {"Name", "Writer", "Type"};

    // Id for Buy method
    @FXML
    private ListView <String> ListPanier;



//Méthode pour effacer la recherche
   /* @FXML
    protected void SearchChoiceSelected() {

        SearchPicture.setVisible(false);
        Name.setText("");
        Writer.setText("");
        Type.setText("");


    }*/
public void initialize(URL url, ResourceBundle resourceBundle) {
    SearchChoice.getItems().addAll(CBName);
    SChoice.getItems().addAll(CBName);

}

    @FXML
    protected void resetSearchPage() {
       // pathImageToAdd="";
        //ShowBook.setVisible(false);
       // bModify.setVisible(false);
        SearchBar.setDisable(false);
       // bScrollPane.setVisible(false);
        bName.setText("");
        bWriter.setText("");
        bType.setText("");
        bPages.setText("");
        SearchPicture.setVisible(false);
        bListView.getItems().clear();

    }


// Methode pour chercher des livres
@FXML
protected void onSearchButtonClick(){
    resetSearchPage();
    bListView.getItems().clear(); // Clear the list, else the books appear many times

    switch(SearchChoice.getValue()) {
        case "Name":
            String pathimage = "not the good path";
            bookToShow = HelloApplication.Vivian.SearchName(SearchBar.getText(), HelloApplication.LibraryTest1.getBookLibrary()); // Récupère champs de texte et renvoi le livre correspondant.
            if (bookToShow != null) {
                pathimage = bookToShow.getImagePath();
                bName.setText("Name: " + bookToShow.getName());
                bWriter.setText("Writer: " + bookToShow.getWriter());
                bType.setText("Type: " + bookToShow.getType());
                bPages.setText("Pages: " + Integer.toString(bookToShow.getPages()));
                try {
                    Image img = new Image("file:" + pathimage);
                    SearchPicture.setVisible(true);
                    SearchPicture.setImage(img);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
               // bModify.setVisible(true);
            }
            else{
                bName.setText("No book found");
            }

            break;
        case "Writer":
            ArrayList<Book> searchedWriter = HelloApplication.Vivian.SearchWriter(SearchBar.getText(),HelloApplication.LibraryTest1.getBookLibrary());
            if (searchedWriter.size()>0){
               //bScrollPane.setVisible(true);
                ArrayList<String>bookName= new ArrayList<>();
                for(Book b: searchedWriter){
                    bookName.add(b.getName());
                }
                bListView.getItems().addAll(bookName);
               // ShowBook.setVisible(true);
            }
            else{
                bName.setText("No writer found");

            }
            break;
        case "Type":
            ArrayList<Book> searchedType = HelloApplication.Vivian.SearchType(SearchBar.getText(),HelloApplication.LibraryTest1.getBookLibrary());
            if(searchedType.size()>0){
               // bScrollPane.setVisible(true);
                ArrayList<String>bookName= new ArrayList<>();
                for(Book b: searchedType){
                    bookName.add(b.getName());
                }
                //bListView.getItems().addAll(bookName);
                bListView.getItems().addAll(bookName);
               // ShowBook.setVisible(true);
            }
            else{
                bName.setText("No type found");}

            break;
        default:
            bName.setText("Please select a search method");
            break;
    }

}



 //Methode pour trier les livres
 @FXML

    protected void onSortButtonClick(){


        ArrayList<Book> TabSearch=  HelloApplication.LibraryTest1.getBookLibrary();  // book library

        ArrayList<String> nbookname = HelloApplication.UserTest.sortByName(TabSearch); //List of book sort by name

        ArrayList<String> nbookType = HelloApplication.UserTest.sortByType(TabSearch);

        ArrayList<String> nbookWriter = HelloApplication.UserTest.sortByWriter(TabSearch);

        showList.getItems().clear();
        switch(SChoice.getValue()){
            case "Name":
                for(int i = 0; i < nbookname.size(); i++){
                    System.out.println( nbookname.get(i).toString() + "\n");
               showList.getItems().addAll(nbookname.get(i));}

                break;

            case "Writer":
                for(int i = 0; i < nbookWriter.size(); i++){
                    System.out.println("After Sorting: "+ nbookWriter.get(i));
                   // System.out.println( nbookWriter.get(i).toString() + "\n");
                showList.getItems().addAll(nbookWriter.get(i));}
                break;

            case "Type":
                for(int i = 0; i < nbookType.size(); i++){
                    System.out.println("After Sorting: "+ nbookWriter);
                    //System.out.println( nbookType.get(i).toString() + "\n");
                showList.getItems().addAll(nbookType.get(i));}
                break;

            default:
                sort.setText("Please select a sort method");
                break;


        }


        }







    //methode de creation d'une pannier achat


   // public static void  Panier {

   /* public String BuyBook(Book BookName,ArrayList<Book> booklib) {
        String WishBook = "Not the book";
        for(Book b: booklib){
            if (b.getName().equals(BookName)){
                WishBook = b.getName();
            }
        }
        System.out.println("get book");
        return WishBook;
    }


}*/

     /*  public static void BuyBook(Book bookWish, ArrayList<Book> ) {
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