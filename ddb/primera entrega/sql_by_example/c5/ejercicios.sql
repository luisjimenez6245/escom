SPOOL C:\Users\luisj\Documents\Github\ESCOM\ddb\sql_by_example\c5\salida.txt
rem RISCHERT, A (2004).Oracle® SQL by Example,Upper Saddle River,NJ,USA:Perarson.


set pagesize 99
set linesize 200
set colsep '|=|'
set underline =
set null s/Datos
set feedback on



SELECT COUNT(*) 
 FROM course 
 WHERE prerequisite IS NULL ;


SELECT COUNT(DISTINCT student_id) 
 FROM enrollment;


SELECT AVG(NVL(cost, 0)) 
 FROM course;


SELECT MAX(enroll_date) 
 FROM enrollment ;


col location format A7;
col sum format $9,900.99;
col total format 999,999;

SELECT location , COUNT(*) * 100 as total, SUM(capacity) AS sum, 
 MIN(capacity) AS min, MAX(capacity) AS max 
 FROM section 
 GROUP BY location;


SELECT location "Location", instructor_id, 
 COUNT(location) "Total Locations", 
 SUM(capacity) "Total Capacity" 
 FROM section 
 GROUP BY location, instructor_id 
HAVING SUM(capacity) > 65 
ORDER BY "Total Capacity" DESC;


SELECT location "Location",
     SUM(capacity) "Total Capacity"
     FROM section
     WHERE section_no = 3
     GROUP BY location
    HAVING (COUNT(location) > 3
    AND location LIKE 'L5%')
;


SELECT location "Location",
     SUM(capacity) "Total Capacity"
     FROM section
     WHERE section_no in (1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
     GROUP BY location
    HAVING (COUNT(location) > 3
    AND location LIKE 'L5%')
;

SELECT location "Location", instructor_id, 
 COUNT(location) "Total Locations", 
 SUM(capacity) "Total Capacity" 
 FROM section 
 WHERE section_no IN (2, 3) 
 GROUP BY location, instructor_id 
HAVING SUM(capacity) > 50;


SELECT location "Location", instructor_id, 
 COUNT(location) "Total Locations", 
 SUM(capacity) "Total Capacity" 
 FROM section 
 WHERE section_no IN (2, 3, 4, 5, 6, 7, 8) 
 GROUP BY location, instructor_id 
HAVING SUM(capacity) > 50;


SELECT location "Location", instructor_id, 
 COUNT(location) "Total Locations", 
 SUM(capacity) "Total Capacity" 
 FROM section 
 WHERE section_no IN (2, 3, 4, 5, 6, 7, 8) 
 GROUP BY location, instructor_id 
;

SELECT location "Location", instructor_id, 
 COUNT(location) "Total Locations", 
 SUM(capacity) "Total Capacity" 
 FROM section 
 WHERE section_no IN (2, 3, 4, 5, 6, 7, 8) 
 GROUP BY location, instructor_id 
HAVING SUM(capacity) > 25;



SELECT location "Location", instructor_id, 
 COUNT(location) "Total Locations", 
 SUM(capacity) "Total Capacity" 
 FROM section 
 GROUP BY location, instructor_id 
HAVING SUM(capacity) > 50 
ORDER BY "Total Capacity" DESC ;



SELECT student_id, COUNT(*) 
 FROM enrollment 
 GROUP BY student_id 
HAVING COUNT(*) > 2 ;


SELECT course_no "Course #", 
 AVG(capacity) "Avg. Capacity", 
 ROUND(AVG(capacity)) "Rounded Avg. Capacity" 
 FROM section 
 GROUP BY course_no;



SELECT course_no "Course #", 
 AVG(capacity) "Avg. Capacity", 
 ROUND(AVG(capacity)) "Rounded Avg. Capacity" 
 FROM section 
 GROUP BY course_no 
HAVING COUNT(*) = 2 ;

SPOOL OFF