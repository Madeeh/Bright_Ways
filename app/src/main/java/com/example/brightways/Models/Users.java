package com.example.brightways.Models;

public class Users {
    String name, address, phone, email, password, image, userName, userId;

    public Users(String name, String address, String phone, String email, String password, String image, String userName, String userId) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.image = image;
        this.userName = userName;
        this.userId = userId;
    }

    public Users() {
    }

    // SignUp Constructor
    public Users(String name, String address,String image,  String phone, String email, String password) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.image = image;
        this.email = email;
        this.password = password;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


}

