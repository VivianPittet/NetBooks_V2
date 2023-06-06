package com.example.netbooks_v2.controller;

import com.example.netbooks_v2.HelloApplication;
import com.example.netbooks_v2.model.Admin;
import com.example.netbooks_v2.model.Book;
import com.example.netbooks_v2.model.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AdminController implements Initializable {
    @FXML
    private AnchorPane adminView;
    private Stage stage;
    private Scene scene;
    private Parent root;
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
    private Book bookToShow;


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

    // ID for modify method

    @FXML
    private Button bModify;
    @FXML
    private TextField bNameModify;
    @FXML
    private TextField bWriterModify;
    @FXML
    private TextField bTypeModify;
    @FXML
    private TextField bPriceModify;
    @FXML
    private TextField bPagesModify;
    @FXML
    private Pane paneModify;
    @FXML
    private Button backModify;
    @FXML
    private Label errorModify;

    //ID for connexion panel
    @FXML
    private Pane logInPane;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private Button logIn;




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
        bModify.setVisible(false);

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
                    bModify.setVisible(true);
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
        bookToShow = HelloApplication.Vivian.SearchName(bListView.getSelectionModel().getSelectedItem(),blib);
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
            bModify.setVisible(true);
        }
        backButton.setVisible(true);
    }

    /**
     * Back to the list to select a book
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
        bModify.setVisible(false);
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

    //ADD METHOD
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
            try {
                abPrice = Float.parseFloat(addPrice.getText());
                abPages = Integer.parseInt(addPages.getText());
                HelloApplication.LibraryTest1.addBook(new Book(abName, abPages, abWriter, abType, pathImageToAdd, abPrice));
                errorMessage.setText("Book added !");
                addWriter.clear();
                addPrice.clear();
                addPages.clear();
                addType.clear();
                addName.clear();

            } catch (Exception e) {
                errorMessage.setText("Need number for price and pages");
            }
        }
        else{
            errorMessage.setText("Please fill all the book's specification");
        }

    }
    @FXML
    protected void clearErrorLabel(){
        errorMessage.setText("");
    }

    //DELETE METHOD

    /**
     * Search the book. If found, set the delete button true. Else put a message that the book isn't found.
     */
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

    /**
     * Set the confirmation option true
     */
    @FXML
    protected void OnDeleteButtonClick(){
        ConfirmDelete.setVisible(true);
    }

    /**
     * 1) Delete the book and put a confirmation message
     * 2) If the book can't be deleted, put a message error
     * Set the finish button visible
     */
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

    /**
     * Clear all and return to the default page
     * Used by finish button and "not delte button"
     */
    @FXML
    protected void OnfinishButtonClick(){
        ConfirmDelete.setVisible(false);
        bNameToDelete.setText("");
        bToDelete.clear();
        imgBToDelete.setVisible(false);
        Delete.setVisible(false);
    }
    // Modify method

    @FXML
    protected void onModifiyButtonClick(){
        paneModify.setVisible(true); // Set the modify pane visible

    }
    @FXML
    protected void OnConfirmModificationClick(){
        pathImageToAdd = "";
        if (!bNameModify.getText().equals("")){
            bookToShow.setName(bNameModify.getText());
        }
        if (!bWriter.getText().equals("")){
            bookToShow.setWriter(bWriter.getText());
        }
        if (!bTypeModify.getText().equals("")){
            bookToShow.setType(bTypeModify.getText());
        }
        if (!bPriceModify.getText().equals("")){
            try {
                bookToShow.setPrice(Float.parseFloat(bPriceModify.getText()));
            }catch(Exception e){errorModify.setText("Please enter un number for price");
                errorModify.setTextFill(Color.RED);
            }
        }
        if (!bPagesModify.getText().equals("")){
            try {
                bookToShow.setPages(Integer.parseInt(bNameModify.getText()));
            }catch(Exception e){errorModify.setText("Please enter un number for pages");
                errorModify.setTextFill(Color.RED);
            }
        }
        if (!pathImageToAdd.equals("")){
            bookToShow.setImagePath(pathImageToAdd);
        }
        errorModify.setText("Book modified !");
        errorModify.setTextFill(Color.GREEN);
        backModify.setVisible(true);
    }
    @FXML
    protected void onBackModifyClick(){
        SearchChoiceSelected();
        paneModify.setVisible(false);
        backModify.setVisible(false);
        bNameModify.clear();
        bWriterModify.clear();
        bPagesModify.clear();
        bPriceModify.clear();
        bTypeModify.clear();
        pathImageToAdd="";
    }
    @FXML
    protected void onLogInButtonClick(){
        if (username.getLength()>0 && password.getLength()>0){
            for(Person p : HelloApplication.allPeople.getList()){
                if(p.getUserName().equals(username.getText())&&p.getPassWorld().equals(password.getText())){
                    if(p.getClass()== Admin.class){
                        System.out.println("Lancer l'admin view");
                        logInPane.setVisible(false);
                        adminView.setVisible(true);
                        break;
                    }else{
                        try{//switchToUserView();

                        }catch(Exception e){
                            System.out.println("Error");

                        }
                        System.out.println("Lancer User view");
                        break;
                    }
                }
            }
        }
    }
   /* public void switchToUserView(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("User-view"));
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();}*/


}


