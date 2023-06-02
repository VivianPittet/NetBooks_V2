package com.example.netbooks_v2.model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystemNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.io.BufferedReader;
import java.io.FileReader;


public class Library {
    public ArrayList<Book> BookLibrary = new ArrayList<Book>();

    public ArrayList<Book> getBookLibrary() {
        return BookLibrary;
    }

    public void readCSV(String pathFile) {
        String Line= "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(pathFile));
            while((Line = br.readLine())!= null) //récupérer chaques lignes de notre csv et l'insérer dans la variable Line
                System.out.println(Line);
            System.out.println("le fichier a été récupérer");
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("le fichier n'a pas été récupérer");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        }




    /**
     * Allow to add one book in the library
     * @param book
     */
    public void addBook(Book book) {
        BookLibrary.add(book);

    }


    /**
     * Allow to add a list of Book in the library
     * @param bookList
     */
    public void addBookList(ArrayList<Book> bookList){
        for (Book b : bookList){
            BookLibrary.add(b);
        }
    }

    /**
     * Used to search a book's name
     * @param BookName
     * @return the book's name
     */
    /*public String SearchName(String BookName) {
        String SearchedBook = "Book not found";
        for(Book b: BookLibrary){
            if (b.getName().equals(BookName)){
                SearchedBook = b.getName();
            }
        }
        System.out.println("SearchName succes");
        return SearchedBook;

    }*/

    /**
     * Used to search books of a writer
     * @param writer
     * @return a list of book with the resquested writer
     */
    /*public ArrayList<Book> SearchWriter(String writer){ // Sort the book in the fxml method
        ArrayList<Book> searchedWriter = new ArrayList<Book>();
        for(Book b : BookLibrary){
            if (b.getWriter().equals(writer)){
                searchedWriter.add(b);
            }
        }
        System.out.println("succes writer");
        return searchedWriter;
    }*/

    /**
     * Used to search book by type
     * @param type
     * @return list of book coresponding to the requested type
     */
    /*public ArrayList<Book> SearchType(String type){
        ArrayList<Book> searchedType = new ArrayList();
        for(Book b : BookLibrary){
            if (b.getType().equals(type)){
                searchedType.add(b);
            }
        }
        System.out.println("Succes type");
        return searchedType;
    }*/

    /**
     * Method to sort the library by name in alphabetic order
     * @return a arraylist of names
     */
    /*public ArrayList<String> sortByName(){
        ArrayList<String> NameLibrary = new ArrayList<String>();
        for(Book b: BookLibrary){
            NameLibrary.add(b.getName());
        }
        Collections.sort(NameLibrary);
        return NameLibrary;
    }*/

    /**
     * Method to sort the library by writer in alphabetic order
     * @return a list of writer
     */
    /*public ArrayList<String> sortByWriter(){
        ArrayList<String> WriterLibrary = new ArrayList<String>();
        for(Book b: BookLibrary){
            WriterLibrary.add(b.getWriter());
        }
        Collections.sort(WriterLibrary);
        return WriterLibrary;
    }*/

    /**
     *Method to sort by type in alphabetic order
     * @return a list of type
     */
    /*public ArrayList<String> sortByType(){
        ArrayList<String> TypeLibrary = new ArrayList<>();
        for(Book b: BookLibrary){
            TypeLibrary.add(b.getType());
        }
        Collections.sort(TypeLibrary);
        return TypeLibrary;
    }*/

}
