package com.example.Assurance.Repository;

import com.example.Assurance.Models.Medicament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicamentRepository extends JpaRepository<Medicament,Integer> {
}
