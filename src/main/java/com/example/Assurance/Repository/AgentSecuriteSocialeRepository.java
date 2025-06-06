package com.example.Assurance.Repository;

import com.example.Assurance.Models.AgentSecuriteSociale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentSecuriteSocialeRepository extends JpaRepository<AgentSecuriteSociale, Integer> {

}
