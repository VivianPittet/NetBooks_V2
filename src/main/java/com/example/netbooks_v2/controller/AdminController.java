package com.example.netbooks_v2.controller;

import com.example.netbooks_v2.HelloApplication;
import com.example.netbooks_v2.model.Book;
import com.example.netbooks_v2.model.Library;
import javafx.beans.DefaultProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AdminController implements Initializable {
    // Id for search method
    @FXML
    private Label bName = new Label();
    @FXML
    private Label bWriter = new Label();
    @FXML
    private Label bType = new Label();
    @FXML
    private Label bPages = new Label();
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
    } */
    @FXML
    protected void SearchChoiceSelected() {
        SearchBar.setDisable(false);
        }
    @FXML
    protected void onSearchButtonClick(){
        switch(SearchChoice.getValue()){
            case "Name":
                String pathimage="not the good path";
                SearchBar.sort(bListView);


              /*  Book SearchedBook = HelloApplication.Vivian.SearchName(SearchBar.getText(), HelloApplication.LibraryTest1.getBookLibrary()); // Récupère champs de texte et renvoi le livre correspondant.
                if (SearchedBook != null) {
                    pathimage = SearchedBook.getImagePath();
                    bName.setText("Name: "+ SearchedBook.getName());
                    bWriter.setText("Writer: " + SearchedBook.getWriter());
                    bType.setText("Type: " + SearchedBook.getType());
                    bPages.setText("Pages: " + Integer.toString(SearchedBook.getPages()));
            }*/
                try{
                    Image img= new Image("file:"+pathimage);
                    SearchPicture.setImage(img);
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }

                break;
            case "Writer":
                bListView.setVisible(true);
                ArrayList<Book> searchedWriter = HelloApplication.Vivian.SearchWriter(SearchBar.getText(),HelloApplication.LibraryTest1.getBookLibrary());
                if (searchedWriter.size()>0){
                ArrayList<String>bookName= new ArrayList<>();
                for(Book b: searchedWriter){
                    bookName.add(b.getName());
                }
                //bListView.getItems().addAll(bookName);
                bListView.getItems().addAll(bookName);

                }
                break;
            case "Type":
                break;
            default:
                bName.setText("");
                bPages.setText("");
                bType.setText("");
                bWriter.setText("");
                bListView.setVisible(false);
                break;
        }

    }

    /**
     * Used to set the text on the choicebox of searching method
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SearchChoice.getItems().addAll(CBName);

    }
}
