package com.example.optimization;

public class AfterSales {
    private String name;
    private String text;
    private String text1;
    private String text2;
    private int photo;
    public AfterSales(String name,String text,String text1,String text2,int photo){
        this.name=name;
        this.photo=photo;
        this.text=text;
        this.text1=text1;
        this.text2=text2;
    }
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
