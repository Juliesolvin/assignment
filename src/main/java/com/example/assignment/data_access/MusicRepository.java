package com.example.assignment.data_access;


import com.example.assignment.models.Artist;
import com.example.assignment.models.Genre;
import com.example.assignment.models.Song;

import java.util.ArrayList;

// Repository for the homepage
// Show 5 random songs, 5 random artists, 5 random genres

public interface MusicRepository {
    public ArrayList<Song> get5songs();
    public ArrayList<Artist> get5Artists();
    public  ArrayList<Genre> get5Genre();


}
