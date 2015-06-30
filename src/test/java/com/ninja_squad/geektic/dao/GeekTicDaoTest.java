package com.ninja_squad.geektic.dao;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.Operations;
import com.ninja_squad.dbsetup.operation.Operation;
import com.ninja_squad.geektic.model.Geek;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/**
 * Created by Anthony on 29/06/15.
 * Project : geektic2014
 */

public class GeekTicDaoTest extends BaseDaoTest {

    // You can autowire the DAO to test here. For example:
    @Autowired
    private GeekTicDao dao;

    @Before
    public void populateDatabase() {
        Operation operation = Operations.sequenceOf(
                CommonOperations.DELETE_ALL,
                CommonOperations.INSERT_REFERENCE_DATA
        );
        DbSetup dbSetup = new DbSetup(destination, operation);
        dbSetup.launch();
    }

    @Test
    public void testFindById() {
        int expected = 1;
        int response = dao.findById(expected).getId();
        assertEquals(expected, response);
    }

    @Test
    public void testFindAllGeeks() {
        int expected = 3;
        int response = dao.findAllGeeks().size();
        assertEquals(expected, response);
        String expectedLastEmail = "dupond.bernadette@tintin.fr";
        String responseLastEmail = dao.findAllGeeks().get(1).getMail();
        assertEquals(expectedLastEmail, responseLastEmail);
    }

    @Test
    public void testGetAllInterests() {
        int expected = 3;
        int response = dao.getAllInterests().size();
        assertEquals(expected, response);
        String expectedLastInterest = "Angular";
        String responseLastInterest = dao.getAllInterests().get(2).getLibelle();
        assertEquals(expectedLastInterest, responseLastInterest);
    }

    @Test
    public void testFindBySex() {
        List<Integer> expected = Arrays.asList(2);

        List<Integer> response = dao.findByCriteria("F").stream().map(Geek::getId).collect(Collectors.toList());
        Collections.sort(response);

        assertEquals(expected, response);
    }

    @Test
    public void testFindBySexAndInterests() {
        List<Integer> expected = Arrays.asList(1, 3);
        List<Integer> given = Arrays.asList(1, 2);

        List<Integer> response = dao.findByCriteria("H", given).stream().map(Geek::getId).collect(Collectors.toList());
        Collections.sort(response);

        assertEquals(expected, response);
    }
}
