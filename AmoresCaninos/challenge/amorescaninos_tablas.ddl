-- Generado por Oracle SQL Developer Data Modeler 20.2.0.167.1538
--   en:        2020-11-18 00:10:37 CLST
--   sitio:      Oracle Database 11g
--   tipo:      Oracle Database 11g



-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE caracteristica (
    id      INTEGER NOT NULL,
    nombre  VARCHAR2(30) NOT NULL
);

ALTER TABLE caracteristica ADD CONSTRAINT caracteristica_pk PRIMARY KEY ( id );

CREATE TABLE perfil (
    id          INTEGER NOT NULL,
    nombre      VARCHAR2(30) NOT NULL,
    genero      VARCHAR2(15) NOT NULL,
    edad        INTEGER NOT NULL,
    frase       VARCHAR2(100) NOT NULL,
    url_imagen  VARCHAR2(200) NOT NULL,
    raza_id     INTEGER NOT NULL
);

ALTER TABLE perfil ADD CONSTRAINT perfil_pk PRIMARY KEY ( id );

CREATE TABLE perfil_has_caracteristica (
    perfil_id          INTEGER NOT NULL,
    caracteristica_id  INTEGER NOT NULL
);

ALTER TABLE perfil_has_caracteristica ADD CONSTRAINT perfil_has_caracteristica_pk PRIMARY KEY ( perfil_id,
                                                                                                caracteristica_id );

CREATE TABLE raza (
    id      INTEGER NOT NULL,
    nombre  VARCHAR2(30) NOT NULL
);

ALTER TABLE raza ADD CONSTRAINT raza_pk PRIMARY KEY ( id );

ALTER TABLE perfil_has_caracteristica
    ADD CONSTRAINT perfil_has_cca_cca_fk FOREIGN KEY ( caracteristica_id )
        REFERENCES caracteristica ( id );

ALTER TABLE perfil_has_caracteristica
    ADD CONSTRAINT perfil_has_cca_perfil_fk FOREIGN KEY ( perfil_id )
        REFERENCES perfil ( id );

ALTER TABLE perfil
    ADD CONSTRAINT perfil_raza_fk FOREIGN KEY ( raza_id )
        REFERENCES raza ( id );



-- Informe de Resumen de Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                             4
-- CREATE INDEX                             0
-- ALTER TABLE                              7
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
