package com.example.thesecondwork.Activities;

public class Bean {
    private String name;
    private int imageId;
    public Bean(String Name,int imageId){
        this.name = Name;
        this.imageId = imageId;
    }
    public String getName(){
        return name;
    }
    public int getImageId(){
        return imageId;
    }
}
