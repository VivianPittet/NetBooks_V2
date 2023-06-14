package com.example.netbooks_v2.controller;

import com.example.netbooks_v2.HelloApplication;
import com.example.netbooks_v2.model.Admin;
import com.example.netbooks_v2.model.Book;
import com.example.netbooks_v2.model.Person;
import javafx.event.ActionEvent;
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
    @FXML
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
    private Button GoUser;
    @FXML
    private Accordion adminView;
    @FXML
    private Pane logInPane;
    @FXML
    private TextField username;
    @FXML
    private TextField password;


    /**
     * Used to clear the page when you change the search method
     */
    @FXML
    protected void resetSearchPage() {
        pathImageToAdd="";
        ShowBook.setVisible(false);
        bModify.setVisible(false);
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
                bListView.getItems().addAll(bookName); //Put all the name in the listView
                ShowBook.setVisible(true); //Show the button "show book"
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
                    bListView.getItems().addAll(bookName);
                    ShowBook.setVisible(true);
                }
                else{
                        bName.setText("No type found");}
                break;}
        }

    }

    /**
     * Show the book and set the list book visibility false
     * Set back button visibility true
     */
    @FXML
    protected void onShowBookButtonClick(){
        bookToShow = HelloApplication.Vivian.SearchName(bListView.getSelectionModel().getSelectedItem(),HelloApplication.LibraryTest1.getBookLibrary());
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
                System.out.println("Erreur in show book method");
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

    /**
     * Generic method to select a image and set the pathImageToAdd variable
     * /!\ the image will be in the folder BookPictures
     */
    @FXML
    protected void onSelectPictureClick(){
        FileChooser FC = new FileChooser();
        File SelectedFile = FC.showOpenDialog(null);
        try{
            pathImageToAdd = "BookPictures/"+SelectedFile.getName(); //create the relatif path
            System.out.println("PathImage loaded");
        } catch(Exception e){
            System.out.println("Erreur chargement image");
        }

    }

    /**
     * Verify that text field are not empty.
     * Verify that price and page are number
     * Create a book and put it in the library
     */
    @FXML
    protected void OnAddBookClick(){
        errorMessage.setText("");
        String abName;
        String abWriter;
        String abType;
        float abPrice;
        int abPages;
        if ( addWriter.getLength()>0 && addType.getLength()>0 && addName.getLength()>0 && addPages.getLength()>0 && addPrice.getLength()>0 ) { //Verify if the textfield are not empty
            abWriter = addWriter.getText();
            abName = addName.getText();
            abType = addType.getText();
            try {                                                   // Verifiy that price and page are number
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
    protected void OnSelectCSVButtonClick(){
        errorMessage.setText("");
        try {
            FileChooser FC = new FileChooser();

            File CsvFile = FC.showOpenDialog(null);

            if (HelloApplication.LibraryTest1.readCSV("DataBooks/" + CsvFile.getName())) {
                errorMessage.setText("Book added");
                errorMessage.setTextFill(Color.GREEN);

            } else {
                errorMessage.setText("Error with adding method");
                errorMessage.setTextFill(Color.RED);
            }
        }catch(Exception e){
            errorMessage.setText("Pleas Select a CSV file");
        };
    }
    @FXML
    protected void clearErrorLabel(){
        errorMessage.setText("");
    }



    //DELETE METHOD


    /**
     * Reset de delete page to default value
     */
    @FXML
    protected void resetDeletePage(){
        Delete.setVisible(false);
        ToDelete=null;
        bNameToDelete.setText("");
        bToDelete.clear();
        imgBToDelete.setVisible(false);
        ConfirmDelete.setVisible(false);
        finishButton.setVisible(false);
        deleteMessage.setText("Do you realy want to delete this book ?");
    }

    /**
     * Search the book. If found, set the delete button true. Else put a message that the book isn't found.
     */
    @FXML
    protected void OnSearhButtonClickDelete(){
        String PathImage = "not the good path";
        ToDelete = HelloApplication.Vivian.SearchName(bToDelete.getText(), HelloApplication.LibraryTest1.getBookLibrary()); // Récupère champs de texte et renvoi le livre correspondant.
        if (ToDelete != null) { //Show the book and his picture
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




    // Modify method


    /**
     * Show the modifcation pane et show the back button
     */

    @FXML
    protected void onModifiyButtonClick(){
        resetModifyPane(); // Used to clear the panel in the case of not cleared before
        paneModify.setVisible(true); // Set the modify pane visible
        backModify.setVisible(true);

    }

    /**
     * Take the new data and mofify the book
     * If the textfield are empty, the book attribut is not changed
     * Put a confirmation message
     * Verify that pages and float are number
     */
    @FXML
    protected void OnConfirmModificationClick(){
        int bookIndex;
        if (!bNameModify.getText().equals("")){
            bookToShow.setName(bNameModify.getText());
        }
        if (!bWriterModify.getText().equals("")){
            bookToShow.setWriter(bWriterModify.getText());
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
            bookToShow.setImagePath(pathImageToAdd);;
            pathImageToAdd=""; //The future image will not modified in case of no usage of textfield
        }
        errorModify.setText("Book modified !");
        errorModify.setTextFill(Color.GREEN);
    }

    /**
     * Used to reset the modify pane to default view
     */
    @FXML
    protected void resetModifyPane(){
        bNameModify.clear();
        bWriterModify.clear();
        bPagesModify.clear();
        bPriceModify.clear();
        bTypeModify.clear();
        errorModify.setText("");

    }

    /**
     * Reset de modification pane
     * Make de pane and button disapear
     */
    @FXML
    protected void onBackModifyClick(){
        resetModifyPane();
        paneModify.setVisible(false);
        backModify.setVisible(false);
        resetSearchPage();
    }

    // Log in method

    /**
     * Go through the person list and check if he's a user or admin
     * If admin, show the admin view
     * If user, load the user view
     * @param event used to load the user view on logIn button click
     */
    @FXML
    protected void onLogInButtonClick(ActionEvent event){
        if (username.getLength()>0 && password.getLength()>0){
            for(Person p : HelloApplication.allPeople.getList()){ // allPeople are the class with all the users of the application
                if(p.getUserName().equals(username.getText())&&p.getPassWorld().equals(password.getText())){
                    if(p.getClass()== Admin.class){
                        System.out.println("Lancer l'admin view");
                        logInPane.setVisible(false);
                        adminView.setVisible(true);
                        GoUser.setVisible(true);

                        break;
                    }else{
                        try{HelloApplication.switchScene(event);

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
    @FXML
    public void GoToUserView(ActionEvent event){
        HelloApplication.switchScene(event);
    }

}


