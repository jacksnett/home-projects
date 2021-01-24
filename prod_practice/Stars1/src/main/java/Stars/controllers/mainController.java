package Stars.controllers;

import Stars.services.starsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class mainController {

    @Autowired
    private starsService service;

    @GetMapping("/GetAllPlanetsSpeeds")
    public  HashMap<String, String> GetAllPlanetsSpeeds()
    {
       return service.GetAllPlanetsSpeeds();
    }

    @GetMapping("/GetAllCircumferences")
    public  HashMap<String, String> GetAllCircumferences()
    {
        return service.GetAllPlanetsCircumferences();
    }

    @GetMapping("/GetAllDistances")
    public HashMap<String, String> GetAllDistances()
    {
       return service.GetAllPlanetsDistances();
    }
}