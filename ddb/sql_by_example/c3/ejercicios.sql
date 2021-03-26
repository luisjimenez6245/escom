SPOOL C:\Users\luis\Documents\Github\ESCOM\ddb\sql_by_example\c3\salida.txt
rem RISCHERT, A (2004).Oracle® SQL by Example,Upper Saddle River,NJ,USA:Perarson.


SELECT student_id, last_name FROM student WHERE INSTR(last_name, 'o', 1, 3) > 0;





SPOOL OFF