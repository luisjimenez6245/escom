SPOOL C:\Users\luisj\Documents\GitHub\escom\ddb\pl_sql_by_example\c11\salida.txt
rem ROSENZWEIG, B & SILVESTROVA, E. (2009). Oracle® PL/SQL™ by Example,USA:Perarson.



rem [ROSENZWEIG & RAKHIMOV,2009,166]
rem 11
rem implicit 231
SET SERVEROUTPUT ON;
DECLARE
v_first_name VARCHAR2(35);
v_last_name VARCHAR2(35);
BEGIN
SELECT first_name, last_name
INTO v_first_name, v_last_name
FROM student
WHERE student_id = 123;
DBMS_OUTPUT.PUT_LINE ('Student name: '||v_first_name||' '||v_last_name);
EXCEPTION
WHEN NO_DATA_FOUND THEN
DBMS_OUTPUT.PUT_LINE
('There is no student with student ID 123');
END;
/
rem 234
rem The variable vr_student is a record type of the existing database table student. In other
rem words, it has the same components as a row in the student table. A cursor-based record is much
rem the same, except that it is drawn from the select list of an explicitly declared cursor.
-- ch11_1a.sql
SET SERVEROUTPUT ON
DECLARE
vr_student student%ROWTYPE;
BEGIN
SELECT *
INTO vr_student
FROM student
WHERE student_id = 156;
DBMS_OUTPUT.PUT_LINE (vr_student.first_name||' '
||vr_student.last_name||' has an ID of 156');
EXCEPTION
WHEN no_data_found THEN
RAISE_APPLICATION_ERROR(-2001,'The Student '|| 'is not in the database');
END;
/
rem 241
SET SERVEROUTPUT ON
DECLARE
v_city zipcode.city%type;
BEGIN
SELECT city
INTO v_city
FROM zipcode
WHERE zip = 07002;
IF SQL%ROWCOUNT = 1
THEN
DBMS_OUTPUT.PUT_LINE(v_city ||' has a '||
'zipcode of 07002');
ELSIF SQL%ROWCOUNT = 0
THEN
DBMS_OUTPUT.PUT_LINE('The zipcode 07002 is '||
' not in the database');
ELSE
DBMS_OUTPUT.PUT_LINE('Stop harassing me');
END IF;
END;
/
rem The declaration section declares a variable, v_city, anchored to the datatype of the city item in
rem the zipcode table. The SELECT statement causes an implicit cursor to be opened, fetched, and then
rem closed. The IF clause uses the attribute %ROWCOUNT to determine if the implicit cursor has a row
rem count of 1. If it does, the first DBMS_OUTPUT line is displayed. Note that this example does not
rem handle a situation in which the row count is greater than 1. Because the zipcode table’s primary
rem key is the zip code, this could happen.

rem triggers
DROP TABLE TEMPORAL5;
CREATE TABLE TEMPORAL5 (X NUMBER, Y NUMBER, Z NUMBER DEFAULT 5);

CREATE OR REPLACE TRIGGER temp_aiur
AFTER INSERT OR UPDATE OF Y ON TEMPORAL5
FOR EACH ROW
WHEN (OLD.Y IS NULL and NEW.Y IS NOT NULL
      OR NEW.X BETWEEN 1 AND 10)
BEGIN
    CASE
    WHEN inserting THEN
        dbms_output.put_line('X := '||:new.x);
    WHEN updating THEN
       dbms_output.put_line
          ('Y is reset from NULL');
    END CASE;
END;
/

REM 2.  Write a trigger to print 
REM the current values in a row 
REM being deleted.

CREATE OR REPLACE TRIGGER temp_adr2
AFTER DELETE ON TEMPORAL5
FOR EACH ROW
BEGIN
    dbms_output.put_line
       (:old.x||' '||:old.y||' '||:old.z);
END;
/

REM 4. Write two triggers that accomplish 
REM the same as the prior six triggers.
REM DROP TRIGGER temp_biudr;
CREATE OR REPLACE TRIGGER temp_biudr2
BEFORE INSERT OR UPDATE OR DELETE ON TEMPORAL5
FOR EACH ROW
BEGIN
    CASE
    WHEN inserting THEN
        dbms_output.put_line('inserting before');
    WHEN updating THEN
        dbms_output.put_line('updating before');
    WHEN deleting THEN
        dbms_output.put_line('deleting before');
    END CASE;
END;
/

CREATE OR REPLACE TRIGGER temp_aiudr
AFTER INSERT OR UPDATE OR DELETE ON TEMPORAL5
FOR EACH ROW
BEGIN
    CASE
    WHEN inserting THEN
        dbms_output.put_line('inserting after');
    WHEN updating THEN
        dbms_output.put_line('updating after');
    WHEN deleting THEN
        dbms_output.put_line('deleting after');
    END CASE;
END;
/

-- DATOS DE PRUEBA
REM 
INSERT INTO TEMPORAL5 (X) VALUES (3);
INSERT INTO TEMPORAL5 (Y) VALUES (10);

INSERT INTO TEMPORAL5 (X) VALUES (100);
SELECT * FROM TEMPORAL5;
UPDATE TEMPORAL5 SET X=X+1 WHERE X>=1;

SELECT * FROM TEMPORAL5;
DELETE FROM TEMPORAL5 WHERE X>1;
SELECT * FROM TEMPORAL5;
INSERT INTO TEMPORAL5 (X) VALUES (30);
INSERT INTO TEMPORAL5 (X) VALUES (40);
INSERT INTO TEMPORAL5 (X) VALUES (50);
INSERT INTO TEMPORAL5 (X) VALUES (60);
SELECT * FROM TEMPORAL5;
INSERT INTO TEMPORAL5 (Y) VALUES (10);

INSERT INTO TEMPORAL5 (X) VALUES (100);
SELECT * FROM TEMPORAL5;
DELETE FROM TEMPORAL5 WHERE X>39;
SELECT * FROM TEMPORAL5;
DELETE FROM TEMPORAL5 WHERE X>7;
SELECT * FROM TEMPORAL5;

CREATE OR REPLACE TRIGGER temp5_aiur
AFTER INSERT OR UPDATE OF Y ON TEMPORAL5
FOR EACH ROW
WHEN (OLD.Y IS NULL and NEW.Y IS NOT NULL
      OR NEW.X BETWEEN 1 AND 10)
BEGIN
    CASE
    WHEN inserting THEN
        dbms_output.put_line('X := '||:new.x);
    WHEN updating THEN
       dbms_output.put_line
          ('Y is reset from NULL');
    END CASE;
END;
.
/
INSERT INTO TEMPORAL5 (X) VALUES (10);
INSERT INTO TEMPORAL5 (X) VALUES (9);
INSERT INTO TEMPORAL5 (X) VALUES (8);

INSERT INTO TEMPORAL5 (X,y,z) VALUES (7,10,20);
INSERT INTO TEMPORAL5 (X,y,z) VALUES (7,11,25);
INSERT INTO TEMPORAL5 (X,y,z) VALUES (7,12,28);
INSERT INTO TEMPORAL5 (X,y,z) VALUES (7,13,20);

rem 
CREATE OR REPLACE TRIGGER temp_adr
AFTER DELETE ON TEMPORAL5
FOR EACH ROW
BEGIN
    dbms_output.put_line
       (:old.x||' '||:old.y||' '||:old.z);
END;
/
spool off