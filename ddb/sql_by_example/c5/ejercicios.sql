SPOOL C:\Users\luis\Documents\Github\ESCOM\ddb\sql_by_example\c5\salida.txt
rem RISCHERT, A (2004).Oracle® SQL by Example,Upper Saddle River,NJ,USA:Perarson.


SELECT COUNT(*) 
 FROM course 
 WHERE prerequisite IS NULL ;


SELECT COUNT(DISTINCT student_id) 
 FROM enrollment;


SELECT AVG(NVL(cost, 0)) 
 FROM course;


SELECT MAX(enroll_date) 
 FROM enrollment ;




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