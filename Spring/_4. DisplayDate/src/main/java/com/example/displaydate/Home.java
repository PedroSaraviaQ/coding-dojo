package com.example.displaydate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Controller
@RequestMapping("/")
public class Home {
    @RequestMapping("")
    public String home(){
        return "home.jsp";
    }

    @RequestMapping("/date")
    public String date(Model model){
        Date date=new Date();
        String formattedDate = new SimpleDateFormat("EEEE, 'the' d 'of' MMMM, yyyy", Locale.ENGLISH).format(date);
        model.addAttribute("date",formattedDate);
        return "date.jsp";
    }

    @RequestMapping("/time")
    public String time(Model model){
        Date time=new Date();
        String formattedTime = new SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(time);
        model.addAttribute("time",formattedTime);
        return "time.jsp";
    }
}
