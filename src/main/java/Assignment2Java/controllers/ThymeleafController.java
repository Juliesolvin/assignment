package Assignment2Java.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

// Only "Controller" for ThymeleafController
// We can use Thymeleaf to generate HTML view
// on our server and serve them to a web browser

@Controller
public class ThymeleafController {

    // "/" equals homepage
    @RequestMapping(value = "/", method = RequestMethod.GET)

    // From powerpoint

        public String home(Model model) {

        /*
        ArrayList<Song> randomSongs = musicRepository.get5RandomSongs();
        ArrayList<Genre> randomGenres = musicRepository.get5RandomGenres();
        ArrayList<Artist> randomArtists = musicRepository.get5RandomArtists();
        model.addAttribute("songs", randomSongs);
        model.addAttribute("artists", randomArtists);
        model.addAttribute("genres", randomGenres);
        model.addAttribute("searchObject", new SearchObject());
        return "home";

        */

        // model.addAttribute("Greeting", "HEi");
            return "Home";

        }


        // Equals resultpage
        // @GetMapping("/result")





}



