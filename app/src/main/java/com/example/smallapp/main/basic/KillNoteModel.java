package com.example.smallapp.main.basic;

public class KillNoteModel {

    String image;
    String name;
    String reason;

    public KillNoteModel(String image,String name,String reason) {
        this.image = image;
        this.name = name;
        this.reason = reason;


    }
    public String getName() {
        return name;
    }

    public String getReason() {
        return reason;
    }

    public String getImageResourceId() {
        return image;
    }
}
