Library IEEE;
Use IEEE.STD_LOGIC_1164.ALL;
Library lattice;
use lattice.all;
entity Compuertas is
	port(
		input_number : in STD_LOGIC_VECTOR(3 downto 0);
		display : out STD_LOGIC_VECTOR(6 downto 0)
	);
end Compuertas;
architecture Cmp of Compuertas is
begin
	WITH input_number SELECT
		display <= "1111110" when "0000",
				   "0000110" when "0001",
				   "1101101" when "0010",
				   "1111001" when "0011",
				   "0110011" when "0100",
				   "1011011" when "0101",
				   "1011111" when "0110",
				   "1110001" when "0111",
				   "1111111" when "1000",
				   "1110011" when "1001",
				   "1110111" when "1010",
				   "0011111" when "1011",
				   "1001110" when "1100",
				   "0111101" when "1101",
				   "1001111" when "1110",
				   "1000111" when "1111",
				   "0000000" WHEN OTHERS;
end Cmp;