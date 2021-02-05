package com.example.sdaassign4_2020;

public class BookDetails {
    public String Author;
    public String Title;
    public String imageUrl;

    public BookDetails(){
    }

    public BookDetails(String Author, String Title, String imageUrl) {
        this.Author = Author;
        this.Title = Title;
        this.imageUrl = imageUrl;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
