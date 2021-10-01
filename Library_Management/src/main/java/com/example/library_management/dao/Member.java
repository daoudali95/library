package com.example.library_management.dao;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Set;

@Entity
@Table(name = "Member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_id")
    private int member_id;

    @Column(name = "member_Name")
    private String member_Name;

    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "phone_Number")
    private String   phone_Number;

    @OneToMany(mappedBy="member", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Library_Record> library_records;

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public String getMember_Name() {
        return member_Name;
    }

    public void setMember_Name(String member_Name) {
        this.member_Name = member_Name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_Number() {
        return phone_Number;
    }

    public void setPhone_Number(String  phone_Number) {
        this.phone_Number = phone_Number;
    }

    public Member() {
    }
}
