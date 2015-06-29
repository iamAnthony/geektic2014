package com.ninja_squad.geektic.service;

import com.ninja_squad.geektic.dao.GeekTicDao;
import com.ninja_squad.geektic.model.Interet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Anthony on 29/06/15.
 * Project : geektic2014
 */

@RestController
@Transactional
@RequestMapping("/interets")
public class InteretService {
    @Autowired
    private GeekTicDao dao;

    @RequestMapping(method = RequestMethod.GET)
    public List<Interet> services(){
        return dao.getAllInterests();
    }
}
