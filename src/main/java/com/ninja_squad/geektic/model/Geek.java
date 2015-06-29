package com.ninja_squad.geektic.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Anthony on 29/06/15.
 */
@Entity
public class Geek {
    //Attributs

    @ManyToMany
    @JoinTable(name = "GEEK_INTERET",
            joinColumns = @JoinColumn(name = "ID_GEEK"),
            inverseJoinColumns = @JoinColumn(name = "ID_INTERET"))
    private Set<Interet> Interets;

    @Id
    private int id;

    private String nom;
    private String prenom;
    private String mail;
    private String sexe;
    private String description;

    //Constructeur

    public Geek(int id, String nom, String prenom, String mail, String sexe, String description) {
        this.setId(id);
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setMail(mail);
        this.setSexe(sexe);
        this.setDescription(description);
    }

    public Geek() {
    }

    //Getter - Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
