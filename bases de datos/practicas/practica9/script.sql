DROP database if exists Productos;

CREATE database  Productos;
use Productos;


select medio from registra GROUP by medio;
--(DNI+4)
select (DNI+4) as 'Nuevo DNI'  FROM cliente;

select * from cliente where edad > 30 order by edad desc;

select * from cliente where edad < 30 or edad > 50 order by edad desc;

select * from Programa WHERE nombreP  like  'Ac%';

select * from cliente where nombre like '%o%';

SELECT Version from Programa where nombreP = 'Windows';

SELECT upper(ciudad) from Comercio where NombreC  = 'El corte inglés';

SELECT c.Nombre from registra r 
inner join Programa p on p.codigo = r.codigo 
inner join  cliente c on c.DNI = r.DNI 
inner join desarrolla d on d.codigo = r.codigo 
inner join fabricante f on f.idFab = d.idFab 
where f.nombre = 'Oracle' 
GROUP by c.nombre, c.edad 
order by c.edad desc
limit 1;

SELECT count(*), f.nombre from fabricante f 
inner join desarrolla d on f.idFab = d.idFab  
inner join Programa p on p.codigo = d.codigo 
GROUP by f.nombre;

select  p.nombreP , count(*) from registra r
inner join Programa p on p.codigo = r.codigo 
GROUP by p.nombreP 
having COUNT(*) > 1;

SELECT p.nombreP, p.version from distribuye d
inner join Programa p on p.codigo = d.codigo
inner join comercio c on c.CFI = d.CIF
where d.cantidad > 3
GROUP by p.nombreP, p.version;

SELECT c.ciudad from distribuye d
inner join desarrolla de on de.codigo = d.codigo  
inner join fabricante f on f.idFab = de.idFab 
inner join comercio c on c.CFI = d.CIF
where f.nombre = 'Oracle' 
GROUP by c.ciudad; 

select c.nombre from cliente c
INNER JOIN registra r on r.DNI = c.DNI
inner join Programa p on p.codigo = r.codigo
INNER join
