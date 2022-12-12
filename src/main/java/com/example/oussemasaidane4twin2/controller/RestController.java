package com.example.oussemasaidane4twin2.controller;

import com.example.oussemasaidane4twin2.entities.Parking;
import com.example.oussemasaidane4twin2.entities.Personnel;
import com.example.oussemasaidane4twin2.entities.Zone;
import com.example.oussemasaidane4twin2.repository.ParkingRepository;
import com.example.oussemasaidane4twin2.repository.PersonnelRepository;
import com.example.oussemasaidane4twin2.repository.ZoneRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Slf4j
@org.springframework.web.bind.annotation.RestController
@RequestMapping("examBlanc")
public class RestController {

    @Autowired
    ParkingRepository parkingRepository ;
    @Autowired
    PersonnelRepository personnelRepository ;
    @Autowired
    ZoneRepository zoneRepository ;

    @PostMapping("/ajouterPersonnel")
    public Personnel ajouterPersonnel(@RequestBody Personnel personnel){
         return personnelRepository.save(personnel);
    }

    @PostMapping("/ajoutParkingetZones")
    public void ajoutParkingetZones(@RequestBody Parking parking){
        Set<Zone> zones = parking.getZones();
        zones.stream().forEach(zone -> zone.setParking(parking));
        parking.setZones(parking.getZones());
        parkingRepository.save(parking);
        zoneRepository.saveAll(parking.getZones());
    }



    @GetMapping("/affecterPersonnelZone")
    public  void affecterPersonnelZone (@PathVariable int idZone , @PathVariable int idGarde ){
        Zone zone =zoneRepository.findById(idZone).orElse(null);
        Personnel garde = personnelRepository.findById(idGarde).orElse(null);
        if (zone!=null&& garde!=null){
            zone.getPersonnel().add(garde);
            zoneRepository.save(zone);
        }
    }



    @PostMapping ("/getAllPersonnelByParking")
    public List<Personnel> getAllPersonnelByParking(@RequestBody Parking parking){
        Parking parking1 = parkingRepository.findById(parking.getId()).orElse(null);
        Set<Zone> zones = parking1.getZones();
        List<Personnel> personnels=new ArrayList<Personnel>();
        zones.stream().forEach(zone -> zone.getPersonnels());
        return personnels;
    }

    @GetMapping("/nombreGardeJour")
    public Integer nombreGardeJour (@PathVariable String adresse){
        return personnelRepository.countByPosteGardeJour();
    }

    @GetMapping("/getPersonnelByDate")
    public List<Personnel> getPersonnelByDate(@PathVariable Date startDate , @PathVariable Date endDate){
        return personnelRepository.getPersonnelByDateDeRecrutementAfterAndDateDeRecrutementAfter(startDate,endDate);
    }


}
