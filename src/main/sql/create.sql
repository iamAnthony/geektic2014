CREATE TABLE geek (
id INTEGER IDENTITY,
nom VARCHAR (35),
prenom VARCHAR (35),
mail VARCHAR(50),
sexe VARCHAR (1),
description VARCHAR (400)
);

CREATE TABLE interet (
id INTEGER IDENTITY,
libelle VARCHAR (40)
);

CREATE TABLE geek_interet (
  id_geek int,
  id_interet int,
  CONSTRAINT pk_geek_interet PRIMARY KEY (id_geek, id_interet)
);

ALTER TABLE geek_interet
  ADD CONSTRAINT fk_geek_interet_geek FOREIGN KEY (id_geek) REFERENCES geek(id);

ALTER TABLE geek_interet
  ADD CONSTRAINT fk_geek_interet_interet FOREIGN KEY (id_interet) REFERENCES interet(id);