package com.example.library_management.dao;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "library_record")
public class Library_Record {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "record_id")
    private Integer record_id;

    @CreatedDate
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "issue_date")
    private LocalDateTime issue_date = LocalDateTime.now();

    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "return_date")
    private Date return_date;

    @ManyToOne(fetch = FetchType.LAZY)
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    public Integer getRecord_id() {
        return record_id;
    }

    public void setRecord_id(Integer record_id) {
        this.record_id = record_id;
    }

    public LocalDateTime getIssue_date() {
        return issue_date;
    }

    public void setIssue_date(LocalDateTime issue_date) {
        this.issue_date = issue_date;
    }

    public Date getReturn_date() {
        return return_date;
    }

    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

}