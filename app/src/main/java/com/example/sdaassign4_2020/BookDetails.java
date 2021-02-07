package com.example.sdaassign4_2020;
/**
 * Model file used to call the content saved in the firebase database
 * @param   @Author, Title, Image, Availability;
 * @return getter and setter to call upon content of database
 * @author Hasan Ashraf
 * Constructor, Getter and Setter Created for each field that is called upon from the database
 */
public class BookDetails {
    public String author;
    public String title;
    public String imageUrl;
    public String stock;

    public BookDetails(String author, String title, String imageUrl) {
        this.author = author;
        this.title = title;
        this.imageUrl = imageUrl;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }



    public BookDetails(String stock) {
        this.stock = stock;
    }

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


    public BookDetails(){
    }

}
