SPOOL C:\Users\luisj\Documents\GitHub\escom\ddb\pl_sql_by_example\c20\salida.txt
rem ROSENZWEIG, B & SILVESTROVA, E. (2009). Oracle® PL/SQL™ by Example,USA:Perarson.



rem [ROSENZWEIG & RAKHIMOV,2009,166]
rem 20

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


spool off;