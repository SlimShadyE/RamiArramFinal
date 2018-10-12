package com.example.user.ramiarram;

public class Spot {
    private int image;
    private String name;

    public void setImage(int image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {

        return image;
    }

    public String getName() {
        return name;
    }

    public Spot(int image, String name) {

        this.image = image;
        this.name = name;
    }
}
