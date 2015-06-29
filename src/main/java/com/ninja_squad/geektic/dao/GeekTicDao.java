package com.ninja_squad.geektic.dao;

import com.ninja_squad.geektic.model.Geek;
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

        return query.getResultList();
    }
}
