package com.example.Assurance.Services;

import com.example.Assurance.Models.User;
import com.example.Assurance.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Authentifie un utilisateur (médecin ou agent) en fonction de son login et mot de passe.
     * @param login Le login de l'utilisateur
     * @param password Le mot de passe de l'utilisateur
     * @return L'utilisateur authentifié, ou null si l'authentification échoue
     */
    public User authenticate(String login, String password) {
        // Recherche de l'utilisateur par login
        User user = userRepository.findByLogin(login);

        // Vérification si l'utilisateur existe et si le mot de passe correspond
        if (user != null && user.getMotDePasse().equals(password)) {
            return user;
        }
        return null;
    }

    /**
     * Détermine le rôle de l'utilisateur après authentification.
     * @param user L'utilisateur authentifié
     * @return Le rôle de l'utilisateur (AGENT, MEDECIN_GENERALISTE, MEDECIN_SPECIALISTE, ou null si indéterminé)
     */
    public String getUserRole(User user) {
        if (user == null) return null;

        // Vérification des attributs de l'utilisateur

        // Priorité : si idAgent est non null, c'est un agent
        if (user.getAgentSecuriteSociale() != null) {
            return "AGENT";
        }
        // Si numMedGen est non null, c'est un médecin généraliste
        else if (user.getMedecinGeneraliste() != null) {
            return "MEDECIN_GENERALISTE";
        }
        // Si numMedSpe est non null, c'est un médecin spécialiste
        else if (user.getMedecinSpecialiste() != null) {
            return "MEDECIN_SPECIALISTE";
        }
        return null; // Rôle non reconnu
    }

}