SPOOL C:\Users\luisj\Documents\Github\ESCOM\ddb\sql_by_example\c4\salida.txt
rem RISCHERT, A (2004).Oracle® SQL by Example,Upper Saddle River,NJ,USA:Perarson.


set pagesize 99
set linesize 200
set colsep '|=|'
set underline =
set null s/Datos
set feedback on


SELECT last_name, registration_date 
 FROM student 
 WHERE student_id IN (123, 161, 190);


SELECT last_name, registration_date 
 FROM student 
 WHERE student_id IN (123, 161, 190) ;s


SELECT last_name, registration_date, 
 TO_CHAR(registration_date, 'MM/DD/YYYY') 
 AS "Formatted" 
 FROM student 
 WHERE student_id IN (123, 161, 190) ;



SELECT last_name, 
 TO_CHAR(registration_date, 'Dy') AS "1.Day", 
 TO_CHAR(registration_date, 'DY') AS "2.Day", 
 TO_CHAR(registration_date, 'Month DD, YYYY') 
 AS "Look at the Month", 
 TO_CHAR(registration_date, 'HH:MI pm') AS "Time" 
 FROM student 
 WHERE student_id IN (123, 161, 190) ;

 SELECT last_name, 
 TO_CHAR(registration_date, 'fmMonth ddth, YYYY') 
 "Eliminating Spaces", 
 TO_CHAR(registration_date, 'Ddspth "of" fmMonth') 
 "Spelled out" 
 FROM student 
 WHERE student_id IN (123, 161, 190) ;



SELECT TO_CHAR(TO_DATE('17-OCT-67','DD-MON-RR'),'YYYY') "1900", 
 TO_CHAR(TO_DATE('17-OCT-17','DD-MON-RR'),'YYYY') "2000" 
 FROM dual;




SELECT course_no, section_id, 
 TO_CHAR(start_date_time, 'DD-MON-YYYY HH24:MI') 
 FROM section 
WHERE start_date_time >= TO_DATE('04-MAY-2003', 'DD-MON-YYYY')
 AND start_date_time < TO_DATE('05-MAY-2003', 'DD-MON-YYYY');


SELECT course_no, section_id, 
 TO_CHAR(start_date_time, 'DD-MON-YYYY HH24:MI') 
 FROM section 
WHERE start_date_time >= TO_DATE('04-MAY-2003 12:00:00 AM',
 'DD-MON-YYYY HH:MI:SS AM')
 AND start_date_time <= TO_DATE('04-MAY-2003 11:59:59 PM',
 'DD-MON-YYYY HH:MI:SS AM');



SELECT section_id, 
 TO_CHAR(start_date_time, 'DD-MON-YYYY HH24:MI:SS') 
 FROM section 
 WHERE start_date_time BETWEEN 
 TO_DATE('07/01/2003', 'MM/DD/YYYY') 
 AND TO_DATE('07/31/2003 23:59:59', 'MM/DD/YYYY HH24:MI:SS');


SELECT course_no, section_id, 
 TO_CHAR(start_date_time, 'Day DD-Mon-YYYY') 
 FROM section 
 WHERE TO_CHAR(start_date_time, 'fmDay') = 'Tuesday';


SELECT TO_CHAR(SYSDATE,'DD-MON-YYYY HH24:MI') now, 
 TO_CHAR(ROUND(SYSDATE),'DD-MON-YYYY HH24:MI') day, 
 TO_CHAR(ROUND(SYSDATE,'MM'),'DD-MON-YYYY HH24:MI') 
 mon 
 FROM dual ;


SELECT TO_CHAR(SYSDATE, 'MM/DD HH24:MI:SS') now, 
 TO_CHAR(SYSDATE+3/24, 'MM/DD HH24:MI:SS') 
 AS now_plus_3hrs, 
 TO_CHAR(SYSDATE+1, 'MM/DD HH24:MI:SS') tomorrow, 
 TO_CHAR(SYSDATE+1.5, 'MM/DD HH24:MI:SS') AS 
 "36Hrs from now" 
 FROM dual;


SELECT TO_CHAR(start_date_time, 'DD-MON-YYYY') "Start Date", 
 EXTRACT(MONTH FROM start_date_time) "Month", 
 EXTRACT(YEAR FROM start_date_time) "Year", 
 EXTRACT(DAY FROM start_date_time) "Day" 
 FROM section 
 WHERE EXTRACT(MONTH FROM start_date_time) = 4 
 ORDER BY start_date_time;




 SELECT LAST_DAY(TO_DATE('13-FEB-1964','DD-MON-YYYY')) lastday, 
 LAST_DAY(TO_DATE('13-FEB-1964','DD-MON-YYYY')) 
 - TO_DATE('13-FEB-1964','DD-MON-YYYY') days 
 FROM dual ;


 SELECT TO_CHAR(SYSDATE, 'DD-MON-YYYY HH24:MI:SS') "Current", 
 TO_CHAR(SYSDATE+3, 'DD-MON-YYYY HH24:MI:SS') "Answer" 
 FROM dual;

SELECT TO_CHAR(CURRENT_DATE, 'DD-MON-YYYY HH:MI:SS PM') 
 FROM dual ;




 SELECT TZ_OFFSET('Europe/London') "London", 
 TZ_OFFSET('America/New_York') "NY", 
 TZ_OFFSET('America/Chicago') "Chicago", 
 TZ_OFFSET('America/Denver') "Denver", 
 TZ_OFFSET('America/Los_Angeles') "LA" 
 FROM dual ;


SELECT DISTINCT TO_CHAR(created_date, 'DD-MON-YY HH24:MI')"CREATED_DATE", 
 TO_CHAR(start_date_time, 'DD-MON-YY 
HH24:MI')"START_DATE_TIME", 
 start_date_time-created_date"Decimal", 
 NUMTODSINTERVAL(start_date_time-created_date, 
'DAY')"Interval" 
 FROM section 
 ORDER BY 3 ;


 SELECT section_id "ID", 
 TO_CHAR(created_date, 'MM/DD/YY HH24:MI') 
 "CREATED_DATE", 
 TO_CHAR(start_date_time, 'MM/DD/YY HH24:MI') 
 "START_DATE_TIME", 
 NUMTODSINTERVAL(start_date_time-created_date, 'DAY') 
 "Interval" 
 FROM section 
 WHERE NUMTODSINTERVAL(start_date_time-created_date, 'DAY') 
 BETWEEN INTERVAL '100' DAY(3) AND INTERVAL '120' DAY(3) 
 ORDER BY 3 ;



SELECT NUMTODSINTERVAL(360, 'SECOND'), 
 NUMTODSINTERVAL(360, 'MINUTE') 
 FROM dual ;


SELECT zip, city 
 FROM zipcode 
 WHERE zip = 10025 ;

SELECT zip, city 
 FROM zipcode 
 WHERE zip = TO_CHAR(10025);


SPOOL OFF