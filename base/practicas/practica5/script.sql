DROP database if exists Gustar;

CREATE database  Gustar;

use Gustar;


CREATE TABLE HOMBRE
(
    NOMH CHAR(15) not null,
    EDAD INT(2) not null
);

CREATE TABLE MUJER
(
    NOMM CHAR(15) not null,
    EDAD INT(2) not null
);


CREATE TABLE HSIM
(
    NOMH CHAR(15) not null,
    NOMM CHAR(15) not null
);


CREATE TABLE MSIM
(
    NOMH CHAR(15) not null,
    NOMM CHAR(15) not null
);


CREATE TABLE MATRIM
(
    NOMH CHAR(15) not null,
    NOMM CHAR(15) not null
);

alter table HOMBRE add constraint NOMH Primary Key(NOMH);

alter table MUJER add constraint NOMM Primary Key(NOMM);

alter table HSIM add constraint IDHSIM Primary Key(NOMH, NOMM);

alter table MSIM add constraint IDMSIM Primary Key(NOMH, NOMM);

alter table MATRIM add constraint IDMATRIM Primary Key(NOMH, NOMM);

alter table HSIM add constraint FKHSIMH FOREIGN KEY (NOMH) REFERENCES HOMBRE(NOMH) on Delete cascade on update cascade;
alter table HSIM add constraint FKHSIMM FOREIGN KEY (NOMM) REFERENCES MUJER(NOMM) on Delete cascade on update cascade;

alter table MSIM add constraint FKMSIMM FOREIGN KEY (NOMM) REFERENCES MUJER(NOMM) on Delete cascade on update cascade;
alter table MSIM add constraint FKMSIMH FOREIGN KEY (NOMH) REFERENCES HOMBRE(NOMH) on Delete cascade on update cascade;

alter table MATRIM add constraint FKMATRIMM FOREIGN KEY (NOMM) REFERENCES MUJER(NOMM) on Delete cascade on update cascade;
alter table MATRIM add constraint FKMATRIMH FOREIGN KEY (NOMH) REFERENCES HOMBRE(NOMH) on Delete cascade on update cascade;


INSERT INTO HOMBRE
VALUES
    ('ALBERTO', 26),
    ('ARTURO', 31),
    ('ROLANDO', 30),
    ('CARLOS', 28),
    ('EDUARDO', 27),
    ('LUIS', 19),
    ('PEDRO', 25),
    ('MARIO', 33),
    ('ENRIQUE', 29),
    ('HECTOR', 33),
    ('MIGUEL', 31);

INSERT INTO MUJER
VALUES
    ('ALMA', 19),
    ('LETICIA', 33),
    ('LAURA', 30),
    ('WENDY', 25),
    ('ADRIANA', 27),
    ('KARLA', 24),
    ('DANIELA', 25),
    ('LILIANA', 32),
    ('SANDY', 31);

INSERT INTO HSIM
VALUES
    ('ALBERTO', 'LETICIA'),
    ('ARTURO', 'LAURA'),
    ('CARLOS', 'KARLA'),
    ('ALBERTO', 'DANIELA'),
    ('LUIS', 'LILIANA'),
    ('PEDRO', 'WENDY'),
    ('MARIO', 'LILIANA'),
    ('ALBERTO', 'ADRIANA'),
    ('ARTURO', 'ADRIANA'),
    ('ROLANDO', 'ADRIANA'),
    ('CARLOS', 'ADRIANA'),
    ('EDUARDO', 'ADRIANA'),
    ('LUIS', 'ADRIANA'),
    ('PEDRO', 'ADRIANA'),
    ('MARIO', 'ADRIANA'),
    ('MIGUEL', 'ADRIANA'),
    ('MIGUEL', 'SANDY');

INSERT INTO MSIM
VALUES
    ('ALBERTO', 'ALMA'),
    ('ALBERTO', 'LETICIA'),
    ('ARTURO', 'LAURA'),
    ('PEDRO', 'WENDY'),
    ('ALBERTO', 'ADRIANA'),
    ('ROLANDO', 'KARLA'),
    ('ALBERTO', 'DANIELA'),
    ('PEDRO', 'LILIANA'),
    ('MARIO', 'LAURA'),
    ('MARIO', 'LILIANA'),
    ('MARIO', 'KARLA'),
    ('MARIO', 'ALMA'),
    ('MARIO', 'WENDY'),
    ('MARIO', 'SANDY'),
    ('MIGUEL', 'SANDY');


INSERT INTO MATRIM
VALUES
    ('ARTURO', 'LAURA'),
    ('CARLOS', 'LILIANA'),
    ('EDUARDO', 'KARLA'),
    ('LUIS', 'ALMA'),
    ('PEDRO', 'WENDY'),
    ('MIGUEL', 'SANDY');






Select nomm
from mujer
where nomm not in (Select nomm
from MATRIM);
SELECT hsim.nomh, hsim.nomm
from hsim, msim
where hsim.nomh =msim.nomh and hsim.nomm =msim.nomm;

SELECT hsim.nomh, hsim.nomm
from hsim, hombre, mujer, msim
where hsim.nomh =msim.nomh
    and hsim.nomm =msim.nomm and hombre.nomh =msim.nomh and mujer.nomm=msim.nomm and mujer.edad > 30 and hombre.edad >30;

-- chale
SELECT msim.nomm
from hsim, msim, matrim
where hsim.nomh =msim.nomh and hsim.nomm =msim.nomm  and matrim.nomm = msim.nomm and matrim.nomh = hsim.nomh;
--chale


select nomm from matrim where nomm not in (select msim.nomm
from msim , matrim
where msim.nomm =matrim.nomm  and msim.nomh =matrim.nomh) ; 

select nomm from matrim where nomm not in (select nomm from hsim);

select nomm from matrim where nomm in (select nomm from hsim);

SELECT nomm from mujer WHERE nomm not in ( SELECT nomm from matrim);

SELECT hsim.nomh, hsim.nomm
from hsim, msim
where hsim.nomh =msim.nomh and hsim.nomm =msim.nomm;

SELECT hsim.nomh, hsim.nomm
from hsim, hombre, mujer, msim
where hsim.nomh =msim.nomh
    and hsim.nomm =msim.nomm and hombre.nomh =msim.nomh and mujer.nomm=msim.nomm and mujer.edad > 30 and hombre.edad >30;

select nomm from matrim where nomm not in (select matrim.nomm from matrim, msim where matrim.nomm = msim.nomm and matrim.nomh = msim.nomh);


SELECT nomh from  hsim where hsim.nomm in (SELECT nomm from msim);


SELECT nomh from matrim where nomh in (select matrim.nomh from matrim, msim where matrim.nomm = msim.nomm and matrim.nomh = msim.nomh) and nomh not in (SELECT nomh )

SELECT nomh from msim where nomm in (select nomm from matrim);


SELECT nomm from msim where nomm in (select nomm from matrim);

