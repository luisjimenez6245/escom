SPOOL C:\Users\luisj\Documents\GitHub\escom\ddb\pl_sql_by_example\c14\salida.txt
rem ROSENZWEIG, B & SILVESTROVA, E. (2009). Oracle® PL/SQL™ by Example,USA:Perarson.

-- Compound Triggers

rem [ROSENZWEIG,2009,293]
CREATE OR REPLACE TRIGGER section_biu
BEFORE INSERT OR UPDATE ON section
FOR EACH ROW
DECLARE
v_total NUMBER;
v_name VARCHAR2(30);
BEGIN
SELECT COUNT(*)
INTO v_total
FROM section -- SECTION is MUTATING
WHERE instructor_id = :NEW. instructor_id;
-- check if the current instructor is overbooked
IF v_total >= 10 THEN
SELECT first_name||' '||last_name
INTO v_name
FROM instructor
WHERE instructor_id = :NEW.instructor_id;
RAISE_APPLICATION_ERROR
(-20000, 'Instructor, '||v_name||', is overbooked');
END IF;
EXCEPTION
WHEN NO_DATA_FOUND THEN
RAISE_APPLICATION_ERROR
(-20001, 'This is not a valid instructor');
END;
/

rem [ROSENZWEIG,2009,297]
CREATE OR REPLACE TRIGGER enrollment_biu
BEFORE INSERT OR UPDATE ON enrollment
FOR EACH ROW
DECLARE
v_total NUMBER;
v_name VARCHAR2(30);
BEGIN
SELECT COUNT(*)
INTO v_total
FROM enrollment
WHERE student_id = :NEW. student_id;
-- check if the current student is enrolled in too
-- many courses
IF v_total >= 3 THEN
SELECT first_name||' '||last_name
INTO v_name
FROM student
WHERE student_id = :NEW.STUDENT_ID;
RAISE_APPLICATION_ERROR (-20000, 'Student, '||v_name||
', is registered for 3 courses already');
END IF;
EXCEPTION
WHEN NO_DATA_FOUND THEN
RAISE_APPLICATION_ERROR
(-20001, 'This is not a valid student');
END;
Issue the following INSERT and UPDATE statements:
INSERT INTO ENROLLMENT
(student_id, section_id, enroll_date, created_by, created_date,
modified_by, modified_date)
VALUES (184, 98, SYSDATE, USER, SYSDATE, USER, SYSDATE);
INSERT INTO ENROLLMENT
(student_id, section_id, enroll_date, created_by, created_date,
modified_by, modified_date)
VALUES (399, 98, SYSDATE, USER, SYSDATE, USER, SYSDATE);
UPDATE ENROLLMENT
SET student_id = 399
WHERE student_id = 283;

rem [ROSENZWEIG,2009,302]
CREATE OR REPLACE TRIGGER student_compound
FOR INSERT ON STUDENT
COMPOUND TRIGGER
-- Declaration section
v_day VARCHAR2(10);
v_date DATE;
v_user VARCHAR2(30);
BEFORE STATEMENT IS
BEGIN
v_day := RTRIM(TO_CHAR(SYSDATE, 'DAY'));
IF v_day LIKE ('S%') THEN
RAISE_APPLICATION_ERROR
(-20000, 'A table cannot be modified during off hours');
END IF;
v_date := SYSDATE;
v_user := USER;
END BEFORE STATEMENT;
BEFORE EACH ROW IS
BEGIN
:NEW.student_id := STUDENT_ID_SEQ.NEXTVAL;
:NEW.created_by := v_user;
:NEW.created_date := v_date;
:NEW.modified_by := v_user;
:NEW.modified_date := v_date;
END BEFORE EACH ROW;
END student_compound;
/

rem [ROSENZWEIG,2009,302]
CREATE OR REPLACE TRIGGER section_biu
BEFORE INSERT OR UPDATE ON section
FOR EACH ROW
DECLARE
v_total NUMBER;
v_name VARCHAR2(30);
BEGIN
SELECT COUNT(*)
INTO v_total
FROM section -- SECTION is MUTATING
WHERE instructor_id = :NEW.instructor_id;
-- check if the current instructor is overbooked
IF v_total >= 10 THEN
SELECT first_name||' '||last_name
INTO v_name
FROM instructor
WHERE instructor_id = :NEW.instructor_id;
RAISE_APPLICATION_ERROR
(-20000, 'Instructor, '||v_name||', is overbooked');
END IF;
EXCEPTION
WHEN NO_DATA_FOUND THEN
RAISE_APPLICATION_ERROR
(-20001, 'This is not a valid instructor');
END;
/

rem [ROSENZWEIG,2009,310]
-- ch14_2b.sql, version 2.0
CREATE OR REPLACE TRIGGER enrollment_compound
FOR INSERT OR UPDATE ON enrollment
COMPOUND TRIGGER
v_student_id STUDENT.STUDENT_ID%TYPE;
v_student_name VARCHAR2(50);
v_total INTEGER;
v_date DATE;
v_user STUDENT.CREATED_BY%TYPE;
BEFORE STATEMENT IS
BEGIN
v_date := SYSDATE;
v_user := USER;
END BEFORE STATEMENT;
BEFORE EACH ROW IS
BEGIN
IF INSERTING THEN
:NEW.created_date := v_date;
:NEW.created_by := v_user;
ELSIF UPDATING THEN
:NEW.created_date := :OLD.created_date;
:NEW.created_by := :OLD.created_by;
END IF;
:NEW.MODIFIED_DATE := v_date;
:NEW.MODIFIED_BY := v_user;
IF :NEW.STUDENT_ID IS NOT NULL THEN
BEGIN
v_student_id := :NEW.STUDENT_ID;
SELECT first_name||' '||last_name
INTO v_student_name
FROM student
WHERE student_id = v_student_id;
EXCEPTION
WHEN NO_DATA_FOUND THEN
RAISE_APPLICATION_ERROR
(-20001, 'This is not a valid student');
END;
END IF;
END BEFORE EACH ROW;
AFTER STATEMENT IS
BEGIN
SELECT COUNT(*)
INTO v_total
FROM enrollment
WHERE student_id = v_student_id;
-- check if the current student is enrolled in too
-- many courses
IF v_total >= 3 THEN
RAISE_APPLICATION_ERROR (-20000, 'Student, '||v_student_name||
', is registered for 3 courses already ');
END IF;
END AFTER STATEMENT;
END enrollment_compound;
/


SPOOL OFF



SET SERVEROUTPUT ON
DECLARE
TYPE zip_cur_type IS REF CURSOR;
zip_cur zip_cur_type;
sql_stmt VARCHAR2(500);
v_zip VARCHAR2(5);
v_total NUMBER;
v_count NUMBER;
BEGIN
sql_stmt := 'SELECT zip, COUNT(*) total'||
' FROM student ' ||
'GROUP BY zip';
v_count := 0;
OPEN zip_cur FOR sql_stmt;
LOOP
FETCH zip_cur INTO v_zip, v_total;
EXIT WHEN zip_cur%NOTFOUND;
-- Limit the number of lines printed on the
-- screen to 10
v_count := v_count + 1;
IF v_count <= 10 THEN
DBMS_OUTPUT.PUT_LINE ('Zip code: '||v_zip||
' Total: '||v_total);
END IF;
END LOOP;
CLOSE zip_cur;
EXCEPTION
WHEN OTHERS THEN
IF zip_cur%ISOPEN THEN
CLOSE zip_cur;
END IF;
DBMS_OUTPUT.PUT_LINE ('ERROR: '|| SUBSTR(SQLERRM, 1, 200));
END;
/