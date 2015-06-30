package com.ninja_squad.geektic.dao;

import com.ninja_squad.geektic.model.Geek;
import com.ninja_squad.geektic.model.Interet;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Anthony on 29/06/15.
 * Project : geektic2014
 */
@Repository
public class GeekTicDao {
    @PersistenceContext
    private EntityManager em;

    //Rechercher un geek dans la BD, d'après son ID
    public Geek findById(int id) {
        return em.find(Geek.class, id);
    }

    //Récuperer tous les geeks de la BD
    public List<Geek> findAllGeeks(){
        String jpql = "SELECT g FROM Geek AS g";
        TypedQuery<Geek> query = em.createQuery(jpql, Geek.class);

        return query.getResultList();
    }

    //Récuperer tous les centres d'intérêts
    public List<Interet> getAllInterests(){
        String jpql = "SELECT i FROM Interet AS i";
        TypedQuery<Interet> query = em.createQuery(jpql, Interet.class);

        return query.getResultList();
    }

    //Recherche de geek d'après des critères de sexe et d'interets
    public List<Geek> findByCriteria(String sexe, List<Integer> interets){
        String jpql = "SELECT distinct g FROM Geek g JOIN g.interets i WHERE g.sexe = :sexe AND i.id IN (:interets)";

        Query query = em.createQuery(jpql);
        query.setParameter("sexe", sexe).setParameter("interets", interets);

        return query.getResultList();
    }

    //Recherche de geek par leur sexe
    public List<Geek> findByCriteria(String sexe){
        String jpql = "SELECT distinct g FROM Geek g WHERE g.sexe = :sexe";

        Query query = em.createQuery(jpql);
        query.setParameter("sexe", sexe);

        return query.getResultList();
    }

    //Incrémentation du compteur du nombre de vues pour le geek consulté
    public void addVue(int id_geek) {
        Geek g = findById(id_geek);
        g.setVues(g.getVues()+1);

        em.persist(g);
    }
}
