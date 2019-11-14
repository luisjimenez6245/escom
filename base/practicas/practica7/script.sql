use gustar;



select h.nomm, h.nomh from hsim as h inner join msim as m on h.nomm = m.nomm and h.nomh =  m.nomh;
select h.nomm, h.nomh from hsim as h inner join msim as m on h.nomm = m.nomm and h.nomh =  m.nomh inner join matrim as mat where mat.nomm = h.nomm and mat.nomh = h.nomh;
select COUNT(*) , m.nomm from hsim as h inner join mujer as m on m.nomm = h.nomm group by m.nomm;


SELECT ma.nomm from mujer as ma inner join hsim as ms on  ms.nomm = ma.nomm group by ma.nomm HAVING count(*) = (SELECT count(*) from hombre);


SELECT ma.nomm from mujer as ma inner join hsim as ms on  ms.nomm = ma.nomm  where ((ma.nomm, (select count(*)  from hombre)) in (select DISTINCT nomm , count(*) from hsim group by nomm)) group by ma.nomm;

SELECT ma.nomh from hombre as ma inner join msim as ms on  ms.nomh = ma.nomh group by ma.nomh HAVING count(*) = (SELECT count(*) from mujer); 
SELECT ma.nomh from matrim as ma inner join msim as ms on  ms.nomm = ma.nomm group by ma.nomh HAVING count(*) = (SELECT count(*) from mujer); 
SELECT nomh from hombre where nomh not in (SELECT nomh from msim) and nomh not in (select nomh from matrim);