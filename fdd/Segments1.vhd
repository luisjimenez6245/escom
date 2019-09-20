Library IEEE;
Use IEEE.STD_LOGIC_1164.ALL;
entity Compuertas is
	port(
		AI : in STD_LOGIC;
		BI : in STD_LOGIC;
		CI :  in STD_LOGIC;
		DI :  in STD_LOGIC;
		A : out STD_LOGIC;
		B : out STD_LOGIC;
		C : out STD_LOGIC;
		D : out STD_LOGIC;
		E : out STD_LOGIC;
		F : out STD_LOGIC;
		G : out STD_LOGIC
	);
end Compuertas;
architecture Cmp of Compuertas is
begin
	A <= AI;
	B <= DI;
	C <= BI;
	D <= CI;
	E <= DI;
	F <= AI and BI;
	G <= DI and CI;
end Cmp;