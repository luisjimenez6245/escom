SPOOL C:\Users\luisj\Documents\Github\ESCOM\ddb\sql_by_example\c7\salida.txt
rem RISCHERT, A (2004).Oracle® SQL by Example,Upper Saddle River,NJ,USA:Perarson.

set pagesize 99
set linesize 200
set colsep '|=|'
set underline =
set null s/Datos
set feedback on


rem [Rischert,A,2004,368]
SELECT course_no, description, cost
 FROM course
 WHERE cost =
 (SELECT MIN(cost)
 FROM course);


rem [Rischert,A,2004,369]
SELECT course_no, description, cost
 FROM course
 WHERE cost IN
 (SELECT cost
 FROM course
 WHERE prerequisite = 20) ;

rem [Rischert,A,2004,370]
rem The next query determines the last and first names of students enrolled in section number 8 ofcourse number 20.
SELECT last_name, first_name
 FROM student
 WHERE student_id IN
 (SELECT student_id
 FROM enrollment
 WHERE section_id IN
 (SELECT section_id
 FROM section
 WHERE section_no = 8
 AND course_no = 20)) ;

rem [RISCHERT,2004,371]
SELECT course_no, description
 FROM course
 WHERE course_no IN
 (SELECT course_no
 FROM section
 WHERE location = 'L211') ;

SELECT c.course_no, c.description
 FROM course c, section s
 WHERE c.course_no = s.course_no
 AND s.location = 'L211' ;

rem [RISCHERT,2004,372]
SELECT student_id, section_id, numeric_grade
 FROM grade
 WHERE grade_type_code = 'PJ'
 AND (section_id, numeric_grade) IN
 (SELECT section_id, MAX(numeric_grade)
 FROM grade
 WHERE grade_type_code = 'PJ'
 GROUP BY section_id) ;

rem [RISCHERT,2004,384]
SELECT student_id, section_id, numeric_grade
 FROM grade outer
 WHERE grade_type_code = 'PJ'
 AND numeric_grade =
 (SELECT MAX(numeric_grade)
 FROM grade
 WHERE grade_type_code = outer.grade_type_code
 AND section_id = outer.section_id) 

rem The following correlated subquery displays instructors where the INSTRUCTOR_ID has a matching
rem [RISCHERT,2004,386]
SELECT instructor_id, last_name, first_name, zip
 FROM instructor i
 WHERE EXISTS
 (SELECT 'X'
 FROM section
 WHERE i.instructor_id = instructor_id) ;


-- Inline Views And Scalar Subquery Expressions
rem [RISCHERT,2004,408]
SELECT a.course_no, total_capacity, total_students,
ROUND(100/total_capacity*total_students, 2)
"Filled Percentage"
FROM (SELECT COUNT(*) total_students, s.course_no
FROM enrollment e, section s
WHERE e.section_id = s.section_id
GROUP BY s.course_no) a,
(SELECT SUM(capacity) total_capacity, course_no
FROM section
GROUP BY course_no) b
WHERE b.course_no = a.course_no
ORDER BY "Filled Percentage" DESC;


rem [RISCHERT,2004,414]
SELECT section_id, numeric_grade
 FROM grade
 WHERE section_id = 84
 AND numeric_grade < ANY (80, 90) ;

SELECT section_id, numeric_grade
 FROM grade
 WHERE section_id = 84
 AND numeric_grade < ALL (80, 90) ;


spool off;