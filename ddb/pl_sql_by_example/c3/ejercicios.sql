SPOOL C:\Users\luis\Documents\Github\ESCOM\ddb\pl_sql_by_example\c3\salida.txt
rem ROSENZWEIG, B & SILVESTROVA, E. (2009). Oracle® PL/SQL™ by Example,USA:Perarson.


rem [ROSENZWEIG,2009,44]
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

rem [ROSENZWEIG,2009,40]



SPOOL OFF