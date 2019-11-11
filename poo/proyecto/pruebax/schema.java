drop database if exists  pruebax;
create database  pruebax;

use pruebax;

create table language(
language_id int not null primary key auto_increment,
);
create table country(
country_id int not null primary key auto_increment,
);
create table file(
file_id int not null primary key auto_increment,
);
create table email(
email_id int not null primary key auto_increment,
);
create table phone(
phone_id int not null primary key auto_increment,
);
create table word(
word_id int not null primary key auto_increment,
);
create table dictonary(
dictonary_id int not null primary key auto_increment,
);
create table region(
region_id int not null primary key auto_increment,
);
create table user(
user_id int not null primary key auto_increment,
);
create table tweet(
tweet_id int not null primary key auto_increment,
);
create table like(
like_id int not null primary key auto_increment,
);

