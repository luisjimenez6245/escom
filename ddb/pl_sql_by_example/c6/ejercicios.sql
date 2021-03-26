SPOOL C:\Users\luisj\Documents\GitHub\escom\ddb\pl_sql_by_example\c6\salida.txt
rem ROSENZWEIG, B & SILVESTROVA, E. (2009). Oracle® PL/SQL™ by Example,USA:Perarson.


rem [ROSENZWEIG,2009, 117]
SET SERVEROUTPUT ON

DECLARE
    v_counter NUMBER := 0;
BEGIN
    LOOP
        DBMS_OUTPUT.PUT_LINE ('v_counter = '||v_counter);
        EXIT;
    END LOOP;
END;    
/

rem [ROSENZWEIG,2009, 118]
SET SERVEROUTPUT ON
DECLARE
    v_counter BINARY_INTEGER := 0;
BEGIN
    LOOP
        v_counter := v_counter + 1;
        DBMS_OUTPUT.PUT_LINE ('v_counter = '||v_counter);
       EXIT WHEN v_counter = 5;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE ('Done...');
END;
/

rem [ROSENZWEIG,2009, 123]
DECLARE
    v_course course.course_no%type := 430;
    v_instructor_id instructor.instructor_id%type := 102;
    v_sec_num section.section_no%type := 0;
BEGIN
    LOOP
        v_sec_num := v_sec_num + 2;
        INSERT INTO section
        (section_id, course_no, section_no, instructor_id,
        created_date, created_by, modified_date,
        modified_by)
        VALUES
        (section_id_seq.nextval, v_course, v_sec_num,
        v_instructor_id, SYSDATE, USER, SYSDATE, USER);
        EXIT WHEN v_sec_num = 10;
    END LOOP;
    COMMIT;
END;
/


rem [ROSENZWEIG,2009, 127]

DECLARE
    v_counter NUMBER := 1;
BEGIN
    WHILE v_counter <= 2 LOOP
        DBMS_OUTPUT.PUT_LINE ('v_counter = '||v_counter);
        v_counter := v_counter + 1;
        IF v_counter = 5 THEN
            EXIT;
        END IF;
    END LOOP;
END;
/

rem [ROSENZWEIG,2009, 131]
SET SERVEROUTPUT ON
DECLARE
    v_counter BINARY_INTEGER := 2;
    v_sum NUMBER := 0;
BEGIN
    WHILE v_counter <= 100 LOOP
        v_sum := v_sum + v_counter;
        DBMS_OUTPUT.PUT_LINE ('Current sum is: '||v_sum);
        v_counter := v_counter + 2;
    END LOOP;   
    DBMS_OUTPUT.PUT_LINE ('The sum of even integers between '||'1 and 100 is: '||v_sum);
END;

/


rem [ROSENZWEIG,2009, 138]
SET SERVEROUTPUT ON
DECLARE
    v_factorial NUMBER := 1;
BEGIN
    FOR v_counter IN REVERSE 1..10 LOOP
    v_factorial := v_factorial * v_counter;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('Factorial of ten is: '||v_factorial);
END;
/


rem [ROSENZWEIG,2009, 139]
SET SERVEROUTPUT ON
BEGIN
    FOR v_counter IN 0..10 LOOP
        IF MOD(v_counter, 2) = 0 THEN
            DBMS_OUTPUT.PUT_LINE ('v_counter = '||v_counter);
        END IF;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE ('Done...');
END;

/


rem [ROSENZWEIG,2009, 139]
SET SERVEROUTPUT ON
DECLARE
   i INTEGER := 1;
   j INTEGER := 1;
   v_test NUMBER := 0;
BEGIN
    LOOP
      DBMS_OUTPUT.PUT_LINE ('Outer Loop');
      DBMS_OUTPUT.PUT_LINE ('i = '||i);
      DBMS_OUTPUT.PUT_LINE ('v_test = '||v_test);
      v_test := v_test + 1;
      j := 1;
      
      WHILE j <= 2 LOOP
         DBMS_OUTPUT.PUT_LINE ('Inner Loop');
         DBMS_OUTPUT.PUT_LINE ('j = '||j);
         DBMS_OUTPUT.PUT_LINE ('i = '||i);
         DBMS_OUTPUT.PUT_LINE ('v_test = '||v_test);
         j := j + 1;
      END LOOP inner_loop;
      
      i := i + 1;
      EXIT WHEN i > 3;
   END LOOP outer_loop;
END;
/

SPOOL OFF