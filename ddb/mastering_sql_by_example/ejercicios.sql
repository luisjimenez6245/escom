
SPOOL C:\Users\luisj\Documents\GitHub\escom\ddb\mastering_sql_by_example\salida.txt

rem Mishra (2002). Mastering Oracle SQL,USA:Perarson.
rem [ROSENZWEIG,2009,31]
-- ch02_3a.sql
SET SERVEROUTPUT ON



rem 57 ignora null no toma en cuenta las filas
SELECT COUNT(*), SUM(SALE_PRICE), AVG(SALE_PRICE)
FROM CUST_ORDER;

rem58 toma null como 0
SELECT AVG(NVL(SALE_PRICE,0)) FROM CUST_ORDER;

rem 58 
SELECT COUNT(CUST_NBR), COUNT(DISTINCT CUST_NBR), COUNT(ALL CUST_NBR)
FROM CUST_ORDER;

rem if we want to find the total number of orders for each customer,execute the following query:
rem 59
SELECT CUST_NBR, COUNT(ORDER_NBR)
FROM CUST_ORDER
GROUP BY CUST_NBR;

rem 61 we might want to display a line number along with the summary information for each customer.
SELECT ROWNUM, CUST_NBR, COUNT(ORDER_NBR)
FROM CUST_ORDER
GROUP BY ROWNUM, CUST_NBR;

rem When we GROUP BY a column that contains NULL values for some rows,all the
rem rows with NULL values are placed into a single group and presented as one summary row in the output.
rem 63
SELECT SALE_PRICE, COUNT(ORDER_NBR)
FROM CUST_ORDER
GROUP BY SALE_PRICE;

rem 64 
SELECT CUST_NBR, COUNT(ORDER_NBR)
FROM CUST_ORDER
WHERE SALE_PRICE > 25
GROUP BY CUST_NBR;

SELECT CUST_NBR, COUNT(ORDER_NBR)
FROM CUST_ORDER
GROUP BY CUST_NBR;

SELECT CUST_NBR, SALE_PRICE
FROM CUST_ORDER;

SELECT CUST_NBR, SALE_PRICE
FROM CUST_ORDER
ORDER BY 1;


SELECT CUST_NBR, SALE_PRICE
FROM CUST_ORDER
WHERE SALE_PRICE >25
ORDER BY 1;

SELECT CUST_NBR, COUNT(ORDER_NBR)
FROM CUST_ORDER
GROUP BY CUST_NBR;

rem where rows, having groups
SELECT CUST_NBR, COUNT(ORDER_NBR)
FROM CUST_ORDER
GROUP BY CUST_NBR
HAVING CUST_NBR < 260;

rem 65 no se puede determinar antes de lso grupos
SELECT CUST_NBR, COUNT(ORDER_NBR)
FROM CUST_ORDER
GROUP BY CUST_NBR
HAVING COUNT(ORDER_NBR) > 2;


rem 66 group by and having  doesn't matter order in select
SELECT CUST_NBR, COUNT(ORDER_NBR)
FROM CUST_ORDER
GROUP BY CUST_NBR
HAVING COUNT(ORDER_NBR) > 1;

SELECT CUST_NBR, COUNT(ORDER_NBR)
FROM CUST_ORDER
HAVING COUNT(ORDER_NBR) > 1
GROUP BY CUST_NBR;