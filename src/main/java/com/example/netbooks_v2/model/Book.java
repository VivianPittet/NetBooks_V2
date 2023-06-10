package com.example.netbooks_v2.model;

/**
 * Class book with all attribute and getter setter
 */

public class Book { private float price;
    private String Name;
    private int Pages;
    private String Writer;
    private String ImagePath;
    private String Type;

    public Book(String name, int pages, String writer, String type, String imagePath, float price) {
        Name = name;
        Pages = pages;
        Writer = writer;
        Type = type;
        ImagePath = imagePath;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getPages() {
        return Pages;
    }

    public void setPages(int pages) {
        Pages = pages;
    }

    public String getWriter() {
        return Writer;
    }

    public void setWriter(String writer) {
        Writer = writer;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getImagePath() {
        return ImagePath;
    }

    public void setImagePath(String imagePath) {
        ImagePath = imagePath;
    }

    public void setPrice(float Price){
        price=Price;
    }
    public float getPrice(){
        return price;
    }
}
