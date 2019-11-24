
DROP database if exists sqlParser;

CREATE database  sqlParser;

use sqlParser;

create table email(
	email nvarchar(254),
	email_id  int not null primary key auto_increment,
	user_id  int not null,
	is_principal boolean,
	is_active boolean
);

create table phone(
	phone_id  int not null primary key auto_increment,
	user_id  int not null,
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
	attribute_kind_id int not null,
	attribute_id  int not null primary key auto_increment,
	name  nvarchar(254),
	table_id  int not null
);

alter table email add constraint FKemail FOREIGN KEY (user_id) REFERENCES user(user_id) on Delete cascade on update cascade;
alter table phone add constraint FKphone FOREIGN KEY (user_id) REFERENCES user(user_id) on Delete cascade on update cascade;
alter table _table add constraint FK_tabledatabase_id FOREIGN KEY (database_id) REFERENCES _database(database_id) on Delete cascade on update cascade;
alter table query add constraint FKquerydatabase_id FOREIGN KEY (database_id) REFERENCES _database(database_id) on Delete cascade on update cascade;
alter table attribute add constraint FKattributeattribute_kind_id FOREIGN KEY (attribute_kind_id) REFERENCES attribute_kind(attribute_kind_id) on Delete cascade on update cascade;

create table level(
	level_id  int not null primary key auto_increment,
	name nvarchar(254),
	number int,
	is_principal boolean,
	is_active boolean
);
