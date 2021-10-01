package com.example.library_management.dao;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "publisher")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    @Column(name = "publisher_Name")
    @Size(min = 2, max = 25)
    private String publisher_Name;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy="publish", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Book> books;

    public Publisher() {
    }

    public String getPublisher_Name() {
        return publisher_Name;
    }

    public void setPublisher_Name(String publisher_Name) {
        this.publisher_Name = publisher_Name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
