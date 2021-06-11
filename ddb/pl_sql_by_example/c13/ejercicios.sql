SPOOL C:\Users\luisj\Documents\GitHub\escom\ddb\pl_sql_by_example\c13\salida.txt
rem ROSENZWEIG, B & SILVESTROVA, E. (2009). Oracle® PL/SQL™ by Example,USA:Perarson.

-- Triggers

rem [ROSENZWEIG,2009,268]
CREATE OR REPLACE TRIGGER student_bi
BEFORE INSERT ON student
FOR EACH ROW
DECLARE
v_student_id STUDENT.STUDENT_ID%TYPE;
BEGIN
SELECT STUDENT_ID_SEQ.NEXTVAL
INTO v_student_id
FROM dual;
:NEW.student_id := v_student_id;
:NEW.created_by := USER;
:NEW.created_date := SYSDATE;
:NEW.modified_by := USER;
:NEW.modified_date := SYSDATE;
END;
/

rem [ROSENZWEIG,2009,276]
-- ch13_1c.sql, version 3.0
CREATE OR REPLACE TRIGGER instructor_bi
BEFORE INSERT ON INSTRUCTOR
FOR EACH ROW
DECLARE
v_work_zip CHAR(1);
BEGIN
:NEW.CREATED_BY := USER;
:NEW.CREATED_DATE := SYSDATE;
:NEW.MODIFIED_BY := USER;
:NEW.MODIFIED_DATE := SYSDATE;
SELECT 'Y'
INTO v_work_zip
FROM zipcode
WHERE zip = :NEW.ZIP;
:NEW.INSTRUCTOR_ID := INSTRUCTOR_ID_SEQ.NEXTVAL;
EXCEPTION
WHEN NO_DATA_FOUND THEN
RAISE_APPLICATION_ERROR (-20001, 'Zip code is not valid!');
END;
/

rem [ROSENZWEIG,2009,285]
-- ch13_3a.sql, version 1.0
CREATE OR REPLACE TRIGGER student_address_ins
INSTEAD OF INSERT ON student_address
FOR EACH ROW
BEGIN
INSERT INTO STUDENT
(student_id, first_name, last_name, street_address, zip,
registration_date, created_by, created_date, modified_by,
modified_date)
VALUES
(:NEW.student_id, :NEW.first_name, :NEW.last_name,
:NEW.street_address, :NEW.zip, SYSDATE, USER, SYSDATE, USER,
SYSDATE);
END;
/

rem [ROSENZWEIG,2009,288]
CREATE OR REPLACE TRIGGER student_address_ins
INSTEAD OF INSERT ON student_address
FOR EACH ROW
DECLARE
v_zip VARCHAR2(5);
BEGIN
BEGIN
SELECT zip
INTO v_zip
FROM zipcode
WHERE zip = :NEW.zip;
EXCEPTION
WHEN NO_DATA_FOUND THEN
INSERT INTO ZIPCODE
(zip, city, state, created_by, created_date,
modified_by, modified_date)
VALUES
(:NEW.zip, :NEW.city, :NEW.state, USER, SYSDATE, USER,
SYSDATE);
END;
INSERT INTO STUDENT
(student_id, first_name, last_name, street_address, zip,
registration_date, created_by, created_date, modified_by,
modified_date)
VALUES
(:NEW.student_id, :NEW.first_name, :NEW.last_name,
:NEW.street_address, :NEW.zip, SYSDATE, USER, SYSDATE, USER,
SYSDATE);
END;
/

rem [ROSENZWEIG,2009,286]
-- ch13_3a.sql, version 1.0
CREATE OR REPLACE TRIGGER student_address_ins
INSTEAD OF INSERT ON student_address
FOR EACH ROW
BEGIN
INSERT INTO STUDENT
(student_id, first_name, last_name, street_address, zip,
registration_date, created_by, created_date, modified_by,
modified_date)
VALUES
(:NEW.student_id, :NEW.first_name, :NEW.last_name,
:NEW.street_address, :NEW.zip, SYSDATE, USER, SYSDATE, USER,
SYSDATE);
END;
/

SPOOL OFF