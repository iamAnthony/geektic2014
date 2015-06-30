package com.ninja_squad.geektic.service;

import com.ninja_squad.geektic.MyException;
import com.ninja_squad.geektic.dao.GeekTicDao;
import com.ninja_squad.geektic.model.Geek;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by Anthony on 29/06/15.
 * Project : geektic2014
 */

@RestController
@Transactional
@RequestMapping("/geek")
public class GeekService {
    @Autowired
    private GeekTicDao dao;

    //On appelle le DAO pour rechercher un Geek par son ID, et on incrémente la vue si le profil est trouvé.
    @RequestMapping(method = RequestMethod.GET, value="/{id}")
    public Geek geekDetails(@PathVariable("id") int id) {
        Geek g = dao.findById(id);
        if (g == null)
            throw new MyException("Geek non trouvé");
        else
            dao.addVue(id);
            return g;
    }

    //On appelle le DAO pour récuperer tous les Geek en BDD
    @RequestMapping(method = RequestMethod.GET)
    public List<Geek> list() {
        return dao.findAllGeeks();
    }

    //On appelle le DAO pour la recherche par sexe (si seul le sexe est indiqué dans le formulaire de recherche)
    @RequestMapping(method = RequestMethod.GET, params = {"sexe","interets"})
    public List<Geek> geekCriteria(@RequestParam("sexe") String sexe, @RequestParam("interets") List<Integer> interets) {
        return dao.findByCriteria(sexe, interets);
    }

    //On appelle le DAO pour la recherche par sexe et interets grace aux parametres de l'appel
    @RequestMapping(method = RequestMethod.GET, params = {"sexe"})
    public List<Geek> geekSexe(@RequestParam("sexe") String sexe) {
        return dao.findByCriteria(sexe);
    }
}
