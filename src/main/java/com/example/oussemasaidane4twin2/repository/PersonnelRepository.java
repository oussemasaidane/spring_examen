package com.example.oussemasaidane4twin2.repository;


import com.example.oussemasaidane4twin2.entities.Parking;
import com.example.oussemasaidane4twin2.entities.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface PersonnelRepository extends JpaRepository <Personnel,Integer > {
   int countByPosteGardeJour ();
   List<Personnel> getPersonnelByDateDeRecrutementAfterAndDateDeRecrutementAfter(Date startDate,Date endDate);
}
