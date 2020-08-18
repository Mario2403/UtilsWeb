package com.dailyWorkNotes.dailyWorkNotesApp.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/api/v1/proyectos")
public class ProyectosController {

    @GetMapping(value="/get", produces =  "application/json")
    public ResponseEntity<String> getProyectos(){
        String response = "";

        response = " [{" +
                "\"codigo\": \"4011\"," +
                "\"name\": \"Evolutivos Movistar Cloud\"" + //TODO Añadir Time
                "}," +
                "{" +
                "\"codigo\": \"4567\"," +
                "\"name\": \"PCM - NEN\"" +
                "}]";

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(value = "/saveAll")
    public void saveProyectos(@RequestBody String proyectos) throws JsonProcessingException {

        System.out.println(proyectos);

    }
}
