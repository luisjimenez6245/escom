SPOOL D:\Sexto\DistributedDB\Tareas\SegundaEntrega\SPOOL_EntregarPLSQL.txt
rem ROSENZWEIG,B &  RAKHIMOV,E (2009).Oracle® PL/SQL™by Example,Boston,MA,USA:Perarson.
rem 19
rem 442

set linesize 150 
set pagesize 99
set colsep '||' 
set colsep '|=|'
set underline =
set null s/Dato

SET SERVEROUTPUT ON;

SELECT distinct s.course_no, c.description
FROM section s, enrollment e, course c
WHERE s.section_id = e.section_id
AND c.course_no = s.course_no
GROUP BY s.course_no, c.description,
e.section_id, s.section_id
HAVING COUNT(*) >=8;

SELECT course_no,description,cost from course;

CREATE OR REPLACE PROCEDURE Discount
AS
CURSOR c_group_discount
IS
SELECT distinct s.course_no, c.description
FROM section s, enrollment e, course c
WHERE s.section_id = e.section_id
AND c.course_no = s.course_no
GROUP BY s.course_no, c.description,
e.section_id, s.section_id
HAVING COUNT(*) >=8;
BEGIN
FOR r_group_discount IN c_group_discount
LOOP
UPDATE course
SET cost = cost * .95
WHERE course_no = r_group_discount.course_no;
DBMS_OUTPUT.PUT_LINE
('A 5% discount has been given to '||
r_group_discount.course_no||' '||
r_group_discount.description
);
END LOOP;
END;
/

execute Discount;
rem 446
SELECT distinct s.course_no, c.description, c.cost
FROM section s, enrollment e, course c
WHERE s.section_id = e.section_id
AND c.course_no = s.course_no
GROUP BY s.course_no, c.description,
e.section_id, s.section_id,c.cost
HAVING COUNT(*) >=8;

-- ch19_02a.sql
CREATE OR REPLACE PROCEDURE find_sname
(i_student_id IN NUMBER,
	first OUT VARCHAR2,
	last OUT VARCHAR2
)
AS
BEGIN
SELECT first_name, last_name
INTO first, last
FROM student
WHERE student_id = i_student_id;
EXCEPTION
WHEN OTHERS
THEN
DBMS_OUTPUT.PUT_LINE('Error in finding student_id:
'||i_student_id);
END find_sname;
/

DECLARE
v_local_first_name student.first_name%TYPE;
v_local_last_name student.last_name%TYPE;
BEGIN
find_sname
(145, v_local_first_name, v_local_last_name);
DBMS_OUTPUT.PUT_LINE
('Student 145 is: '||v_local_first_name||
' '|| v_local_last_name||'.'
);
END;
/
rem usar 168

rem 20
rem 451
CREATE OR REPLACE FUNCTION show_description
(i_course_no course.course_no%TYPE)
RETURN varchar2
AS
v_description varchar2(50);
BEGIN
SELECT description
INTO v_description
FROM course
WHERE course_no = i_course_no;
RETURN v_description;
EXCEPTION
WHEN NO_DATA_FOUND
THEN
RETURN(‘The Course is not in the database');
WHEN OTHERS
THEN
RETURN(‘Error in running show_description');
END;
/
rem 452
SET SERVEROUTPUT ON
DECLARE
v_description VARCHAR2(50);
BEGIN
v_description := show_description(&sv_cnumber);
DBMS_OUTPUT.PUT_LINE(v_description);
END;
/
rem usar 420,430
rem 452
CREATE OR REPLACE FUNCTION id_is_good
(i_student_id IN NUMBER)
RETURN BOOLEAN
AS
v_id_cnt NUMBER;
BEGIN
SELECT COUNT(*)
INTO v_id_cnt
FROM student
WHERE student_id = i_student_id;
RETURN 1 = v_id_cnt;
EXCEPTION
WHEN OTHERS
THEN
RETURN FALSE;
END id_is_good;
/
rem 452
DECLARE
v_id number;
BEGIN
v_id := &id;
IF id_is_good(v_id)
THEN
DBMS_OUTPUT.PUT_LINE
('Student ID: '||v_id||' is a valid.');
ELSE
DBMS_OUTPUT.PUT_LINE
('Student ID: '||v_id||' is not valid.');
END IF;
END;
/

rem cap 21
rem paquete manage_students
CREATE OR REPLACE PACKAGE manage_students
AS
PROCEDURE find_sname
(i_student_id IN student.student_id%TYPE,
o_first_name OUT student.first_name%TYPE,
o_last_name OUT student.last_name%TYPE
);
FUNCTION id_is_good
(i_student_id IN student.student_id%TYPE)
 RETURN BOOLEAN;
END manage_students;
/

rem sale error
rem The procedure cannot run because the specification for the procedure exists only in
rem the database, not the body
SET SERVEROUTPUT ON
DECLARE
v_first_name student.first_name%TYPE;
v_last_name student.last_name%TYPE;
BEGIN
manage_students.find_sname
(125, v_first_name, v_last_name);
DBMS_OUTPUT.PUT_LINE(v_first_name||' '||v_last_name);
END;
/
rem 361
rem paquete school_api
CREATE OR REPLACE PACKAGE school_api as
PROCEDURE discount;
FUNCTION new_instructor_id
RETURN instructor.instructor_id%TYPE;
END school_api;
/

rem 362
rem cuerpo de paquete manage_students
CREATE OR REPLACE PACKAGE BODY manage_students
 AS
 PROCEDURE find_sname
 (i_student_id IN student.student_id%TYPE,
 o_first_name OUT student.first_name%TYPE,
 o_last_name OUT student.last_name%TYPE
 )
 IS
 v_student_id student.student_id%TYPE;
 BEGIN
 SELECT first_name, last_name
 INTO o_first_name, o_last_name
 FROM student
 WHERE student_id = i_student_id;
 EXCEPTION
 WHEN OTHERS
 THEN
 DBMS_OUTPUT.PUT_LINE
 ('Error in finding student_id: '||v_student_id);
 END find_sname;
 FUNCTION id_is_good
 (i_student_id IN student.student_id%TYPE)
 RETURN BOOLEAN
 IS
 v_id_cnt number;
 BEGIN
 SELECT COUNT(*)
 INTO v_id_cnt
 FROM student
 WHERE student_id = i_student_id;
RETURN 1 = v_id_cnt;
 EXCEPTION
 WHEN OTHERS
 THEN
 RETURN FALSE;
 END id_is_good;
 END manage_students;
/

rem 363
rem cuerpo de paquete 
CREATE OR REPLACE PACKAGE BODY school_api AS
 PROCEDURE discount
 IS
 CURSOR c_group_discount
 IS
 SELECT distinct s.course_no, c.description
 FROM section s, enrollment e, course c
 WHERE s.section_id = e.section_id
 GROUP BY s.course_no, c.description,
 e.section_id, s.section_id
 HAVING COUNT(*) >=8;
 BEGIN
 FOR r_group_discount IN c_group_discount
 LOOP
 UPDATE course
 SET cost = cost * .95
 WHERE course_no = r_group_discount.course_no;
 DBMS_OUTPUT.PUT_LINE
 ('A 5% discount has been given to'
||r_group_discount.course_no||'
 '||r_group_discount.description);
 END LOOP;
 END discount;
 FUNCTION new_instructor_id
 	RETURN instructor.instructor_id%TYPE
 IS
 v_new_instid instructor.instructor_id%TYPE;
 BEGIN
 SELECT INSTRUCTOR_ID_SEQ.NEXTVAL
 INTO v_new_instid
 FROM dual;
 RETURN v_new_instid;
 EXCEPTION
 WHEN OTHERS THEN
 DECLARE
 v_sqlerrm VARCHAR2(250) := SUBSTR(SQLERRM,1,250);
 BEGIN 
	RAISE_APPLICATION_ERROR(-20003,'Error in instructor_id: '||v_sqlerrm);
 END;
 END new_instructor_id;
 END school_api;
/
rem 364 pag
rem para usar lo creado anteriormente manage_students
SET SERVEROUTPUT ON
DECLARE
v_first_name student.first_name%TYPE;
v_last_name student.last_name%TYPE;
BEGIN
IF manage_students.id_is_good(&&v_id)
THEN
manage_students.find_sname(&&v_id, v_first_name,
v_last_name);
DBMS_OUTPUT.PUT_LINE('Student No. '||&&v_id||' is '
||v_last_name||', '||v_first_name);
ELSE
DBMS_OUTPUT.PUT_LINE
('Student ID: '||&&v_id||' is not in the database.');
END IF;
END;
/

rem para probar school_api
SET SERVEROUTPUT ON
DECLARE
V_instructor_id instructor.instructor_id%TYPE;
BEGIN
School_api.discount;
v_instructor_id := school_api.new_instructor_id;
DBMS_OUTPUT.PUT_LINE
('The new id is: '||v_instructor_id);
END;
/
spool off