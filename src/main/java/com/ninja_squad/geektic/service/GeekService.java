package com.ninja_squad.geektic.service;

import com.ninja_squad.geektic.MyException;
import com.ninja_squad.geektic.dao.GeekTicDao;
import com.ninja_squad.geektic.model.Geek;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by Anthony on 29/06/15.
 * Project : geektic2014
 */

@RestController
@RequestMapping("/geek")
public class GeekService {

    @Autowired
    private GeekTicDao dao;

    @RequestMapping(method = GET, value="/{id}")
    public Geek geekDetails(@PathVariable("id") int id) {
        Geek g = dao.findById(id);
        if (g == null)
            throw new MyException("Geek non trouvé");
        else
            return g;
    }
}
