SELECT NOW();
SELECT SYSDATE();
SELECT CURDATE();
SELECT CURRENT_DATE();
SELECT CURTIME();
SELECT CURRRENT_TIME();
SELECT YEAR("A");
SELECT MONTH("A");
SELECT MONTHNAME("A");
SELECT QUATER("A");
SELECT HOUR(12);
SELECT MINUTE(12);
SELECT SECOND(12);
SELECT DAYNAME("A");
SELECT DAYOFMONTH("A");
SELECT DAYOFYEAR("A");
SELECT DAYOFWEAK("A");


SELECT ASCII("B");
SELECT ASCII("B");

SELECT CHAR(N);
SELECT CHAR(N);

SELECT CHAR(N, "AS");
SELECT CHAR(N, "AS");

SELECT BIN(100);
SELECT BIN(20);

SELECT CONCAT("", "");
SELECT CONCAT("", "");

SELECT CONCAT_WS(' ', "Se contienen ", "30");
SELECT CONCAT_WS('%', "hay el ", "255");

SELECT HEX(200);
SELECT HEX(220);

SELECT OCT(40);
SELECT OCT(100);

SELECT LOWER("LUIS");
SELECT LOWER("ASDFGHJKL");

SELECT LCASE("BART ES EL HIJO DE HOMERO");
SELECT LCASE("SANGAR ES UN VERBO");


SELECT UPPER("Aquellos usureros sangraban con sus réditos a sus clientes.");
SELECT UPPER("sangre: antiguamente se sangraba a los enfermos como método curativo.");

SELECT UCASE(" esta puerta no abre bien; la ventana se ha abierto por culpa del viento");
SELECT UCASE("la ventana se ha abierto por culpa del viento");


SELECT LEFT("A sangría que supone la emigración de cerebros afecta a toda América Latina.", 5);
SELECT LEFT("Es un restaurante español en el que no faltan paella y sangría en el menú.", 6);

SELECT RIGHT("A mí me gustan los sándwiches de jamón y queso.", 10);
SELECT RIGHT(" comer siempre fuera de casa resulta una sangría para mí.", 4);

SELECT LENGTH("Panguaracutimicuaro");
SELECT LENGTH("esternocleidomastoideo");

SELECT LTRIM("                    Guiso hecho con maíz");
SELECT LTRIM("                    Barro muy espeso.");

SELECT RTRIM("¡adios, qué tortazo!                 ", N);
SELECT RTRIM("nos comprometemos en la defensa y desarrollo de nuestro estatuto     ", N);

SELECT TRIM("      Anastacio es un perro.     ");
SELECT TRIM("      Es imposible que un escritor no se comprometa     ");

SELECT TRIM(Trailing '$' from "$Pretende que acabemos el trabajo antes del fin de semana$");
SELECT TRIM(Trailing '$' from "$Dicho o hecho necio.$");

SELECT TRIM(Leading '$' from "$El cuadro muestra grupos de jinetes$");
SELECT TRIM(Leading '$' from "$Es dificil correr$");

SELECT TRIM(Both '$' from "$El parque es seguro de noche.$");
SELECT TRIM(Both '$' from "$El perro es un labrador$");
SELECT TRIM('$' from "$El queso es rico en minerales$");
SELECT TRIM('$' from "$Soy intolerante a la lactosa$");

SELECT REPEAT("queso", 10);
SELECT REPEAT("pan", 5);

SELECT REVERSE("hipermetría");
SELECT REVERSE("fallas");

SELECT SUBSTRING("cabalgamiento", 4);
SELECT SUBSTRING("Desplazamiento", 2);



SELECT SUBSTRING("acebolladura", 8, 10);
SELECT SUBSTRING("hipoalergénico", 3, 10);

SELECT SUBSTR("Panguaracutimicuaro", 1, 3);
SELECT SUBSTR("esternocleidomastoideo", 10, 5);


SELECT SPACE(20);
SELECT SPACE(15);

SELECT LOCATE("perro", "Luis sacó al perro");
SELECT LOCATE("Luis", "A Luis le gusta el pan");

SELECT INSERT( "A Luis le gusta el pan", 10, 1, " queso y el ");
SELECT INSERT( "10 es 11", 6, 1, " menor que ");

SELECT REPLACE("A Luis%le% el pan",'%', ' ');
SELECT REPLACE("DAILY&&%08:21:00 AM&&%19-09-2019&&%false&&%Lavar los dientes&&%",'&&%', ' ');


