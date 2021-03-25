SPOOL C:\Users\luis\Documents\Github\ESCOM\ddb\pl_sql_by_example\c5\salida.txt
rem ROSENZWEIG, B & SILVESTROVA, E. (2009). Oracle® PL/SQL™ by Example,USA:Perarson.

rem [ROSENZWEIG,2009,55]

DECLARE
v_num NUMBER := &sv_num;
v_num_flag Boolean;
BEGIN
    CASE v_num_flag
        WHEN MOD(v_num,2) = 0 THEN
            DBMS_OUTPUT.PUT_LINE (v_num||' is even number');
        ELSE
            DBMS_OUTPUT.PUT_LINE (v_num||' is odd number');
    END CASE;
    DBMS_OUTPUT.PUT_LINE ('Done');
END;

/



rem [ROSENZWEIG,2009, 89]
-- ch05_1a.sql, version 1.0
SET SERVEROUTPUT ON
DECLARE
    v_date DATE := TO_DATE('&sv_user_date', 'DD-MON-YYYY');
    v_day VARCHAR2(1);
BEGIN
    CASE
        WHEN TO_CHAR(v_date, 'D') = '1' THEN
            DBMS_OUTPUT.PUT_LINE ('Today is Sunday');
        WHEN TO_CHAR(v_date, 'D') = '2' THEN
            DBMS_OUTPUT.PUT_LINE ('Today is Monday');
        WHEN TO_CHAR(v_date, 'D') = '3' THEN
            DBMS_OUTPUT.PUT_LINE ('Today is Tuesday');
        WHEN TO_CHAR(v_date, 'D') = '4' THEN
            DBMS_OUTPUT.PUT_LINE ('Today is Wednesday');
        WHEN TO_CHAR(v_date, 'D') = '5' THEN
            DBMS_OUTPUT.PUT_LINE ('Today is Thursday');
        WHEN TO_CHAR(v_date, 'D') = '6' THEN
            DBMS_OUTPUT.PUT_LINE ('Today is Friday');
        WHEN TO_CHAR(v_date, 'D') = '7' THEN
            DBMS_OUTPUT.PUT_LINE ('Today is Saturday');
    END CASE;
END;
/



rem [ROSENZWEIG,2009, 89]
SET SERVEROUTPUT ON
DECLARE
   v_day VARCHAR2(15);
   v_time VARCHAR(8); 
BEGIN
   v_day := TO_CHAR(SYSDATE, 'fmDay');
   v_time := TO_CHAR(SYSDATE, 'HH24:MI');
   
   CASE SUBSTR(v_day, 1, 1)
      WHEN 'S' THEN
         DBMS_OUTPUT.PUT_LINE (v_day||', '||v_time); 
         
         CASE 
            WHEN v_time BETWEEN '12:01' AND '24:00' THEN
               DBMS_OUTPUT.PUT_LINE ('It''s afternoon'); 
         ELSE
            DBMS_OUTPUT.PUT_LINE ('It''s morning'); 
         END CASE;
   END CASE; 

   DBMS_OUTPUT.PUT_LINE('Done');
END;
/


rem [ROSENZWEIG,2009, 99]
DECLARE
    v_course_no NUMBER;
    v_description VARCHAR2(50);
    v_prereq VARCHAR2(35);
BEGIN
    SELECT course_no, description,
    CASE
    WHEN prerequisite IS NULL THEN
        'No prerequisite course required'
    ELSE TO_CHAR(prerequisite)

    END prerequisite
    INTO v_course_no, v_description, v_prereq
    FROM course
    WHERE course_no = 20;
    DBMS_OUTPUT.PUT_LINE ('Course: '||v_course_no);
    DBMS_OUTPUT.PUT_LINE ('Description: '||v_description);
    DBMS_OUTPUT.PUT_LINE ('Prerequisite: '||v_prereq);
END;

rem [ROSENZWEIG,2009, 100]
SET SERVEROUTPUT ON
DECLARE
   v_instructor_id NUMBER := &sv_instructor_id;
   v_total NUMBER;
BEGIN
   SELECT COUNT(*)
     INTO v_total
     FROM section
    WHERE instructor_id = v_instructor_id;
   
   CASE
      WHEN v_total &= 3 THEN
         DBMS_OUTPUT.PUT_LINE ('This instructor needs a vacation');
      ELSE
         DBMS_OUTPUT.PUT_LINE ('This instructor teaches '||v_total||
            ' sections');	
   END CASE;
   DBMS_OUTPUT.PUT_LINE ('Done…');
END;
/



rem [ROSENZWEIG,2009, 109]
-- ch05_4c.sql, version 3.0
SET SERVEROUTPUT ON
DECLARE
    v_final_grade NUMBER;
BEGIN
    SELECT NULLIF(e.final_grade, g.numeric_grade)
    INTO v_final_grade
    FROM enrollment e
    JOIN grade g
    ON (e.student_id = g.student_id
    AND e.section_id = g.section_id)
    WHERE e.student_id = 102
    AND e.section_id = 86
    AND g.grade_type_code = 'FI';
    DBMS_OUTPUT.PUT_LINE ('Final grade: '||v_final_grade);
END;
/


rem [ROSENZWEIG,2009, 112]
SELECT e.student_id, e.section_id, e.final_grade, g.numeric_grade, 
       COALESCE(g.numeric_grade, e.final_grade) grade
  FROM enrollment e, grade g
 WHERE e.student_id = g.student_id
   AND e.section_id = g.section_id
   AND e.student_id = 102
   AND g.grade_type_code = 'FI';

SELECT e.student_id, e.section_id, e.final_grade, g.numeric_grade, 
       NULLIF(g.numeric_grade, e.final_grade) grade
  FROM enrollment e, grade g
 WHERE e.student_id = g.student_id
   AND e.section_id = g.section_id
   AND e.student_id = 102
   AND g.grade_type_code = 'FI';

SPOOL OFF