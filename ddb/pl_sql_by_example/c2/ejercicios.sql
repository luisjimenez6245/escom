SPOOL C:\Users\luisj\Documents\GitHub\escom\ddb\pl_sql_by_example\c2\salida.txt

rem ROSENZWEIG, B & SILVESTROVA, E. (2009). Oracle® PL/SQL™ by Example,USA:Perarson.
rem [ROSENZWEIG,2009,31]
-- ch02_3a.sql
SET SERVEROUTPUT ON
DECLARE
    v_cookies_amt NUMBER := 2;
    v_calories_per_cookie CONSTANT NUMBER := 300;
BEGIN
    DBMS_OUTPUT.PUT_LINE('I ate ' || v_cookies_amt || ' cookies with ' || v_cookies_amt * v_calories_per_cookie || ' calories.');
    v_cookies_amt := 3;
    DBMS_OUTPUT.PUT_LINE('I really ate ' || v_cookies_amt || ' cookies with ' || v_cookies_amt * v_calories_per_cookie || ' calories.'); 
    v_cookies_amt := v_cookies_amt + 5;
    DBMS_OUTPUT.PUT_LINE('The truth is, I actually ate ' || v_cookies_amt || ' cookies with ' ||
    v_cookies_amt * v_calories_per_cookie || ' calories.');
END;
/

rem [ROSENZWEIG,2009,33]
-- ch02_3b.sql, version 2.0
SET SERVEROUTPUT ON
DECLARE
    v_lname VARCHAR2(30);
    v_regdate DATE;
    v_pctincr CONSTANT NUMBER(4,2) := 1.50;
    v_counter NUMBER := 0;
    v_new_cost course.cost%TYPE;
    v_YorN BOOLEAN := TRUE;
BEGIN
    v_counter := NVL(v_counter, 0) + 1;
    v_new_cost := 800 * v_pctincr;
    DBMS_OUTPUT.PUT_LINE(v_counter);
    DBMS_OUTPUT.PUT_LINE(v_new_cost);
    v_counter := ((v_counter + 5)*2) / 2;
    v_new_cost := (v_new_cost * v_counter)/4;
    DBMS_OUTPUT.PUT_LINE(v_counter);
    DBMS_OUTPUT.PUT_LINE(v_new_cost);
END;
/


rem [ROSENZWEIG,2009,35]
-- ch02_4b.sql
SET SERVEROUTPUT ON
<< outer_block >>
DECLARE
    v_test NUMBER := 123;
BEGIN
    DBMS_OUTPUT.PUT_LINE('Outer Block, v_test: '||v_test);
    << inner_block >>
    DECLARE
        v_test NUMBER := 456;
    BEGIN
        DBMS_OUTPUT.PUT_LINE('Inner Block, v_test: '||v_test);
        DBMS_OUTPUT.PUT_LINE('Inner Block, outer_block.v_test: '|| Outer_block.v_test);
    END inner_block;
END outer_block;
/

rem [ROSENZWEIG,2009,36]
-- ch02_5a.sql
SET SERVEROUTPUT ON
DECLARE
    e_show_exception_scope EXCEPTION;
    v_student_id NUMBER := 123;
BEGIN
    DBMS_OUTPUT.PUT_LINE('outer student id is '
    ||v_student_id);
    DECLARE
        v_student_id VARCHAR2(8) := 125;
    BEGIN
        DBMS_OUTPUT.PUT_LINE('inner student id is '
        ||v_student_id);
        RAISE e_show_exception_scope;
        END;
    EXCEPTION
        WHEN e_show_exception_scope
        THEN
            DBMS_OUTPUT.PUT_LINE('When am I displayed?');
            DBMS_OUTPUT.PUT_LINE('outer student id is ' || v_student_id);
END;
/


rem [ROSENZWEIG,2009,37]
DECLARE
    v_title VARCHAR2(35);
    v_number NUMBER(8,2);
    v_loc CONSTANT VARCHAR2(4) := '603D';
    v_boolean BOOLEAN;
    v_date DATE := TRUNC(SYSDATE) + 7;
BEGIN
    IF v_title = 'Introduction to Underwater Basketweaving'
    THEN
        DBMS_OUTPUT.PUT_LINE ('This course is '||v_title||'.');
    ELSIF v_loc = '603D'THEN
        IF v_title IS NOT NULL THEN
            DBMS_OUTPUT.PUT_LINE ('The course is '|| v_title ||'.'||' The location is '||v_loc||'.');
        ELSE
            DBMS_OUTPUT.PUT_LINE ('The course is unknown.'|| ' The location is '||v_loc||'.');
        END IF;
    ELSE
        DBMS_OUTPUT.PUT_LINE ('The course and location '|| 'could not be determined.');
    END IF;
    EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE ('An error occurred.');
END;
/

SPOOL OFF