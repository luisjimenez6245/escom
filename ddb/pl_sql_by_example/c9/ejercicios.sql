SPOOL C:\Users\luisj\Documents\GitHub\escom\ddb\pl_sql_by_example\c9\salida.txt
rem ROSENZWEIG, B & SILVESTROVA, E. (2009). Oracle® PL/SQL™ by Example,USA:Perarson.



rem [ROSENZWEIG & RAKHIMOV,2009,166]

rem 9 
rem 190
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

rem 198
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