package com.example.netbooks_v2.model;

import java.io.*;
import java.nio.file.FileSystemNotFoundException;
import java.util.ArrayList;
import java.util.Collections;


public class Library {
    public ArrayList<Book> BookLibrary = new ArrayList<Book>();

    public ArrayList<Book> getBookLibrary() {
        return BookLibrary;
    }

    /**
     * Method for read CSV
     * @param pathFile
     */
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
        public void AddInCsv(String Name, String Writer, int Page, String Type, float Price,String ImagePath, String pathFile){
        try {
            FileWriter fw = new FileWriter(pathFile,true);
            BufferedWriter bw= new BufferedWriter(fw);
            PrintWriter pw=new PrintWriter(bw);

            pw.println(Name+","+Writer+","+Page+","+Type+","+Price);
            pw.flush();//
            pw.close();
            System.out.println("record saved");
        }
        catch (Exception E){
            E.printStackTrace();
            System.out.println("recod not saved");
        }
    }






    /**
     * Allow to add one book in the library
     * @param book
     */
    public void addBook(Book book) {
        BookLibrary.add(book);

    }
    public boolean deleteBook(Book book){
        return BookLibrary.remove(book);
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
}
