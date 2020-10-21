package com.bilgili.androidmvcnetcoreapi.Model;

public class tblUser {

    private String UserName;
    private String Password;
    private String Salt;

    public tblUser() {
    }

    public tblUser(String userName, String password, String salt) {
        UserName = userName;
        Password = password;
        Salt = salt;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getSalt() {
        return Salt;
    }

    public void setSalt(String salt) {
        Salt = salt;
    }
}

