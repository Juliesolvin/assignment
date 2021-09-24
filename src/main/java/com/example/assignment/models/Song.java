package com.example.assignment.models;

// No logic, just setters and getters for an song-object
public class Song {

    // How to show searched for songs? And get the trackname, album, genre, artist?

    private String Songname;

    // Constructor
    public Song(String Songname) {
        this.Songname = Songname;
    }

    // Setter
    public void setSongname(String name) {
        this.Songname = name;
    }

    // Getter
    public String getSongname(){
        return Songname;
    }


}
