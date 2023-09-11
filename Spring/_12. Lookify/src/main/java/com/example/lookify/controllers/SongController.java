package com.example.lookify.controllers;

import com.example.lookify.models.Song;
import com.example.lookify.services.SongService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/songs")
public class SongController {
    @Autowired private SongService songService;

    @GetMapping("/new")
    public String newSong(@ModelAttribute("song") Song song) {
        return "newSong.jsp";
    }

    @PostMapping("/new")
    public String createSong(@Valid @ModelAttribute Song song, BindingResult result) {
        if (result.hasErrors()) {
            return "newSong.jsp";
        }
        songService.save(song);
        return "redirect:/dashboard";
    }

    @GetMapping("/{id}")
    public String showSong(@PathVariable Long id, Model model) {
        Song song = songService.findById(id);
        model.addAttribute("song", song);
        return "details.jsp";
    }

    @DeleteMapping("/{id}")
    public String deleteSong(@PathVariable Long id) {
        songService.deleteById(id);
        return "redirect:/dashboard";
    }
}
