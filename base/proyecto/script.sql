
DROP database if exists sqlParser;

CREATE database  sqlParser;

use sqlParser;

create table email(
	email nvarchar(254),
	email_id  int not null primary key auto_increment,
	user_id  int not null,
	is_principal boolean,
    	is_valid boolean,
	is_active boolean
);

create table phone(
	phone_id  int not null primary key auto_increment,
	user_id  int not null,
	phone nvarchar(254),
	is_principal boolean,
        	is_valid boolean,
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
    user_id int not null,
	_database_id  int not null primary key auto_increment
);


create table _table(
	_table_id  int not null primary key auto_increment,
	name nvarchar(254),
	_database_id  int not null
);

create table query(
	query_type nvarchar(254),
	creation_date Datetime,
	name text,
	query_id  int not null primary key auto_increment,
    _database_id int not null
);


create table attribute(
	attribute_kind_id int not null,
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
create table session(
  session_id int not null primary key auto_increment,
  user_id int not null,
  token nvarchar(254),
  date datetime,
  ip nvarchar(254)
);

alter table email add constraint FKemail FOREIGN KEY (user_id) REFERENCES user(user_id) on Delete cascade on update cascade;
alter table phone add constraint FKphone FOREIGN KEY (user_id) REFERENCES user(user_id) on Delete cascade on update cascade;
alter table session add constraint FKsession FOREIGN KEY (user_id) REFERENCES user(user_id) on Delete cascade on update cascade;
alter table _table add constraint FK_tabledatabase_id FOREIGN KEY (_database_id) REFERENCES _database(_database_id) on Delete cascade on update cascade;
alter table query add constraint FKquerydatabase_id FOREIGN KEY (_database_id) REFERENCES _database(_database_id) on Delete cascade on update cascade;
alter table attribute add constraint FKattributeattribute_kind_id FOREIGN KEY (attribute_kind_id) REFERENCES attribute_kind(attribute_kind_id) on Delete cascade on update cascade;
alter table _database add constraint FK_databaseuser_id FOREIGN KEY (user_id) REFERENCES user(user_id) on Delete cascade on update cascade;



insert into level (name, number, is_principal, is_active)values("mas facil", 1, true, true);

insert into user (creation_date, name, surname, user_type, is_active, password)
values(now(), 'public user', 'public user', 'PUBLIC', true, '');

insert into _database (url, name,  user_id) values
('localhost', 'test', 1);

insert into query (query_type, creation_date, name, _database_id) values
('INITAL', now(), 'INSERT', 1),
('INITAL', now(), 'SELECT', 1),
('INITAL', now(), 'UPDATE', 1),
('INITAL', now(), 'DELETE', 1),
('INITAL', now(), 'CREATE', 1),
('INITAL', now(), 'DROP', 1),
('INITAL', now(), 'DESCRIBE', 1),
('INITAL', now(), 'ALTER', 1),
('INSERT', now(), 'INTO', 1),
('INSERT', now(), 'VALUES', 1),
('SELECT', now(), 'FROM', 1),
('SELECT', now(), 'WHERE', 1),
('SELECT', now(), 'GROUP BY', 1),
('SELECT', now(), 'HAVING', 1),
('SELECT', now(), 'LIMIT', 1),
('SELECT', now(), 'ORDER BY', 1),
('UPDATE', now(), 'WHERE', 1),
('UPDATE', now(), 'HAVING', 1),
('DELETE', now(), 'FROM', 1),
('DELETE', now(), 'WHERE', 1),
('DELETE', now(), 'HAVING', 1)


;



select * from user;
