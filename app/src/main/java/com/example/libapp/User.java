package com.example.libapp;

public class User {
    public String fullname,email,username;
    public User() {}

    public User (String fullname,String email,String username){
        this.fullname = fullname;
        this.email=email;
        this.username=username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
