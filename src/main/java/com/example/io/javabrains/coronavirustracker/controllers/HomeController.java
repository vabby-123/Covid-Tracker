package com.example.io.javabrains.coronavirustracker.controllers;

import com.example.io.javabrains.coronavirustracker.services.CoronaVirusDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class HomeController {

    @Autowired
    CoronaVirusDataService  coronaVirusDataService;


   @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("locationStats",coronaVirusDataService.getAllStats());
        model.addAttribute("s","Low Cases");


        return "home";
    }
}
