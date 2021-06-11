SPOOL C:\Users\luisj\Documents\GitHub\escom\ddb\pl_sql_by_example\c11\salida.txt
rem ROSENZWEIG, B & SILVESTROVA, E. (2009). Oracle® PL/SQL™ by Example,USA:Perarson.



rem [ROSENZWEIG & RAKHIMOV,2009,166]
rem 19
SELECT distinct s.course_no, c.description
FROM section s, enrollment e, course c
WHERE s.section_id = e.section_id
AND c.course_no = s.course_no
GROUP BY s.course_no, c.description,
e.section_id, s.section_id
HAVING COUNT(*) >=8;

SELECT course_no,description,cost from course;

CREATE OR REPLACE PROCEDURE Discount
AS
CURSOR c_group_discount
IS
SELECT distinct s.course_no, c.description
FROM section s, enrollment e, course c
WHERE s.section_id = e.section_id
AND c.course_no = s.course_no
GROUP BY s.course_no, c.description,
e.section_id, s.section_id
HAVING COUNT(*) >=8;
BEGIN
FOR r_group_discount IN c_group_discount
LOOP
UPDATE course
SET cost = cost * .95
WHERE course_no = r_group_discount.course_no;
DBMS_OUTPUT.PUT_LINE
('A 5% discount has been given to '||
r_group_discount.course_no||' '||
r_group_discount.description
);
END LOOP;
END;
/

execute Discount;
rem 446
SELECT distinct s.course_no, c.description, c.cost
FROM section s, enrollment e, course c
WHERE s.section_id = e.section_id
AND c.course_no = s.course_no
GROUP BY s.course_no, c.description,
e.section_id, s.section_id,c.cost
HAVING COUNT(*) >=8;

-- ch19_02a.sql
CREATE OR REPLACE PROCEDURE find_sname
(i_student_id IN NUMBER,
	first OUT VARCHAR2,
	last OUT VARCHAR2
)
AS
BEGIN
SELECT first_name, last_name
INTO first, last
FROM student
WHERE student_id = i_student_id;
EXCEPTION
WHEN OTHERS
THEN
DBMS_OUTPUT.PUT_LINE('Error in finding student_id:
'||i_student_id);
END find_sname;
/

DECLARE
v_local_first_name student.first_name%TYPE;
v_local_last_name student.last_name%TYPE;
BEGIN
find_sname
(145, v_local_first_name, v_local_last_name);
DBMS_OUTPUT.PUT_LINE
('Student 145 is: '||v_local_first_name||
' '|| v_local_last_name||'.'
);
END;
/