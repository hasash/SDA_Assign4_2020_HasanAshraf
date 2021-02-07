package com.example.sdaassign4_2020;
/*
 * model created to call upon the variable saved in the database to count the availability of the books
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
