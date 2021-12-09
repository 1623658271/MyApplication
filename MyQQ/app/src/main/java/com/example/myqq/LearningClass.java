package com.example.myqq;

public class LearningClass {
    private String webName;
    private int imageId;
    public LearningClass(String webName,int imageId){
        this.webName = webName;
        this.imageId = imageId;
    }
    public String getWebName(){
        return webName;
    }
    public int getImageId(){
        return imageId;
    }
}
