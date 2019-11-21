DROP database if exists perros;
CREATE database  perros;
use perros;

create table tableName(
	nombre nvarchar(255),
    raza nvarchar(255),
	edad int,
	genero nvarchar(255),
	tableName_id  int not null primary key auto_increment
);