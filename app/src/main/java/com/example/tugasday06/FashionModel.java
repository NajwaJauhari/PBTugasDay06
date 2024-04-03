package com.example.tugasday6;

public class FashionModel {
    public String name;
    public String price;
    public String specific;
    public int image;

    public FashionModel(String name, String price, String specific, int image) {
        this.name = name;
        this.price = price;
        this.specific = specific;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSpecific() {
        return specific;
    }

    public void setSpecific(String specific) {
        this.specific = specific;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
