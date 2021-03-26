SPOOL C:\Users\luisj\Documents\GitHub\escom\ddb\pl_sql_by_example\c7\salida.txt
rem ROSENZWEIG, B & SILVESTROVA, E. (2009). Oracle® PL/SQL™ by Example,USA:Perarson.


rem [ROSENZWEIG,2009, 147]

-- ch07_1a.sql, version 1.0
SET SERVEROUTPUT ON
DECLARE
    v_counter BINARY_INTEGER := 0;
BEGIN
    LOOP
        -- increment loop counter by one
        v_counter := v_counter + 1;
        DBMS_OUTPUT.PUT_LINE('before continue condition, v_counter = '||v_counter);
        IF v_counter < 3 THEN
            CONTINUE;
        END IF;
        DBMS_OUTPUT.PUT_LINE('after continue condition, v_counter = '||v_counter);
        -- if EXIT condition yields TRUE exit the loop
        IF v_counter = 5 THEN
            EXIT;
        END IF;
    END LOOP;
    -- control resumes here
    DBMS_OUTPUT.PUT_LINE ('Done...');
END;

/



rem [ROSENZWEIG,2009, 150]
-- ch07_1d.sql, version 4.0
SET SERVEROUTPUT ON
DECLARE
    v_counter BINARY_INTEGER := 0;
BEGIN
    LOOP
        v_counter := v_counter + 1;
        DBMS_OUTPUT.PUT_LINE('before continue condition, v_counter = '||v_counter);
        CONTINUE WHEN v_counter < 3;
        DBMS_OUTPUT.PUT_LINE('after continue condition, v_counter = '||v_counter);
        IF v_counter = 5 THEN
            EXIT;
        END IF;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE ('Done...');
END;
/


rem [ROSENZWEIG,2009, 153]
SET SERVEROUTPUT ON
DECLARE
    v_sum NUMBER := 0;
BEGIN
    FOR v_counter in 1..10 LOOP
        CONTINUE WHEN mod(v_counter, 2) = 0;
        v_sum := v_sum + v_counter;
        DBMS_OUTPUT.PUT_LINE ('Current sum is: '||v_sum);
    END LOOP;
    DBMS_OUTPUT.PUT_LINE ('Final sum is: '||v_sum);
END;
/


rem [ROSENZWEIG,2009, 157]
SET SERVEROUTPUT ON
DECLARE
    v_test NUMBER := 0;
BEGIN
    FOR i IN REVERSE 1..3 LOOP
        DBMS_OUTPUT.PUT_LINE('Outer Loop');
        DBMS_OUTPUT.PUT_LINE('i = '||i);
        DBMS_OUTPUT.PUT_LINE('v_test = '||v_test);
        v_test := v_test + 1;
        FOR j IN REVERSE 1..2 LOOP
            DBMS_OUTPUT.PUT_LINE('Inner Loop');
            DBMS_OUTPUT.PUT_LINE('j = '||j);
            DBMS_OUTPUT.PUT_LINE('i = '||i);
            DBMS_OUTPUT.PUT_LINE('v_test = '||v_test);
        END LOOP inner_loop;
    END LOOP outer_loop;
END;

/

SPOOL OFF