package com.ksd.health.model;

import jakarta.persistence.*;

@Entity(name = "Member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;
    @Column
    private String account;
    @Column
    private String password;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String phone;

    public Long getSeq() {
        return seq;
    }

    public void setSeq(Long seq) {
        this.seq = seq;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Member{" + "seq=" + seq + ", account='" + account + '\'' + ", password='" + password + '\'' + ", name='" + name + '\'' + ", email='" + email + '\'' + ", phone='" + phone + '\'' + '}';
    }
}
