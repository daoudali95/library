package com.example.library_management.dto;

import java.util.List;

public class Bookdto {

    private String book_Name;

    private String author_Name;

    Integer publishers;

    public Bookdto() {
    }


    public String getBook_Name() {
        return book_Name;
    }

    public void setBook_Name(String book_Name) {
        this.book_Name = book_Name;
    }

    public String getAuthor_Name() {
        return author_Name;
    }

    public void setAuthor_Name(String author_Name) {
        this.author_Name = author_Name;
    }

    public Integer getPublishers() {
        return publishers;
    }

    public void setPublishers(Integer publishers) {
        this.publishers = publishers;
    }

}
