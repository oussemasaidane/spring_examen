package com.example.oussemasaidane4twin2.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Personnel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private  Integer id ;
    private String nom ;
    private String prenom ;
    private Integer age ;

    @Temporal(TemporalType.DATE)
    private Date dateDeRecrutement;

    private String login ;
    private String password ;

    @Enumerated(EnumType.STRING)
    private Poste poste ;

    @OneToOne
    private Zone zone ;

}
