select nomm, nomh from matrim WHERE nomh in (SELECT nomh from hsim) and nomm in (select nomm from msim);

select nomh, nomm from matrim where nomh in (select nomh from msim) and nomm in (select nomm from msim) and nomm in (select nomm from hsim);

Select * from (Select * from hsim where exists (Select * from msim where hsim.nomh=msim.nomh AND hsim.nomm=msim.nomm)) AS aux where exists(select * from matrim where aux.nomh=matrim.nomh AND aux.nomm=matrim.nomm);

select h.nomm, h.nomh from hsim as h join msim as m on h.nomh = m.nomh and m.nomm = h.nomm;

select h.nomm, h.nomh from hsim as h join msim as m on h.nomh = m.nomh and m.nomm = h.nomm join matrim as mt on mt.nomm = h.nomm and mt.nomh = h.nomh; 