package com.ninja_squad.geektic.dao;

import com.ninja_squad.geektic.model.Geek;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
}
