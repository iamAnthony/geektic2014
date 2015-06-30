package com.ninja_squad.geektic.model;

import javax.persistence.*;
import java.util.HashSet;
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
    private Set<Interet> interets;

    @Id
    @GeneratedValue
    private int id;

    private String nom;
    private String prenom;
    private String mail;
    private String sexe;
    private String description;
    private Integer vues;

    //Constructeur

    public Geek(int id, String nom, String prenom, String mail, String sexe, String description, Integer vues) {
        this.setId(id);
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setMail(mail);
        this.setSexe(sexe);
        this.setDescription(description);
        this.setVues(vues);
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

    public Set<Interet> getInterets() { return interets; }

    public void setInterets(Set<Interet> interets) { this.interets = interets; }

    public Integer getVues() {
        return vues;
    }

    public void setVues(Integer vues) {
        this.vues = vues;
    }
}
