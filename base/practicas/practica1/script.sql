DROP database if exists Instituto;

CREATE database  Instituto;

use Instituto;

create table Profesor(
	IdP char(3) not null,
    NombreProfesor nvarchar(200),
    Oficina int
);

create table Asignatura(
	IdA char(3) not null,
    NombreAsignatura nvarchar(200)
);

create table Clase(
	IdC char(3) not null,
    Piso int, 
    bloque int
);

create table Asistencia(
	IdP char(3) not null, 
    IdA char(3) not null, 
    IdC char(3) not null
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
insert into Asistencia values ('P5', 'A5', 'C1');

alter table Asistencia add TempIdP char(3) null;

update Asistencia set TempIdP = 'P3' where IdP = 'P1' and IdA = 'A1' and IdC = 'C1';
update Asistencia set TempIdP = 'P3' where IdP = 'P1' and IdA = 'A2' and IdC = 'C3';
update Asistencia set TempIdP = 'P3' where IdP = 'P2' and IdA = 'A4' and IdC = 'C1';
update Asistencia set TempIdP = 'P5' where IdP = 'P3' and IdA = 'A3' and IdC = 'C3';
update Asistencia set TempIdP = 'P5' where IdP = 'P3' and IdA = 'A3' and IdC = 'C2';
update Asistencia set TempIdP = 'P1' where IdP = 'P4' and IdA = 'A2' and IdC = 'C1';
update Asistencia set TempIdP = 'P1' where IdP = 'P4' and IdA = 'A2' and IdC = 'C2';
update Asistencia set TempIdP = 'P1' where IdP = 'P3' and IdA = 'A3' and IdC = 'C1';
update Asistencia set TempIdP = 'P1' where IdP = 'P5' and IdA = 'A5' and IdC = 'C2';
update Asistencia set TempIdP = 'P5' where IdP = 'P5' and IdA = 'A5' and IdC = 'C1';

alter table Asistencia add constraint FKIdProfesor FOREIGN KEY (IdP) REFERENCES Profesor(IdP);

Delete From Asistencia where IdP = 'P2';
Delete from Profesor where IdP = 'P2';

alter table Asistencia drop FOREIGN KEY FKIdProfesor;

alter table Asistencia add constraint FKIdProfesor FOREIGN KEY (IdP) REFERENCES Profesor(IdP) on Delete cascade on update cascade;

update Profesor set idP ='P11' where idP = 'P4'; 

alter table Asistencia drop FOREIGN KEY FKIdProfesor;

alter table Asistencia add constraint FKIdProfesor FOREIGN KEY (TempIdP) REFERENCES Profesor(IdP) on Delete set null on update set null;

update Profesor set idP ='P8' where idP = 'P3'; 

alter table Asistencia drop FOREIGN KEY FKIdProfesor;
alter table Asistencia add constraint FKIdProfesor FOREIGN KEY (TempIdP) REFERENCES Profesor(IdP) on Delete no action on update no action;

update Profesor set idP ='P6' where idP = 'P1'; 

alter table Asistencia drop FOREIGN KEY FKIdProfesor;
alter table Asistencia add constraint FKIdProfesor FOREIGN KEY (TempIdP) REFERENCES Profesor(IdP) on Delete restrict on update restrict;

update Profesor set idP ='P7' where idP = 'P5'; 

alter table Asistencia drop FOREIGN KEY FKIdProfesor;

update Asistencia set IdP = 'P8' where IdP = 'P3';


alter table Asistencia add constraint FKIdProfesor FOREIGN KEY (IdP) REFERENCES Profesor(IdP) on Delete cascade on update cascade;
alter table Asistencia add constraint FKIdClase FOREIGN KEY (IdC) REFERENCES Clase(IdC) on Delete cascade on update cascade;
alter table Asistencia add constraint FKIdAsignatura FOREIGN KEY (IdA) REFERENCES Asignatura(IdA) on Delete cascade on update cascade;


