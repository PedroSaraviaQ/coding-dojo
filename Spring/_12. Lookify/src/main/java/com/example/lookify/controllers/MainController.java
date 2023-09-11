package com.example.lookify.controllers;

import com.example.lookify.models.Song;
import com.example.lookify.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class MainController {
    @Autowired private SongService songService;

    @GetMapping("/")
    public String index() {
        return "index.jsp";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model, @ModelAttribute("song") Song song) {
        List<Song> songs = songService.findAll();
        model.addAttribute("songs", songs);
        return "dashboard.jsp";
    }
}
