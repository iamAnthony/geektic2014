package com.ninja_squad.geektic.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Anthony on 29/06/15.
 * Project : geektic2014
 */

@Entity
public class Interet {
    //Attributs

    @ManyToMany(mappedBy = "interets")
    private Set<Geek> geeks;

    @Id
    @GeneratedValue
    private int id;

    private String libelle;

    //Constructeur

    public Interet(int id, String libelle){
        this.setId(id);
        this.setLibelle(libelle);
    }

    public Interet() {
    }

    //Getter - Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
