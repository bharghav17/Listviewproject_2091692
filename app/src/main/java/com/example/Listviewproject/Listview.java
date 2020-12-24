package com.example.Listviewproject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Listview {


    private String name;

    private String full_name;

    private Owner owner;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getFull_name() {
        return full_name;
    }
    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }
    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }


}
