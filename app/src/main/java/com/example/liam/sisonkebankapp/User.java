package com.example.liam.sisonkebankapp;

class User {
    private String userName;
    private String userEmail;
    private String userPassword;
    private String userMobile;
    private String userGender;

    private String userSurname;
    private Double currentAccountBal;
    private Double savingsAccountBal;

//Constructor
    public User() {

    }

    //Getter and Setters
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public Double getCurrentAccountBal() {
        return currentAccountBal;
    }

    public void setCurrentAccountBal(Double currentAccountBal) {
        this.currentAccountBal = currentAccountBal;
    }

    public Double getSavingsAccountBal() {
        return savingsAccountBal;
    }

    public void setSavingsAccountBal(Double savingsAccountBal) {
        this.savingsAccountBal = savingsAccountBal;
    }
}
