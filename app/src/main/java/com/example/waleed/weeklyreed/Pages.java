package com.example.waleed.weeklyreed;

import com.orm.SugarRecord;

/**
 * Created by Waleed on 20/06/17.
 */

public class Pages extends SugarRecord<Pages> {

    byte[] bookPicture;
    String bookTitle;
    String pagesNumber;

    public Pages() {
    }

    public Pages(String bookTitle, String pagesNumber) {
        this.bookTitle = bookTitle;
        this.pagesNumber = pagesNumber;
    }

    public Pages(byte[] bookPicture, String bookTitle, String pagesNumber) {
        this.bookPicture = bookPicture;
        this.bookTitle = bookTitle;
        this.pagesNumber = pagesNumber;
    }

    public byte[] getBookPicture() {
        return bookPicture;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getPagesNumber() {
        return pagesNumber;
    }

    public void setBookPicture(byte[] bookPicture) {
        this.bookPicture = bookPicture;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void setPagesNumber(String pagesNumber) {
        this.pagesNumber = pagesNumber;
    }
}
