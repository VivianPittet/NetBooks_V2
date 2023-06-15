package com.example.netbooks_v2.model;
import java.io.*;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.jar.Attributes;


public class Library {
    public ArrayList<Book> BookLibrary = new ArrayList<Book>();

    public ArrayList<Book> getBookLibrary() {
        return BookLibrary;
    }


    /**
     * Method for read CSV and take all value at one index and put it in a list.
     *
     * @param pathFile
     */
    public boolean readCSV(String pathFile) {
        boolean confirmationAdded = false;
        ArrayList<String> NameList = new ArrayList<String>();
        ArrayList<String> WriterList = new ArrayList<String>();
        ArrayList<String> PageList = new ArrayList<String>();
        ArrayList<String> TypeList = new ArrayList<String>();
        ArrayList<String> PriceList = new ArrayList<String>();
        ArrayList<String> PathImageList = new ArrayList<>();
        String Line = "";
        String[] splitLine;

        try {
            BufferedReader br = new BufferedReader(new FileReader(pathFile));
            Line = br.readLine(); // Enlève la première ligne;
            while ((Line = br.readLine()) != null) {//récupérer chaques lignes de notre csv et l'insérer dans la variable Line
                splitLine = Line.split(",");
                System.out.println(Arrays.toString(splitLine));
                NameList.add(splitLine[0].trim()); //enlève les espaces en début et fin
                WriterList.add(splitLine[1].trim()); //comment faire avancer pour prendre la colonne 2
                PageList.add(splitLine[2].trim());
                TypeList.add(splitLine[3].trim());
                PriceList.add(splitLine[4].trim());
                PathImageList.add(splitLine[5].trim());
                }
                for (int i = 0; i+1 <= NameList.size(); i++) {
                    addBook(new Book(NameList.get(i), Integer.parseInt(PageList.get(i)), WriterList.get(i), TypeList.get(i), PathImageList.get(i),Float.parseFloat(PriceList.get(i))));
                confirmationAdded=true;


            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("le fichier n'a pas été récupérer");

        } return confirmationAdded;
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



