SPOOL C:\Users\luisj\Documents\Github\ESCOM\ddb\sql_by_example\c3\salida.txt
rem RISCHERT, A (2004).Oracle® SQL by Example,Upper Saddle River,NJ,USA:Perarson.


set pagesize 99
set linesize 200
set colsep '|=|'
set underline =
set null s/Datos
set feedback on


SELECT student_id,
    last_name
FROM student;



SELECT RPAD(city, 20, '*') "City Name",
    LPAD(state, 10, '-') "State Name"
FROM zipcode;



SELECT LTRIM('0001234500', '0') left,
    RTRIM('0001234500', '0') right,
    LTRIM(RTRIM('0001234500', '0'), '0') both
FROM dual;



SELECT TRIM(
        LEADING '0'
        FROM '0001234500'
    ) leading,
    TRIM(
        TRAILING '0'
        FROM '0001234500'
    ) trailing,
    TRIM(
        '0'
        FROM '0001234500'
    ) both
FROM dual;


SELECT last_name,
    SUBSTR(last_name, 1, 5),
    SUBSTR(last_name, 6)
FROM student;

SELECT description,
    INSTR(description, 'er')
FROM course;


SELECT LENGTH('Hello there')
  FROM dual;


SELECT RPAD(UPPER(city), 20,'.')
  FROM zipcode
 WHERE state = 'CT';


 SELECT CONCAT(city, state)
  FROM zipcode;


SELECT LOWER('LUIS') as name FROM dual;
SELECT LOWER('ASDFGHJKL') from dual;
SELECT CONCAT('Cara', 'melo') from dual;
SELECT CONCAT('CAME', 'LLO') from dual;


SPOOL OFF