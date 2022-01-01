CREATE TABLE raza (
    id      INTEGER NOT NULL,
    nombre  VARCHAR(30) NOT NULL
);

ALTER TABLE raza ADD CONSTRAINT raza_pk PRIMARY KEY ( id );


CREATE TABLE caracteristica (
    id      INTEGER NOT NULL,
    nombre  VARCHAR(30) NOT NULL
);

ALTER TABLE caracteristica ADD CONSTRAINT caracteristica_pk PRIMARY KEY ( id );


CREATE TABLE perfil (
    id          INTEGER NOT NULL,
    nombre      VARCHAR(30) NOT NULL,
    genero      VARCHAR(15) NOT NULL,
    edad        INTEGER NOT NULL,
    frase       VARCHAR(100) NOT NULL,
    url_imagen  VARCHAR(200) NOT NULL,
    raza_id     INTEGER NOT NULL
);

ALTER TABLE perfil ADD CONSTRAINT perfil_pk PRIMARY KEY ( id );

ALTER TABLE perfil
      ADD CONSTRAINT perfil_raza_fk FOREIGN KEY ( raza_id )
      REFERENCES raza ( id );


CREATE TABLE perfil_has_caracteristica (
    perfil_id          INTEGER NOT NULL,
    caracteristica_id  INTEGER NOT NULL
);

ALTER TABLE perfil_has_caracteristica
      ADD CONSTRAINT perfil_has_caracteristica_pk PRIMARY KEY ( perfil_id, caracteristica_id );
      
ALTER TABLE perfil_has_caracteristica
      ADD CONSTRAINT perfil_has_cca_perfil_fk FOREIGN KEY ( perfil_id )
      REFERENCES perfil ( id );

ALTER TABLE perfil_has_caracteristica
      ADD CONSTRAINT perfil_has_cca_cca_fk FOREIGN KEY ( caracteristica_id )
      REFERENCES caracteristica ( id );
