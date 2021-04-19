select * from raza;
select count(*) from caracteristica;
select * from perfil;
select * from perfil_has_caracteristica;

select p.id as id,
       p.nombre as nombre,
       r.nombre as raza,
       p.genero as genero,
       p.edad edad,
       c.nombre as caracteristicas,
       p.frase as frase,
       p.url_imagen as url_imagen
from perfil_has_caracteristica phc
    join
    caracteristica c on phc.caracteristica_id = c.id
    join
    perfil p on phc.perfil_id = p.id
    join
    raza r on p.raza_id = r.id;
    
select * from PERFIL_HAS_CARACTERISTICA where caracteristica_id = any (2);

create table test (id number primary key, name varchar2(30));

create sequence test_sequence start with 1 increment by 1;

create or replace trigger test_trigger
before insert
on test
referencing new as new
for each row
begin
select test_sequence.nextval into :new.id from dual;
end;
/

insert into test (name) values ('ariel');
select * from test;
