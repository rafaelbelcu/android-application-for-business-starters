package com.example.belcurafaelstefanapplication;

public class User {
    public String username, emailadress;

    public User(String username, String emailadress) {
        this.username = username;
        this.emailadress = emailadress;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", emailadress='" + emailadress + '\'' +
                '}';
    }
}