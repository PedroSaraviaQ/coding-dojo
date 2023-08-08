package com.example.userinformation;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Home", value = "/Home")
public class Home extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = checkNull(request, "firstName");
        String lastName = checkNull(request, "lastName");
        String favoriteLanguage = checkNull(request, "favoriteLanguage");
        String homeTown = checkNull(request, "homeTown");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String title = "<h1>Welcome, " + firstName + " " + lastName + "</h1>";
        String language = "<h2>Your favorite language is: " + favoriteLanguage + "</h2>";
        String home = "<h2>Your hometown is: " + homeTown + "</h2>";

        out.write(title + language + home);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

    protected String checkNull(HttpServletRequest request, String parameter) {
        String value = request.getParameter(parameter);
        if (value == null) {
            return "Unknown";
        }
        return value;
    }
}