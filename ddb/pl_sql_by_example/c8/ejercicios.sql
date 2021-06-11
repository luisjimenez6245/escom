SPOOL C:\Users\luisj\Documents\GitHub\escom\ddb\pl_sql_by_example\c8\salida.txt
rem ROSENZWEIG, B & SILVESTROVA, E. (2009). Oracle® PL/SQL™ by Example,USA:Perarson.

rem [ROSENZWEIG & RAKHIMOV,2009,166]
-- ch02_3a.sql


SET SERVEROUTPUT ON
DECLARE
    v_num1 INTEGER := &sv_num1;
    v_num2 INTEGER := &sv_num2;
    v_result NUMBER;
BEGIN
    v_result := v_num1 / v_num2;
    DBMS_OUTPUT.PUT_LINE ('v_result: '||v_result);
    EXCEPTION
    WHEN ZERO_DIVIDE THEN
        DBMS_OUTPUT.PUT_LINE ('A number cannot be divided by zero.');
END;
/
DECLARE
    v_num1 INTEGER := &sv_num1;
    v_num2 INTEGER := &sv_num2;
    v_result NUMBER;
BEGIN
v_result := v_num1 / v_num2;
DBMS_OUTPUT.PUT_LINE ('v_result: '||v_result);
END;
/
rem 180
DECLARE
v_student_id NUMBER := &sv_student_id;
v_name VARCHAR2(30);
BEGIN
SELECT RTRIM(first_name)||' '||RTRIM(last_name)
INTO v_name
FROM student
WHERE student_id = v_student_id;
DBMS_OUTPUT.PUT_LINE ('Student name is '||v_name);
EXCEPTION
WHEN NO_DATA_FOUND THEN
DBMS_OUTPUT.PUT_LINE ('There is no such student');
END;
/
rem 171
DECLARE
v_student_id NUMBER := &sv_student_id;
v_enrolled VARCHAR2(3) := 'NO';
BEGIN
DBMS_OUTPUT.PUT_LINE ('Check if the student is enrolled');
SELECT 'YES'
INTO v_enrolled
FROM enrollment
WHERE student_id = v_student_id;
DBMS_OUTPUT.PUT_LINE ('The student is enrolled into one course');
EXCEPTION
WHEN NO_DATA_FOUND THEN
DBMS_OUTPUT.PUT_LINE ('The student is not enrolled');
WHEN TOO_MANY_ROWS THEN
DBMS_OUTPUT.PUT_LINE
('The student is enrolled in too many courses');
END;
/

