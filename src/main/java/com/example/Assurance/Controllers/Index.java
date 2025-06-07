package com.example.Assurance.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class Index {
    @GetMapping
    public String index(){
        return "login";
    }
    @PostMapping
    public String LoginAgent(){
        return "agent";
    }
    @PostMapping
    public String LoginMedecin(){
        return "medecin";
    }
}
