package com.dailyWorkNotes.dailyWorkNotesApp.controllers;


import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/api/v1/home")
public class HomeController {


    @GetMapping(value = "/", produces = "application/json")
    public String sayHello() {
        return "Hola";
    }
}
