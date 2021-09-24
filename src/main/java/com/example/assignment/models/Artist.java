package com.example.assignment.models;

// No logic, just setters and getters for an artist-object
public class Artist {

    // In assignment => artistname is shown on searchresult
    private String artistname;

    // Constructor
    public Artist(String artistname) {
        this.artistname = artistname;
    }

    // Setter
    public void setArtistName(String name) {
        this.artistname = name;
    }

    // Getter
    public String getArtistName(){
        return artistname;
    }


    }
