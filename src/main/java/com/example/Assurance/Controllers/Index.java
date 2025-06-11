package com.example.Assurance.Controllers;

import com.example.Assurance.Models.Assure;
import com.example.Assurance.Models.User;
import com.example.Assurance.Services.AssureService;
import com.example.Assurance.Services.MedecinService;
import com.example.Assurance.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@RequestMapping("/")
@Controller
public class Index {

    @Autowired
    private UserService userService;
    @Autowired
    private AssureService assureService;

    @Autowired
    private MedecinService medecinService;

    @GetMapping
    public String index() {
        return "login"; // Affiche la page de login
    }

    @PostMapping
    public String authenticate(
            @RequestParam String login,
            @RequestParam String password,
            @RequestParam(required = false) String userType,
            Model model) {

        User user = userService.authenticate(login, password);

        if (user == null) {
            model.addAttribute("error", "Identifiants incorrects.");
            return "login";
        }

        String role = userService.getUserRole(user);
        if (role == null) {
            model.addAttribute("error", "Rôle non reconnu.");
            return "login";
        }

        String currentTime = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS)
                .format(DateTimeFormatter.ofPattern("d MMMM yyyy 'à' HH:mm a 'WAT'"));
        if ("AGENT".equals(role)) {
           String identity=user.getAgentSecuriteSociale().getNom() +" "+user.getAgentSecuriteSociale().getPrenom();
            model.addAttribute("agentName", identity);
            model.addAttribute("loginTime", currentTime);
            model.addAttribute("assure", new Assure());
            model.addAttribute("assures", assureService.getAllAssures());
            model.addAttribute("medecins", medecinService.getAllMedecins() );
            return "agent";
        } else if ("MEDECIN_GENERALISTE".equals(role) || "MEDECIN_SPECIALISTE".equals(role)) {
            if("MEDECIN_GENERALISTE".equals(role)){
                String identity=user.getMedecinGeneraliste().getNom() +" "+user.getMedecinGeneraliste().getPrenom();
                model.addAttribute("medecinName", identity);
                model.addAttribute("loginTime", currentTime);
                model.addAttribute("medecinType", role); // Passer MEDECIN_GENERALISTE ou MEDECIN_SPECIALISTE
                return "medecin";
            }
            String identity = user.getMedecinSpecialiste().getNom() + " " + user.getMedecinSpecialiste().getPrenom();
            model.addAttribute("medecinName", identity);
            model.addAttribute("loginTime", currentTime);
            model.addAttribute("medecinType", role); // Passer MEDECIN_GENERALISTE ou MEDECIN_SPECIALISTE
            return "medecin";

        }
        model.addAttribute("error", "Authentification échouée.");
        return "login";
    }
}