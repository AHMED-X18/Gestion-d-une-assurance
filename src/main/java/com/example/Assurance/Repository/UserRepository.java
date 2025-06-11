package com.example.Assurance.Repository;

import com.example.Assurance.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByLogin(String Login);
    User findByMedecinGeneralisteNumMedGen(Integer numMedGen);
    User findByMedecinSpecialisteNumMedSpe(Integer numMedSpe);
    User findByAgentSecuriteSocialeIdAgent(Integer idAgent);
}
