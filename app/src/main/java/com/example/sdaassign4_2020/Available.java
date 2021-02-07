package com.example.sdaassign4_2020;
/**
 * Model created to call upon the variable saved in the database to count the availability of the books
 * Primarily the Stock Availability of the books
 * @author Hasan Ashraf
 */
public class Available {
    public String stock;

    public Available(String stock) {
        this.stock = stock;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }
    public Available(){
    }


}
