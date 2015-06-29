package com.ninja_squad.geektic.dao;

import com.ninja_squad.dbsetup.Operations;
import com.ninja_squad.dbsetup.operation.Insert;
import com.ninja_squad.dbsetup.operation.Operation;

import static com.ninja_squad.dbsetup.Operations.deleteAllFrom;
import static com.ninja_squad.dbsetup.Operations.insertInto;
import static com.ninja_squad.dbsetup.operation.CompositeOperation.sequenceOf;

/**
 * Created by Anthony on 29/06/15.
 * Project : geektic2014
 */
public class CommonOperations {
    public static final Operation DELETE_ALL = deleteAllFrom("GEEK_INTERET", "GEEK", "INTERET");

    public static final Operation INSERT_REFERENCE_DATA =
            sequenceOf(
                    insertInto("GEEK")
                            .columns("ID", "nom", "prenom", "mail", "sexe", "description")
                            .values(1, "aubree", "anthony", "lp@anthonyaubree.com", "H", "description")
                            .values(2, "dupond", "bernadette", "dupond.bernadette@tintin.fr", "F", "description")
                            .build(),
                    insertInto("INTERET")
                            .columns("ID", "libelle")
                            .values(1, "PHP")
                            .values(2, "Java")
                            .values(3, "Angular")
                            .build(),
                    insertInto("GEEK_INTERET")
                            .columns("id_geek", "id_interet")
                            .values(1, 1)
                            .values(1, 2)
                            .values(2, 3)
                            .values(2, 1)
                            .build()
            );
}
