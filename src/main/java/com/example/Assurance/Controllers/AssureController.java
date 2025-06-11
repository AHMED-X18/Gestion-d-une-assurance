package com.example.Assurance.Controllers;

import com.example.Assurance.Models.Assure;
import com.example.Assurance.Models.User;
import com.example.Assurance.Services.AssureService;
import com.example.Assurance.Services.MedecinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Controller
@RequestMapping("/assure")
public class AssureController {

    @Autowired
    private AssureService assureService;
    @Autowired
    private MedecinService medecinService;

    @PostMapping("/inscription")
    public String inscrireAssure(@Valid @ModelAttribute("assure") Assure assure, BindingResult result, Model model) {
        // Gestion des erreurs de validation
        if (result.hasErrors()) {
            model.addAttribute("agentName", "Agent Test"); // À remplacer par l'authentification réelle
            model.addAttribute("loginTime", LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS)
                    .format(DateTimeFormatter.ofPattern("d MMMM yyyy 'à' HH:mm a 'WAT'")));
            model.addAttribute("assures", assureService.getAllAssures());
            return "redirect:/assure/agent"; // Retourne à la vue avec les erreurs
        }

        try {
            // Inscription de l'assuré via le service
            Assure savedAssure = assureService.inscrireAssure(assure);
            model.addAttribute("agentName", "Agent Test"); // À remplacer par l'authentification réelle
            model.addAttribute("loginTime", LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS)
                    .format(DateTimeFormatter.ofPattern("d MMMM yyyy 'à' HH:mm a 'WAT'")));
            model.addAttribute("assures", assureService.getAllAssures());
            model.addAttribute("success", "Assuré inscrit avec succès ! ID : " + savedAssure.getNumPatient());
            return "redirect:/assure/agent";
        } catch (Exception e) {
            model.addAttribute("error", "Une erreur est survenue lors de l'inscription : " + e.getMessage());
            model.addAttribute("assure", assure); // Rétablir les données saisies
        }

        model.addAttribute("agentName", "Agent Test"); // À remplacer par l'authentification réelle
        model.addAttribute("loginTime", LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS)
                .format(DateTimeFormatter.ofPattern("d MMMM yyyy 'à' HH:mm a 'WAT'")));
        model.addAttribute("assure", new Assure()); // Réinitialiser le formulaire
        model.addAttribute("assures", assureService.getAllAssures()); // Mettre à jour la liste
        return "agent"; // Retourne à la vue agent
    }

    @GetMapping("/agent")
    public String showAgentPage(Model model) {
        // Initialisation des données pour la page agent
            model.addAttribute("loginTime", LocalDateTime.now()
                    .truncatedTo(ChronoUnit.SECONDS)
                    .format(DateTimeFormatter.ofPattern("d MMMM yyyy 'à' HH:mm a 'WAT'")));

        model.addAttribute("assure", new Assure());
        model.addAttribute("assures", assureService.getAllAssures());
        model.addAttribute("nombreAssure", assureService.getAllAssures().size());
        model.addAttribute("medecins", medecinService.getAllMedecins() );
        return "agent";
    }

    @PostMapping("/association")
    public String associerMedecinTraitant(
            @RequestParam int numAssure,
            @RequestParam int medecinId,
            Model model) {
        try {
            assureService.associerMedecinTraitant(numAssure, medecinId);
            model.addAttribute("success", "Médecin traitant associé avec succès!");
        } catch (Exception e) {
            model.addAttribute("error", "Erreur lors de l'association: " + e.getMessage());
        }
        return "redirect:/assure/agent";
    }
}