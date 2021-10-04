package com.example.library_management.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Date;
import java.time.LocalDateTime;
import javax.persistence.*;

//@Entity
@Table(name = "library_record")
public class Library_Recorddto {

    @CreatedDate
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDateTime issue_date = LocalDateTime.now();

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date return_date;

    String bookName;

    String memberName;

    public Library_Recorddto() {
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

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
}