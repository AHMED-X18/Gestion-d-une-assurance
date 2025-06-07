package com.example.Assurance.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/assure")
@Controller
public class AssureController {

    @PostMapping("/inscription")
    public String inscrireAssure(){
        return "agent";
    }
}
