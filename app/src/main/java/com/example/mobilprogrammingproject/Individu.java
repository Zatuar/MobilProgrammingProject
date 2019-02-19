package com.example.mobilprogrammingproject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Individu {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("prenom")
    @Expose
    private String prenom;
    @SerializedName("surnom")
    @Expose
    private String surnom;
    @SerializedName("email")
    @Expose
    private String email;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getName() { return name; }
    public void setName(String name) {
        this.name = name;
    }

    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSurnom() {
        return surnom;
    }
    public void setSurnom(String surnom) {
        this.surnom = surnom;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
