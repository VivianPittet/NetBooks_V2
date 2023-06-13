package com.example.netbooks_v2.model;
import java.io.*;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;


public class Library {
    public ArrayList<Book> BookLibrary = new ArrayList<Book>();

    public ArrayList<Book> getBookLibrary() {
        return BookLibrary;
    }
    public ArrayList< String > NameList= new ArrayList<String>();
    public ArrayList< String > WriterList= new ArrayList<String>();
    public ArrayList<String> PageList= new ArrayList<String>();
    public ArrayList< String > TypeList=  new ArrayList<String>();
    public ArrayList< String > PriceList=new ArrayList<String>();

    /**
     * Method for read CSV and take all value at one index and put it in a list.
     *
     * @param pathFile
     */
    public void readCSV(String pathFile) {

        String Line = "";
        String[] splitLine;
        try {
            BufferedReader br = new BufferedReader(new FileReader(pathFile));
            while ((Line = br.readLine()) != null){ //récupérer chaques lignes de notre csv et l'insérer dans la variable Line
                splitLine = Line.split(",");
                NameList.add(splitLine[0]);
                WriterList.add(splitLine[1]); //comment faire avancer pour prendre la colonne 2
                PageList.add(splitLine[2]);
                TypeList.add(splitLine[3]);
                PriceList.add(splitLine[4]);
            }
            System.out.println(NameList);
            System.out.println(WriterList);
            System.out.println(PageList);
            System.out.println(TypeList);
            System.out.println(PriceList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("le fichier n'a pas été récupérer");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void AddInCsv(String Name, String Writer, int Page, String Type, float Price, String ImagePath, String pathFile) {
        try {
            FileWriter fw = new FileWriter(pathFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.println(Name + "," + Writer + "," + Page + "," + Type + "," + Price);
            pw.flush();//
            pw.close();
            System.out.println("record saved");
        } catch (Exception E) {
            E.printStackTrace();
            System.out.println("recod not saved");
        }
    }

    public void CSV(String pathFile) {
        ArrayList< String > NameList;
        ArrayList< String > WriterList;
        ArrayList< String > PageList;
        ArrayList< String > TypeList;
        ArrayList< String > PriceList;


        ArrayList< String > imagePathList;

        try {
            File data = new File(pathFile);
            Scanner sc = new Scanner(data);
            String Line;
            String[] splitLine;
            int element;
            Line = sc.nextLine();
            while (sc.hasNext()) {
                Line = sc.nextLine();
                splitLine = Line.split(",");
                /*for (int i; i==splitLine.length; i++) {
                    NameList.add.splitLine[1];*/

                    //créer une méthode qui lit ligne par ligne le fichier
                    //qui va prendre pour chaque ligne, l'indexe de l'èlement et le mettre dans la bonne liste


                }
            }

        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    /*for ( String[] splitLine: String Line){
                }
                ArrayList < String >.readline
                List<String> entete = new ArrayList<>(); //permet de stocker les entete du csv
                List<List<String>> donnees = new ArrayList<>();//permet de stocker les données pour chaque ligne du csv

                try (BufferedReader br = new BufferedReader(new FileReader(pathFile))) { // nous permer de lire le contenu
                    String Line;*/



    /**
     * Allow to add one book in the library
     *
     * @param book
     */
    public void addBook(Book book) {
        BookLibrary.add(book);

    }

    public boolean deleteBook(Book book) {
        return BookLibrary.remove(book);
    }


    /**
     * Allow to add a list of Book in the library
     *
     * @param bookList
     */
    public void addBookList(ArrayList<Book> bookList) {
        for (Book b : bookList) {
            BookLibrary.add(b);
        }
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


