SPOOL C:\Users\luisj\Documents\Github\ESCOM\ddb\sql_by_example\c8\salida.txt
rem RISCHERT, A (2004).Oracle® SQL by Example,Upper Saddle River,NJ,USA:Perarson.

set pagesize 99
set linesize 200
set colsep '|=|'
set underline =
set null s/Datos
set feedback on

rem cap 8
rem 425
SELECT first_name, last_name, phone, COUNT(*)
 FROM student
 GROUP BY first_name, last_name, phone
HAVING COUNT(*) > 1 ;

rem 424
SELECT first_name, last_name, phone
 FROM instructor
 UNION
SELECT first_name, last_name, phone
 FROM student ;

rem 434
SELECT instructor_id
 FROM instructor
 MINUS
SELECT instructor_id
 FROM section ;

rem 435
SELECT DISTINCT instructor_id
 FROM section ;

rem 437
SELECT created_by
 FROM enrollment
INTERSECT
SELECT created_by
 FROM course ;