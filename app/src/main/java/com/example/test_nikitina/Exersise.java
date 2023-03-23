package com.example.test_nikitina;

public class Exersise {
    int id;
    int id_musle;
    String name;
    String photo;
    int description;

    public Exersise(int id, int id_musle, String name, String photo, int description) {
        this.id = id;
        this.id_musle = id_musle;
        this.name = name;
        this.photo = photo;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public int getId_musle() {
        return id_musle;
    }

    public String getName() {
        return name;
    }

    public String getPhoto() {
        return photo;
    }

    public int getDescription() {
        return description;
    }
}
