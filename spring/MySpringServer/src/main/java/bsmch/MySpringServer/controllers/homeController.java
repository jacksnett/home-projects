package bsmch.MySpringServer.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class homeController {
    @RequestMapping("/")
    public String home() {
        return "views/index.html";
    }
}
