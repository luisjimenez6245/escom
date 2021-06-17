SPOOL C:\Users\luisj\Documents\Github\ESCOM\ddb\sql_by_example\c15\salida.txt
rem RISCHERT, A (2004).Oracle® SQL by Example,Upper Saddle River,NJ,USA:Perarson.

set pagesize 99
set linesize 200
set colsep '|=|'
set underline =
set null s/Datos
set feedback on

rem cap 15
rem [RISCHERT,2004,717]
SELECT REGEXP_SUBSTR('Joe Smith, 12345 Berry Lane, Orta, CA 91234',
 '[[:digit:]]{5}$')
 AS substr
 FROM dual;

 SELECT REGEXP_SUBSTR('Joe Smith, 12345 Berry Lane, Orta, CA 91234  23456',
 '[[:digit:]]{5}$')
 AS substr
 FROM dual;


rem [RISCHERT,2004,718]
SELECT REGEXP_INSTR('NY 10032 USA',
 '[[:digit:]]{5}')
 AS rx_instr
 FROM dual ;

rem [RISCHERT,2004,719]
SELECT REGEXP_REPLACE('   Joe    Smith',
 '( ){2,}', ' ')
 AS RX_REPLACE
 FROM dual ;

rem [RISCHERT,2004,726]
SELECT REGEXP_SUBSTR('first field, second field , third field',
', [^,]*,')
FROM dual:


spool off;