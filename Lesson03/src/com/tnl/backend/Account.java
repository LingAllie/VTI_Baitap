package com.tnl.backend;

import java.time.LocalDate;

public class Account {
    String email;
    String username;
    String fullName;
    LocalDate createDate;

    // Constructor
    public Account(String email, String username, String fullName, LocalDate createDate) {
        this.email = email;
        this.username = username;
        this.fullName = fullName;
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Account{" +
                "email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", fullName='" + fullName + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
