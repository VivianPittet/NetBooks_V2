package com.example.netbooks_v2.model;

import java.util.ArrayList;

public interface Tools
{
    public String SearchName();
    public ArrayList<Book> SearchWriter();
    public ArrayList<Book> SearchType();
    public ArrayList<String> sortByName();
    public ArrayList<String> sortByWriter();
    public ArrayList<String> sortByType();

    public void SortBook();
}
