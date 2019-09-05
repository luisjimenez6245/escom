DROP database if exists Instituto;

CREATE database  Instituto;

use Instituto;

create table Profesor(
	IdP nvarchar(100) not null,
    NombreProfesor nvarchar(200),
    Oficina int
);

create table Asignatura(
	IdA nvarchar(100) not null,
    NombreAsignatura nvarchar(200)
);

create table Clase(
	IdC nvarchar(100) not null,
    Piso int, 
    bloque int
);

create table Asistencia(
	IdP nvarchar(100) not null, 
    IdA nvarchar(100) not null, 
    IdC nvarchar(100) not null
);

alter table Profesor add FechaNacimiento date;

alter table Profesor add constraint IdP Primary Key(IdP);
alter table Asignatura add constraint IdA Primary Key(IdA);
alter table Clase add constraint IdP Primary Key(IdC);
alter table Asistencia add constraint IdAsistencia Primary Key(IdP, IdA, IdC);


insert into Profesor  values ('P1', 'Pedro', 105, '1990/07/14'), ('P2', 'Victor', 103, '1987/09/28'), ('P3', 'Sandy',  103,'1985/12/11'), ('P4', 'Josimar', 207, '1990/04/09'), ('P5', 'Eduardo', 207, '1989/02/16');

insert into Asignatura values ('A1', 'Redes'), ('A2', 'Base de Datos'), ('A3', 'Mercadotecnía'), ('A4', 'Ciencias Sociales'), ('A5', 'Ing. SW');

insert into Clase values ('C1', 1, 1), ('C2', 1, 1), ('C3', 1, 1), ('C4', 2, 1);

insert into Asistencia values ('P1', 'A1', 'C1');
insert into Asistencia values ('P1', 'A2', 'C3');
insert into Asistencia values ('P2', 'A4', 'C1');
insert into Asistencia values ('P3', 'A3', 'C3');
insert into Asistencia values ('P3', 'A3', 'C2');
insert into Asistencia values ('P4', 'A2', 'C1');
insert into Asistencia values ('P4', 'A2', 'C2');
insert into Asistencia values ('P3', 'A3', 'C1');
insert into Asistencia values ('P5', 'A5', 'C2');
