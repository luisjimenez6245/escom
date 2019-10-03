Select * from profesor;

Select idp, nombreProfesor, fechaNacimiento, Edad from profesor;

SELECT * from clase where Piso  = 1;

SELECT Lower(nombreProfesor)  from Profesor where Year(fechaNacimiento) = 1984;

SELECT oficina from profesor where nombreProfesor = "Josimar";

SELECT idP from asistencia where idC = "C1";


Select Upper(p.idP), Upper(p.nombreProfesor) from asistencia as a, profesor as p where idC = "C1" and p.idP = a.idP;

SELECT piso, bloque from clase, asistencia where clase.idC = asistencia.idC and asistencia.idP= "P1";

SELECT nombreProfesor, Edad from Profesor, asistencia where profesor.idp = asistencia.idp and asistencia.idC= "C1";

SELECT idP from asistencia, asignatura WHERE asignatura.idA =  asistencia.idA and asignatura.NombreAsignatura = "Ciencias Sociales" and asistencia.idC = "C1";

SELECT profesor.idP, nombreProfesor, fechaNacimiento from profesor, asistencia, asignatura WHERE  profesor.idP = asistencia.idP and asignatura.idA =  asistencia.idA and asignatura.NombreAsignatura = "Ciencias Sociales" and asistencia.idC = "C1";