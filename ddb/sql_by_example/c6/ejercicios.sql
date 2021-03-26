SPOOL C:\Users\luisj\Documents\Github\ESCOM\ddb\sql_by_example\c6\salida.txt
rem RISCHERT, A (2004).Oracle® SQL by Example,Upper Saddle River,NJ,USA:Perarson.

set pagesize 99
set linesize 200
set colsep '|=|'
set underline =
set null s/Datos
set feedback on


SELECT course.course_no, section_no, description, 
 location, instructor_id 
 FROM course, section 
 WHERE course.course_no = section.course_no ;


SELECT c.course_no, c.description, s.section_no 
 FROM course c, section s 
 WHERE c.course_no = s.course_no 
 AND c.prerequisite IS NULL 
 ORDER BY c.course_no, s.section_no;


SELECT s.last_name, s.zip, z.state, z.city 
 FROM student s, zipcode z 
 WHERE s.zip = z.zip 
 ORDER BY s.zip ;


SELECT s.first_name, s.last_name, s.student_id 
 FROM student s, enrollment e 
 WHERE s.student_id = e.student_id 
 ORDER BY s.last_name ;



SELECT DISTINCT s.first_name, s.last_name, s.student_id 
 FROM student s, enrollment e 
 WHERE s.student_id = e.student_id 
 ORDER BY s.last_name;


SELECT s.first_name, s.last_name, s.student_id 
 FROM student s JOIN enrollment e 
 ON (s.student_id = e.student_id) 
 ORDER BY s.last_name ;



SELECT e.student_id, s.course_no, 
 TO_CHAR(e.enroll_date,'MM/DD/YYYY HH:MI PM'), 
 e.section_id 
 FROM enrollment e JOIN section s 
 ON (e.section_id = s.section_id) 
 WHERE s.course_no = 20 
 AND e.enroll_date >= TO_DATE('01/30/2003','MM/DD/YYYY') 
 AND e.enroll_date < TO_DATE('01/31/2003','MM/DD/YYYY') ;



SELECT e.student_id, s.course_no, 
 TO_CHAR(e.enroll_date,'MM/DD/YYYY HH:MI PM'), 
 e.section_id 
 FROM enrollment e, section s 
 WHERE e.section_id = s.section_id 
 AND s.course_no = 20 
 AND e.enroll_date >= TO_DATE('01/30/2003','MM/DD/YYYY') 
 AND e.enroll_date < TO_DATE('01/31/2003','MM/DD/YYYY') ;

 SELECT c.course_no, s.section_no, c.description, s.location, 
 s.instructor_id, i.last_name, i.first_name
 FROM course c JOIN section s 
 ON (c.course_no = s.course_no) 
 JOIN instructor i
 ON (s.instructor_id = i.instructor_id);



 SELECT student_id, section_id, 
 grade_type_code type, 
 grade_code_occurrence no, 
 numeric_grade indiv_gr, 
 TO_CHAR(enroll_date, 'MM/DD/YY') enrolldt 
 FROM grade JOIN enrollment 
 USING (student_id, section_id) 
 WHERE student_id = 220 
 AND section_id = 119 ;

 SELECT c.course_no, s.section_no, e.student_id 
 FROM course c, section s, instructor i, enrollment e 
 WHERE c.prerequisite IS NULL 
 AND c.course_no = s.course_no 
 AND s.instructor_id = i.instructor_id 
 AND i.zip = '10025' 
 AND s.section_id = e.section_id ;

 
SPOOL OFF