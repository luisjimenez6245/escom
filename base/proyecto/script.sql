
create table email(
	email nvarchar(254),
	email_id  int not null primary key auto_increment,
	user_id  int not null,
	is_principal boolean,
	is_active boolean
);

create table phone(
	phone_id  int not null primary key auto_increment,
	user_id  int not,
	phone nvarchar(254),
	is_principal boolean,
	is_active boolean
);

create table user(
	creation_date Datetime,
	name nvarchar(254),
	user_id  int not null primary key auto_increment,
	surname nvarchar(254),
	user_type nvarchar(254),
	is_active boolean,
	password nvarchar(254)
);

create table attribute_kind(
	attribute_kind_id  int not null primary key auto_increment,
	sql_syntax nvarchar(254),
	name  nvarchar(254),
	max_value int,
	min_value int,
	description nvarchar(254)
);

create table _database(
	url nvarchar(254),
	name nvarchar(254),
	database_id  int not null primary key auto_increment
);

create table _table(
	table_id  int not null primary key auto_increment,
	name nvarchar(254),
	database_id  int not null
);

create table query(
	query_type nvarchar(254),
	creation_date Datetime,
	name nvarchar(254),
	query_id  int not null primary key auto_increment,
    database_id int not null
);

create table attribute(
	attribute_kind int not null,
	attribute_id  int not null primary key auto_increment,
	name  nvarchar(254),
	table_id  int not null
);

create table level(
	level_id  int not null primary key auto_increment,
	name nvarchar(254),
	number int,
	is_principal boolean,
	is_active boolean
);
