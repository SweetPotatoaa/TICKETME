package com.example.loginsqlite;

import java.io.Serializable;

public class UserModel implements Serializable {
    private String username, password, address, email,//users's table
                   article_name, category;//articles
    private int id;
    private int barcode, price,//articles
            phone_number;//users's table

    /***************GETTERS**************/
    public String getUsername(){ return username; }
    public String getPassword(){ return password; }
    public String getAdress(){ return address; }
    public String getEmail(){return email;}
    public String getArticle_name(){return article_name;}
    public String getCategory(){return category;}

    public int getBarcode(){return barcode;}
    public int getPrice(){return price;}
    public int getPhone_number(){return phone_number;}


    /*************SETTERS**************/
    public void setUsername(){}
    public void setPassword(){}
    public void setAddress(){}
    public void setEmail(){}
    public void setArticle_name(){}
    public void setCategory(){}
    public void setPhone_number(){}
}

