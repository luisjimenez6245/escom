SPOOL C:\Users\luis\Documents\Github\ESCOM\ddb\pl_sql_by_example\c3\salida.txt
rem ROSENZWEIG, B & SILVESTROVA, E. (2009). Oracle® PL/SQL™ by Example,USA:Perarson.


rem [ROSENZWEIG,2009,44]
SET SERVEROUTPUT ON
-- ch03_5a.sql
DECLARE
    v_user student.created_by%TYPE;
    v_date student.created_date%TYPE;
BEGIN
    SELECT USER, sysdate
    INTO v_user, v_date
    FROM dual;
    INSERT INTO student
    (
        student_id, last_name, zip,
        created_by, created_date, modified_by,
        modified_date, registration_date
    )
    VALUES (student_id_seq.nextval, 'Smith',
    11238, v_user, v_date, v_user, v_date,
    v_date
    );
END;
/

rem [ROSENZWEIG,2009,48]
SET SERVEROUTPUT ON
-- ch03_7a.sql
BEGIN
    INSERT INTO student
    ( student_id, Last_name, zip, registration_date,
    created_by, created_date, modified_by,
    modified_date
    )
    VALUES ( student_id_seq.nextval, 'Tashi', 10015,
    '01-JAN-99', 'STUDENTA', '01-JAN-99',
    'STUDENTA','01-JAN-99'
    );
    SAVEPOINT A;
    INSERT INTO student
    (student_id, Last_name, zip, registration_date,  created_by, created_date, modified_by,  modified_date )
    VALUES (student_id_seq.nextval, 'Sonam', 10015,
    '01-JAN-99', 'STUDENTB','01-JAN-99',
    'STUDENTB', '01-JAN-99'
    );
    SAVEPOINT B;
    INSERT INTO student
    (student_id, Last_name, zip, registration_date,  created_by, created_date, modified_by,  modified_date )
    VALUES (student_id_seq.nextval, 'Norbu', 10015,
    '01-JAN-99', 'STUDENTB', '01-JAN-99',
    'STUDENTB', '01-JAN-99'
    );
    SAVEPOINT C;
    ROLLBACK TO B;
END;
/

rem [ROSENZWEIG,2009,50]
SET SERVEROUTPUT ON

DECLARE
    v_Counter NUMBER;
BEGIN
    v_counter := 0;
    FOR i IN 1..100
    LOOP
        v_counter := v_counter + 1;
        IF v_counter = 10
        THEN
            COMMIT;
            v_counter := 0;
        END IF;
    END LOOP;
END;
/

rem [ROSENZWEIG,2009,50]
SET SERVEROUTPUT ON

DECLARE
    v_name student.last_name%TYPE;
    v_id   student.student_id%TYPE;
BEGIN
   BEGIN
      SELECT s.last_name
        INTO v_name
        FROM student s, enrollment e
       WHERE s.student_id = e.student_id
      HAVING COUNT(*) = (SELECT MAX(COUNT(*))
                           FROM student s, enrollment e
                          WHERE s.student_id = e.student_id
                         GROUP BY s.student_id)
      GROUP BY s.last_name;
   EXCEPTION
      WHEN TOO_MANY_ROWS THEN
         v_name := 'Multiple Names';
   END;

   INSERT INTO CHAP4 
   VALUES (CHAP4_SEQ.NEXTVAL, v_name);
   SAVEPOINT A;

   BEGIN
      SELECT s.last_name
        INTO v_name
        FROM student s, enrollment e
       WHERE s.student_id = e.student_id
      HAVING COUNT(*) = (SELECT MIN(COUNT(*))
                           FROM student s, enrollment e
                          WHERE s.student_id = e.student_id
                         GROUP BY s.student_id)
      GROUP BY s.last_name;
   EXCEPTION
      WHEN TOO_MANY_ROWS THEN
         v_name := 'Multiple Names';
   END;

   INSERT INTO CHAP4 
   VALUES (CHAP4_SEQ.NEXTVAL, v_name);
   SAVEPOINT B;

   BEGIN
      SELECT i.last_name
        INTO v_name
        FROM instructor i, section s
       WHERE s.instructor_id = i.instructor_id
      HAVING COUNT(*) = (SELECT MAX(COUNT(*))
                           FROM instructor i, section s
                          WHERE s.instructor_id = i.instructor_id
                         GROUP BY i.instructor_id)
      GROUP BY i.last_name;
   EXCEPTION
      WHEN TOO_MANY_ROWS THEN
         v_name := 'Multiple Names';
   END;

   SAVEPOINT C;

   BEGIN
      SELECT instructor_id
        INTO v_id
        FROM instructor
       WHERE last_name = v_name;
   EXCEPTION
      WHEN NO_DATA_FOUND THEN
         v_id := 999;
   END;

   INSERT INTO CHAP4 
   VALUES (v_id, v_name);
   ROLLBACK TO SAVEPOINT B;

   BEGIN
      SELECT i.last_name
        INTO v_name
        FROM instructor i, section s
       WHERE s.instructor_id = i.instructor_id
      HAVING COUNT(*) = (SELECT MIN(COUNT(*))
                           FROM instructor i, section s
                          WHERE s.instructor_id = i.instructor_id
                         GROUP BY i.instructor_id)
      GROUP BY i.last_name;
  EXCEPTION
    WHEN TOO_MANY_ROWS THEN
       v_name := 'Multiple Names';
  END;

  INSERT INTO CHAP4 
  VALUES (v_id, v_name);

  BEGIN
     SELECT i.last_name
       INTO v_name
       FROM instructor i, section s
      WHERE s.instructor_id = i.instructor_id
     HAVING COUNT(*) = (SELECT MAX(COUNT(*))
                          FROM instructor i, section s
                         WHERE s.instructor_id = i.instructor_id
                        GROUP BY i.instructor_id)
     GROUP BY i.last_name;
  EXCEPTION
     WHEN TOO_MANY_ROWS THEN
        v_name := 'Multiple Names';
  END;

  INSERT INTO CHAP4 
  VALUES (CHAP4_SEQ.NEXTVAL, v_name);
END;
/

SPOOL OFF