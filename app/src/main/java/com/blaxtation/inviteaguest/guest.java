package com.blaxtation.inviteaguest;

public class guest {

    public String name;
    public int image;


    public guest(String id, String name, String image){


    }

    public guest(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public int getName() {
        return name;
    }

    public int getImage() {
        return image;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setImage(int image) {
        this.image = image;
    }
}


