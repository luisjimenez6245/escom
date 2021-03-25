SPOOL C:\Users\luis\Documents\Github\ESCOM\ddb\pl_sql_by_example\c4\salida.txt
rem ROSENZWEIG, B & SILVESTROVA, E. (2009). Oracle® PL/SQL™ by Example,USA:Perarson.


rem [ROSENZWEIG,2009,55]
SET SERVEROUTPUT ON
DECLARE
    v_num1 NUMBER := 5;
    v_num2 NUMBER := 3;
    v_temp NUMBER;
BEGIN
    IF v_num1 > v_num2 THEN
        v_temp := v_num1;
        v_num1 := v_num2;
        v_num2 := v_temp;
    END IF;
    DBMS_OUTPUT.PUT_LINE ('v_num1 = '||v_num1);
    DBMS_OUTPUT.PUT_LINE ('v_num2 = '||v_num2);
END;
/

rem [ROSENZWEIG,2009,58]
SET SERVEROUTPUT ON
DECLARE
    v_num1 NUMBER := 0;
    v_num2 NUMBER;
BEGIN
    IF v_num1 = v_num2 THEN
        DBMS_OUTPUT.PUT_LINE ('v_num1 = v_num2');
    ELSE
        DBMS_OUTPUT.PUT_LINE ('v_num1 != v_num2');
    END IF;
END;
/

rem [ROSENZWEIG,2009,60]
-- ch04_1b.sql, version 2.0
SET SERVEROUTPUT ON
DECLARE
    v_date DATE := TO_DATE('&sv_user_date', 'DD-MON-YYYY');
    v_day VARCHAR2(15);
BEGIN
    v_day := TO_CHAR(v_date, 'DAY');
    IF v_day IN ('SATURDAY', 'SUNDAY') THEN
        DBMS_OUTPUT.PUT_LINE (v_date||' falls on weekend');
    END IF;
    DBMS_OUTPUT.PUT_LINE ('Done...');
END;
/

rem [ROSENZWEIG,2009,63]
-- ch04_2b.sql, version 2.0
SET SERVEROUTPUT ON
DECLARE
    v_total NUMBER;
    v_course_no CHAR(6) := '&sv_course_no';
    v_section_no NUMBER := &sv_section_no;
BEGIN
    SELECT COUNT(*) INTO v_total FROM enrollment e
    JOIN section s USING (section_id)
    WHERE s.course_no = v_course_no
    AND s.section_no = v_section_no;
    IF v_total >= 15 THEN
        DBMS_OUTPUT.PUT_LINE('Section 1 of course 25 is full');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Section 1 of course 25 is not full');
    END IF;
END;
/


rem [ROSENZWEIG,2009,64]
-- ch04_2c.sql, version 3.0
SET SERVEROUTPUT ON
DECLARE
    v_total NUMBER;
    v_students NUMBER;
BEGIN
    SELECT COUNT(*) INTO v_total FROM enrollment e
    JOIN section s USING (section_id)
    WHERE s.course_no = 25
    AND s.section_no = 1;

    IF v_total >= 15 THEN
        DBMS_OUTPUT.PUT_LINE('Section 1 of course 25 is full');
    ELSE
        v_students := 15 - v_total;
        DBMS_OUTPUT.PUT_LINE (v_students|| ' students can still enroll into section 1'||' of course 25');
    END IF;
END;
/

rem [ROSENZWEIG,2009,69]
-- ch04_3a.sql, version 1.0
SET SERVEROUTPUT ON
DECLARE
    v_student_id NUMBER := &sv_student_id;
    v_section_id NUMBER := &sv_section_id;
    v_final_grade NUMBER;
    v_letter_grade CHAR(1);
BEGIN
    SELECT final_grade INTO v_final_grade
    FROM enrollment
    WHERE student_id = v_student_id
    AND section_id = v_section_id;


    IF v_final_grade IS NULL THEN
        DBMS_OUTPUT.PUT_LINE('v_final_grade is null');
    ELSIF v_final_grade >= 90 THEN
        v_letter_grade := 'A';
    ELSIF v_final_grade >= 80 THEN
        v_letter_grade := 'B';
    ELSIF v_final_grade >= 70 THEN
        v_letter_grade := 'C';
    ELSIF v_final_grade >= 60 THEN
        v_letter_grade := 'D';
    ELSE
        v_letter_grade := 'F';
    END IF;
    
    DBMS_OUTPUT.PUT_LINE ('Letter grade is: '|| v_letter_grade);

    EXCEPTION
        WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE ('There is no such student or section');
END;
/



rem [ROSENZWEIG,2009,79]
-- ch04_4b.sql, version 2.0
DECLARE
    v_temp_in NUMBER := &sv_temp_in;
    v_scale_in CHAR := '&sv_scale_in';
    v_temp_out NUMBER;
    v_scale_out CHAR;
BEGIN
    IF v_scale_in != 'C' AND v_scale_in != 'F' THEN
        DBMS_OUTPUT.PUT_LINE ('This is not a valid scale');
        v_temp_out := 0;
        v_scale_out := 'C';
    ELSE
        IF v_scale_in = 'C' THEN
            v_temp_out := ( (9 * v_temp_in) / 5 ) + 32;
            v_scale_out := 'F';
        ELSE
            v_temp_out := ( (v_temp_in - 32) * 5 ) / 9;
            v_scale_out := 'C';
        END IF;
    END IF;
    DBMS_OUTPUT.PUT_LINE ('New scale is: '||v_scale_out);
    DBMS_OUTPUT.PUT_LINE ('New temperature is: '||v_temp_out);
END;
/

SPOOL OFF