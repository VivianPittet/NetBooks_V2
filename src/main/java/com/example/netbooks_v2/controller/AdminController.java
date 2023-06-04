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
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AdminController implements Initializable {
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
    @FXML
    private ScrollPane bScrollPane;
    @FXML
    private Button ShowBook;
    @FXML
    private Button backButton;


    // ID for add method
    @FXML
    private TextField addName;
    @FXML
    private TextField addWriter;
    @FXML
    private TextField addType;
    @FXML
    private TextField addPages;
    @FXML
    private TextField addPrice;
    private String pathImageToAdd;
    @FXML
    private Label errorMessage;

    // ID for delete method
    @FXML
    private TextField bToDelete;
    @FXML
    private Button deleteSearch;
    @FXML
    private Button Delete;
    @FXML
    private Label bNameToDelete;
    @FXML
    private ImageView imgBToDelete;

    private Book ToDelete;

    @FXML
    private Pane ConfirmDelete;
    @FXML
    private Label deleteMessage;
    @FXML
    private Button finishButton;



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

    /**
     * Used to clear the page when you change the search method
     */
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

    /**
     * Search the book
     * use the selected method (Name, Writer or Type)
     */
    @FXML
    protected void onSearchButtonClick(){
        bListView.getItems().clear(); // Clear the list, else the books appear many times

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

    /**
     * Show the book and set the list book visibility false
     * Set back button visibility true
     */
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

    /**
     * Back to the liste to select a book
     * Set book list visibility true
     */
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
    @FXML
    protected void onSelectPictureClick(){
        FileChooser FC = new FileChooser();
        File SelectedFile = FC.showOpenDialog(null);
        try{
            pathImageToAdd = "BookPictures/"+SelectedFile.getName();
        } catch(Exception e){}

    }

    /**
     * Verify that text field are not empty.
     * Create a book and put it in the library
     */
    @FXML
    protected void OnAddBookClick(){
        String abName;
        String abWriter;
        String abType;
        float abPrice;
        int abPages;
        if ( addWriter.getLength()>0 && addType.getLength()>0 && addName.getLength()>0 && addPages.getLength()>0 && addPrice.getLength()>0 ) {
            abWriter = addWriter.getText();
            abName = addName.getText();
            abType = addType.getText();
            abPrice = Float.parseFloat(addPrice.getText());
            abPages = Integer.parseInt(addPages.getText());
            HelloApplication.LibraryTest1.addBook(new Book(abName, abPages, abWriter, abType, pathImageToAdd, abPrice));
            errorMessage.setText("Book added !");
            addWriter.clear();
            addPrice.clear();
            addPages.clear();
            addType.clear();
            addName.clear();

        }
        else{
            errorMessage.setText("Please fill all the book's specification");
        }

    }
    @FXML
    protected void clearErrorLabel(){
        errorMessage.setText("");
    }

    @FXML
    protected void OnSearhButtonClickDelete(){
        String PathImage = "not the good path";
        ToDelete = HelloApplication.Vivian.SearchName(bToDelete.getText(), HelloApplication.LibraryTest1.getBookLibrary()); // Récupère champs de texte et renvoi le livre correspondant.
        if (ToDelete != null) {
            PathImage = ToDelete.getImagePath();
            bNameToDelete.setText("Name: " + ToDelete.getName());
            try {
                Image img = new Image("file:" + PathImage);
                imgBToDelete.setVisible(true);
                imgBToDelete.setImage(img);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            Delete.setVisible(true);
        }
        else{
            bNameToDelete.setText("No book found");
        }
    }
    @FXML
    protected void OnDeleteButtonClick(){
        ConfirmDelete.setVisible(true);
    }
    @FXML
    protected void OnYesDeleteButtonClick(){
        if(HelloApplication.LibraryTest1.deleteBook(ToDelete)){ // supprime et renvoie true si le livre est supprimé
            deleteMessage.setText("Book deleted");
            deleteMessage.setTextFill(Color.GREEN);
        }else{
            deleteMessage.setText("Error in delete processing, retry");
            deleteMessage.setTextFill(Color.RED);
        }
        finishButton.setVisible(true);
    }
    @FXML
    protected void OnfinishButtonClick(){
        ConfirmDelete.setVisible(false);
        bNameToDelete.setText("");
        bToDelete.clear();
        imgBToDelete.setVisible(false);
        Delete.setVisible(false);
    }
    @FXML protected void OnNotDeleteButtonClick(){
        ConfirmDelete.setVisible(false);
        bNameToDelete.setText("");
        bToDelete.clear();
        imgBToDelete.setVisible(false);
        Delete.setVisible(false);
    }
}
