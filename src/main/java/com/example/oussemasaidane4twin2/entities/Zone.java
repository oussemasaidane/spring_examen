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
public class Zone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id ;
    private String ref ;
    private Float dimension ;

    @ManyToOne
    private Parking parking ;

    @OneToMany
    private Set<Personnel> personnel ;

    @OneToOne
    private Personnel personnels ;
}
