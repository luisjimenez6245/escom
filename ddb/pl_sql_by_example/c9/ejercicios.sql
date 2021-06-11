SPOOL C:\Users\luisj\Documents\GitHub\escom\ddb\pl_sql_by_example\c9\salida.txt
rem ROSENZWEIG, B & SILVESTROVA, E. (2009). Oracle® PL/SQL™ by Example,USA:Perarson.



rem [ROSENZWEIG,2009,190]
DECLARE
v_student_id student.student_id%type := &sv_student_id;
v_total_courses NUMBER;
e_invalid_id EXCEPTION;
BEGIN
IF v_student_id < 0 THEN
RAISE e_invalid_id;
ELSE
SELECT COUNT(*)
INTO v_total_courses
FROM enrollment
WHERE student_id = v_student_id;
DBMS_OUTPUT.PUT_LINE ('The student is registered for '||
v_total_courses||' courses');
END IF;
DBMS_OUTPUT.PUT_LINE ('No exception has been raised');
EXCEPTION
WHEN e_invalid_id THEN
DBMS_OUTPUT.PUT_LINE ('An id cannot be negative');
END;
/



rem [ROSENZWEIG,2009,195]
-- ch9_2c.sql, version 3.0
DECLARE
v_instructor_id NUMBER := &sv_instructor_id;
v_tot_sections NUMBER;
v_name VARCHAR2(30);
e_too_many_sections EXCEPTION;
BEGIN
SELECT COUNT(*)
INTO v_tot_sections
FROM section
WHERE instructor_id = v_instructor_id;
SELECT RTRIM(first_name)||' '||RTRIM(last_name)
INTO v_name
FROM instructor
WHERE instructor_id = v_instructor_id;
DBMS_OUTPUT.PUT_LINE ('Instructor, '||v_name||', teaches '||
v_tot_sections||' sections');
IF v_tot_sections >= 10 THEN
RAISE e_too_many_sections;
END IF;
EXCEPTION
WHEN e_too_many_sections THEN
DBMS_OUTPUT.PUT_LINE ('Instructor, '||v_name||
', teaches too much');
END;
/

rem [ROSENZWEIG,2009,198]
--outer block
BEGIN
-- inner block
DECLARE
v_test_var CHAR(3):= 'ABCDE';
BEGIN
DBMS_OUTPUT.PUT_LINE ('This is a test');
EXCEPTION
WHEN INVALID_NUMBER OR VALUE_ERROR THEN
DBMS_OUTPUT.PUT_LINE ('An error has occurred in '||
'the inner block');
END;
EXCEPTION
WHEN INVALID_NUMBER OR VALUE_ERROR THEN
DBMS_OUTPUT.PUT_LINE ('An error has occurred in the '||
'program');
END;
/

rem [ROSENZWEIG,2009,207]
DECLARE
v_course_no NUMBER := 430;
v_total NUMBER;
e_no_sections EXCEPTION;
BEGIN
BEGIN
SELECT COUNT(*)
INTO v_total
FROM section
WHERE course_no = v_course_no;
IF v_total = 0 THEN
RAISE e_no_sections;
ELSE
DBMS_OUTPUT.PUT_LINE ('Course, '||v_course_no||
' has '||v_total||' sections');
END IF;
EXCEPTION
WHEN e_no_sections THEN
RAISE;
END;
DBMS_OUTPUT.PUT_LINE ('Done...');
EXCEPTION
WHEN e_no_sections THEN
DBMS_OUTPUT.PUT_LINE ('There are no sections for course '||
v_course_no);
END;
/


SPOOL OFF;