package com.example.sdaassign4_2020;

public class BorrowerInfo {
    String requireddate, currentdate, currenttime, bookname, bookid;

    public BorrowerInfo(String requireddate) {
    }

    public BorrowerInfo(String requireddate, String currentdate, String currenttime, String bookname, String bookid) {
        this.requireddate = requireddate;
        this.currentdate = currentdate;
        this.currenttime = currenttime;
        this.bookname = bookname;
        this.bookid = bookid;
    }

    public String getRequireddate() {
        return requireddate;
    }

    public void setRequireddate(String requireddate) {
        this.requireddate = requireddate;
    }

    public String getCurrentdate() {
        return currentdate;
    }

    public void setCurrentdate(String currentdate) {
        this.currentdate = currentdate;
    }

    public String getCurrenttime() {
        return currenttime;
    }

    public void setCurrenttime(String currenttime) {
        this.currenttime = currenttime;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }


}
