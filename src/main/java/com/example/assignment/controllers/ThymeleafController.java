package com.example.assignment.controllers;

import com.example.assignment.data_access.MusicRepository;
import com.example.assignment.models.Artist;
import com.example.assignment.models.Genre;
import com.example.assignment.models.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import java.util.ArrayList;

// Only "Controller" for ThymeleafController
// We can use Thymeleaf to generate HTML view
// on our server and serve them to a web browse

@Controller
public class ThymeleafController {

    // So the methods can reach non-static methods
    @Autowired
    MusicRepository musicrepository;

    /*
    The controller for thymeleaf and front-end part of the project
    Gets data from Music repository, and returns "home"
     */

        /*
        When opening the home-page =>
        The homepage view is going to show:
        - 5 random artists,
        - 5 random songs,
        - 5 random Genres
        This is requestet through this requiestmapping

         */

        // "/" means homepage

        @RequestMapping(value = "/", method = RequestMethod.GET)
        public String homeView(Model model) {

            ArrayList<Artist> fiveartists = musicrepository.get5Artists();
            ArrayList<Song> fivesongs = musicrepository.get5songs();
            ArrayList<Genre> fivegenres = musicrepository.get5Genre();

            model.addAttribute("artists", fiveartists);
            model.addAttribute("songs", fivesongs);
            model.addAttribute("genres", fivegenres );


            return "home";
        }

        // How to show searched for songs? And get the trackname, album, genre, artist,

}



