package com.example.assignment.data_access;

import com.example.assignment.models.Artist;
import com.example.assignment.models.Customer;
import com.example.assignment.models.Genre;
import com.example.assignment.models.Song;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;

// Repository for the homepage
// Show 5 random songs, 5 random artists, 5 random genres

@Repository
public class MusicRepositoryImpl implements MusicRepository {

    private String URL = ConnectionHelper.CONNECTION_URL;
    private Connection conn = null;


    // Search after songs
    // Gets song we search for. BUT need to also publish track name, artist,
    // album, and genre.

    // Take in a String to search - BUT HOW shall we get all the facts and attributes from the song?
    public Song getSongBySearch(String search) {
        Song song = null;

        try {
            conn = DriverManager.getConnection(URL);

            // Simple quiery as search
            // "?" means the searched item
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT Name FROM Track WHERE Name LIKE ?");

            preparedStatement.setString(1, "%");

            // Execute query

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                new Song(
                        resultSet.getString("Name")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return song;
    }




// Get 5 random songs
    public ArrayList<Song> get5songs() {

        ArrayList<Song> fiverandomsongs = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(URL);

            /* SQL: SELECT column[Here: name] FROM table [TRACK in our chinook database]
             * ORDER BY RANDOM()
             * LIMIT X */

            PreparedStatement preparedStatement = conn.prepareStatement("SELECT Name FROM TRACK ORDER BY RANDOM() LIMIT 5");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                fiverandomsongs.add(new Song(
                        resultSet.getString("name")
                ));
            }
        } catch (Exception exception) {
            System.out.print("Exception statement here");
        }
        finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return fiverandomsongs;
    }

// Get 5 random artists
    public ArrayList<Artist> get5Artists(){

        ArrayList<Artist> fiverandomartists = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(URL);

            /* SQL: SELECT column[Here: name] FROM table [ARTIST in our chinook database]
             * ORDER BY RANDOM()
             * LIMIT X */

            PreparedStatement preparedStatement = conn.prepareStatement("SELECT Name FROM ARTIST ORDER BY RANDOM() LIMIT 5");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                fiverandomartists.add(new Artist(
                        resultSet.getString("name")
                ));
            }
        } catch (Exception exception) {
            System.out.print("Exception statement here");
        }
        finally {
            try {
                conn.close();
            } catch (Exception e) {
                System.out.println("Exception statement here");
            }
        }
        return fiverandomartists;
    }

    // Get 5 random genres

    public ArrayList<Genre> get5Genre(){
        ArrayList<Genre> fiverandomangenre = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(URL);

            /* SQL: SELECT column[Here: name] FROM table [GENRE in our chinook database]
             * ORDER BY RANDOM()
             * LIMIT X */

            PreparedStatement preparedStatement = conn.prepareStatement("SELECT Name FROM GENRE ORDER BY RANDOM() LIMIT 5");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                fiverandomangenre.add(new Genre(
                        resultSet.getString("name")
                ));
            }
        } catch (Exception exception) {
            System.out.print("Exception statement here");
        }
        finally {
            try {
                conn.close();
            } catch (Exception e) {
                System.out.println("Exception statement here");
            }
        }
        return fiverandomangenre;
    }





}