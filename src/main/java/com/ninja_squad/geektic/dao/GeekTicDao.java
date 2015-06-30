package com.ninja_squad.geektic.dao;

import com.ninja_squad.geektic.model.Geek;
import com.ninja_squad.geektic.model.Interet;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
        System.out.println("findallgeeks");

        return query.getResultList();
    }

    //Récuperer tous les centres d'intérêts
    public List<Interet> getAllInterests(){
        String jpql = "SELECT i FROM Interet AS i";
        TypedQuery<Interet> query = em.createQuery(jpql, Interet.class);

        return query.getResultList();
    }

    //Recherche de geek d'après des critères
    public List<Geek> findByCriteria(String sexe){
        String jpql = "SELECT g FROM Geek AS g WHERE g.sexe = :sexe";
        /*if (interets.size() == 1)
            jpql += " AND i.id = :interet";
        else if (interets.size() > 1) {
            jpql += " AND (";
            for(int i = 0; i != i-2; i++){
                jpql += " i.id = :interet OR";
            }
            jpql.substring(0, jpql.length()-2);
            jpql += ")";
        }*/

        TypedQuery<Geek> query = em.createQuery(jpql, Geek.class);
        query.setParameter("sexe", sexe);//.setParameter("interet", interets);

        List<Geek> result = query.getResultList();
        return result;
    }
}
