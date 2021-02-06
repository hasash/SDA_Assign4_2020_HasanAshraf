package com.example.sdaassign4_2020;

public class BookDetails {
    public String author;
    public String title;
    public String imageUrl;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BookDetails(String author, String title, String imageUrl) {
        this.author = author;
        this.title = title;
        this.imageUrl = imageUrl;
    }



    public BookDetails(){
    }




}
