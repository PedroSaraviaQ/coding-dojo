package com.example.tvdb.controllers;

import com.example.tvdb.models.Program;
import com.example.tvdb.models.Review;
import com.example.tvdb.models.User;
import com.example.tvdb.services.ProgramService;
import com.example.tvdb.services.ReviewService;
import com.example.tvdb.services.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/programas")
public class ProgramController {
    private final UserService userService;
    private final ProgramService programService;
    private final ReviewService reviewService;

    public ProgramController(UserService userService, ProgramService programService, ReviewService reviewService) {
        this.userService = userService;
        this.programService = programService;
        this.reviewService = reviewService;
    }

    private Double calculateAverageRating(List<Review> reviews) {
        Double sum = 0.0;
        for (Review review : reviews) {
            sum += review.getRating();
        }
        return sum / reviews.size();
    }

    @GetMapping("")
    public String showPrograms(Model model, HttpSession session) {
        if (session.getAttribute("currentUser") == null) {
            return "redirect:/";
        }
        List<Program> programs = programService.findAll();
        for (Program program : programs) {
            if (program.getReviews().isEmpty()) {
                program.setRating(0.0);
            } else {
                program.setRating(calculateAverageRating(program.getReviews()));
            }
        }
        model.addAttribute("programs", programs);
        return "allPrograms.jsp";
    }

    @GetMapping("/nuevo")
    public String newProgram(@ModelAttribute Program program, HttpSession session) {
        if (session.getAttribute("currentUser") == null) {
            return "redirect:/";
        }
        return "newProgram.jsp";
    }

    @PostMapping("/nuevo")
    public String createProgram(@Valid @ModelAttribute Program program, BindingResult result, Model model) {
        boolean matchError = programService.existsByTitle(program.getTitle());
        if (matchError) {
            model.addAttribute("matchError", "El título ya existe");
        }
        if (result.hasErrors() || matchError) {
            return "newProgram.jsp";
        }
        programService.save(program);
        return "redirect:/programas";
    }

    @GetMapping("/{id}")
    public String showProgram(@PathVariable Long id, Model model, HttpSession session) {
        if (session.getAttribute("currentUser") == null) {
            return "redirect:/";
        }
        Program program = programService.findById(id);
        List<Review> reviews = reviewService.findAllByProgram_Id(id);
        model.addAttribute("program", program);
        model.addAttribute("reviews", reviews);
        return "showProgram.jsp";
    }

    @PostMapping("/{id}/rating")
    public String giveRating(@PathVariable Long id, @RequestParam Double rating, HttpSession session) {
        User user = userService.findByEmail(((User) session.getAttribute("currentUser")).getEmail());
        Program program = programService.findById(id);
        Review review = new Review();

        review.setRating(rating);
        review.setUser(user);
        review.setProgram(program);
        reviewService.save(review);
        return "redirect:/programas/" + id;
    }

    @GetMapping("/{id}/editar")
    public String editProgram(@PathVariable Long id, Model model, HttpSession session) {
        if (session.getAttribute("currentUser") == null) {
            return "redirect:/";
        }
        Program programToEdit = programService.findById(id);
        model.addAttribute("program", programToEdit);
        return "editProgram.jsp";
    }

    @PutMapping("/{id}/editar")
    public String updateProgram(@Valid @ModelAttribute Program program, BindingResult result, Model model) {
        boolean matchError = programService.existsByTitle(program.getTitle());
        if (matchError) {
            model.addAttribute("matchError", "El título ya existe");
        }
        if (result.hasErrors() || matchError) {
            return "editProgram.jsp";
        }
        programService.save(program);
        return "redirect:/programas";
    }

    @DeleteMapping("/{id}/eliminar")
    public String deleteProgram(@PathVariable Long id) {
        programService.deleteById(id);
        return "redirect:/programas";
    }
}
