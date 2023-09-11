package com.example.lookify.controllers;

import com.example.lookify.models.Song;
import com.example.lookify.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/search")
public class SearchController {
    @Autowired private SongService songService;

    @PostMapping("")
    public String songsByArtist(@RequestParam String artist) {
        if (artist.isEmpty()) {
            return "redirect:/dashboard";
        }
        return "redirect:/search/" + artist;
    }

    @GetMapping("/{artist}")
    public String songsByArtist(@PathVariable String artist, Model model) {
        List<Song> songs = songService.findAllByArtistContaining(artist);
        model.addAttribute("songs", songs);
        return "songsByArtist.jsp";
    }

    @GetMapping("/topTen")
    public String topTenSongs(Model model) {
        List<Song> songs = songService.findTop10ByOrderByRatingDesc();
        model.addAttribute("songs", songs);
        return "topTen.jsp";
    }
}
