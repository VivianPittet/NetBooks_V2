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
    ArrayList<Book> blib = HelloApplication.LibraryTest1.getBookLibrary();
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
    @FXML
    private ScrollPane bScrollPane;
    @FXML
    private Button ShowBook;
    @FXML
    private Button backButton;
    @FXML
    protected void listviewclick(){
        System.out.println(bListView.getSelectionModel().getSelectedItems());
    }

    /*@FXML
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
        bScrollPane.setVisible(false);
        bName.setText("");
        bWriter.setText("");
        bType.setText("");
        bPages.setText("");
        SearchPicture.setVisible(false);
        bListView.getItems().clear();

        }
    @FXML
    protected void onSearchButtonClick(){

        switch(SearchChoice.getValue()) {
            case "Name":
                String pathimage = "not the good path";
                Book SearchedBook = HelloApplication.Vivian.SearchName(SearchBar.getText(), HelloApplication.LibraryTest1.getBookLibrary()); // Récupère champs de texte et renvoi le livre correspondant.
                if (SearchedBook != null) {
                    pathimage = SearchedBook.getImagePath();
                    bName.setText("Name: " + SearchedBook.getName());
                    bWriter.setText("Writer: " + SearchedBook.getWriter());
                    bType.setText("Type: " + SearchedBook.getType());
                    bPages.setText("Pages: " + Integer.toString(SearchedBook.getPages()));
                    try {
                        Image img = new Image("file:" + pathimage);
                        SearchPicture.setVisible(true);
                        SearchPicture.setImage(img);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                }
                else{
                    bName.setText("No book found");
                }

                break;
            case "Writer":
                ArrayList<Book> searchedWriter = HelloApplication.Vivian.SearchWriter(SearchBar.getText(),HelloApplication.LibraryTest1.getBookLibrary());
                if (searchedWriter.size()>0){
                    bScrollPane.setVisible(true);
                ArrayList<String>bookName= new ArrayList<>();
                for(Book b: searchedWriter){
                    bookName.add(b.getName());
                }
                bListView.getItems().addAll(bookName);
                ShowBook.setVisible(true);
                }
                else{
                    bName.setText("No writer found");

                }
                break;
            case "Type":
                ArrayList<Book> searchedType = HelloApplication.Vivian.SearchType(SearchBar.getText(),HelloApplication.LibraryTest1.getBookLibrary());
                if(searchedType.size()>0){
                    bScrollPane.setVisible(true);
                    ArrayList<String>bookName= new ArrayList<>();
                    for(Book b: searchedType){
                        bookName.add(b.getName());
                    }
                    //bListView.getItems().addAll(bookName);
                    bListView.getItems().addAll(bookName);
                    ShowBook.setVisible(true);
                }
                else{
                        bName.setText("No type found");}

                break;
            default:
                bName.setText("Please select a search method");
                break;
        }

    }
    @FXML
    protected void onShowBookButtonClick(){
        Book bookToShow = HelloApplication.Vivian.SearchName(bListView.getSelectionModel().getSelectedItem(),blib);
        if (bookToShow!=null){
            bScrollPane.setVisible(false);
            bName.setText("Name: "+ bookToShow.getName());
            bWriter.setText("Writer: " + bookToShow.getWriter());
            bType.setText("Type: " + bookToShow.getType());
            bPages.setText("Pages: " + Integer.toString(bookToShow.getPages()));
            try{
                Image img= new Image("file:"+bookToShow.getImagePath());
                SearchPicture.setVisible(true);
                SearchPicture.setImage(img);
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        backButton.setVisible(true);
    }
    @FXML
    protected void onBackButtonClick(){
        bScrollPane.setVisible(true);
        bName.setText("");
        bWriter.setText("");
        bType.setText("");
        bPages.setText("");
        SearchPicture.setVisible(false);
        backButton.setVisible(false);
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
