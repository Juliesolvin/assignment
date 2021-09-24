package com.example.assignment.models;

// No logic, just setters and getters for an genre-object
public class Genre {

    private String Genrename;

    // Constructor
    public Genre(String Genrename) {
        this.Genrename = Genrename;
    }

    // Setter
    public void setGenreName(String name) {
        this.Genrename = name;
    }

    // Getter
    public String getGenreName(){
        return Genrename;
    }


}
