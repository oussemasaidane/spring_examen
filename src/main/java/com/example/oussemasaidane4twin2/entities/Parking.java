package com.example.oussemasaidane4twin2.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Parking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id ;
    private  String designation ;
    private  String adresse ;
    private  int capacité ;

    @OneToMany(mappedBy = "parking")
    private Set<Zone> zones ;
}
