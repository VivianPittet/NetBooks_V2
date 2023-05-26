package com.example.netbooks_v2.model;

import java.util.ArrayList;

public interface Tools
{
    public String SearchName(String BookName, ArrayList<Book> booklib);
    public  ArrayList<Book> SearchWriter(String writer, ArrayList<Book> booklib);
    public ArrayList<Book> SearchType(String type, ArrayList<Book> booklib);
    public ArrayList<String> sortByName(ArrayList<Book>booklib);
    public ArrayList<String> sortByWriter(ArrayList<Book> booklib);
    public ArrayList<String> sortByType(ArrayList<Book> booklib);

   // public void SortBook();
}
