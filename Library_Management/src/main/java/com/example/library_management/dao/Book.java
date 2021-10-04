package com.example.library_management.dao;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private Integer book_id;

    @Column(name = "book_Name")
    private String bookName;

    @Column(name = "author_Name")
    private String author_Name;

    @OneToMany(mappedBy="book", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Library_Record> library_records;

    @ManyToOne(fetch = FetchType.EAGER)
    private Publisher publish;

    public Book(Set<Library_Record> library_book_records) {
        this.library_records = library_book_records;
    }

    public Book() {
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor_Name() {
        return author_Name;
    }

    public void setAuthor_Name(String author_Name) {
        this.author_Name = author_Name;
    }

    public Publisher getPublish() {
        return publish;
    }

    public void setPublish(Publisher publish) {
        this.publish = publish;
    }
}
