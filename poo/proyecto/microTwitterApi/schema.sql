DROP database if exists Microtwitter;
CREATE database  Microtwitter;
use Microtwitter;

create table language(
	name nvarchar(255),
	language_id  int not null primary key auto_increment,
	is_active boolean
);
create table country(
	language_id int not null,
	country_id  int not null primary key auto_increment,
	is_active boolean,
	name nvarchar(255),
	extension nvarchar(255)
);

create table file(
	name nvarchar(255),
	extension nvarchar(255),
	file_id  int not null primary key auto_increment,
	file_type nvarchar(50)
);
create table email(
	email_id  int not null primary key auto_increment,
	user_id  int not null,
	is_active boolean,
	is_principal boolean,
	email nvarchar(255)
);

create table phone(
	phone_id  int not null primary key auto_increment,
	phone nvarchar(255),
	country_id int not null,
	user_id  int not null,
	is_active boolean,
	is_principal boolean
);


create table word(
	name nvarchar(255),
	word_id  int not null primary key auto_increment
);

create table dictonary(
	language_id int not null,
	word_id int not null,
	dictonary_id  int not null primary key auto_increment,
	translate nvarchar(255)
);

create table region(
	country_id int not null,
	name nvarchar(255),
	region_id  int not null primary key auto_increment,
	is_active boolean
);

create table user(
	user_type nvarchar(50),
	surname nvarchar(255),
	creation_date Datetime,
	language_id int not null,
	user_id  int not null primary key auto_increment,
	is_active boolean,
	password nvarchar(255),
	name nvarchar(255),
	photo int not null
);

create table tweet(
	content nvarchar(255),
	creation_date Datetime,
	tweet_id  int not null primary key auto_increment,
	is_coment boolean,
	parent int,
	media_id int null,
	is_retweet boolean,
	user_id int not null
);

create table _like(
	date Datetime,
	like_id  int not null primary key auto_increment,
	user_id int not null,
	tweet_id int not null
);

create table relation(
	follows int not null,
	creation_date Datetime,
	relation_type nvarchar(50),
	relation_id  int not null primary key auto_increment,
	user_id int not null
);

create table notification(
	content nvarchar(255),
	creation_date Datetime,
	visualized boolean,
	notification_id  int not null primary key auto_increment,
	link nvarchar(255),
	user_id int not null
);

alter table dictonary add constraint dictonary_word_id FOREIGN KEY (word_id) REFERENCES word(word_id) on Delete cascade on update cascade;
alter table user add constraint user_photo FOREIGN KEY (photo) REFERENCES file(file_id) on Delete cascade on update cascade;
alter table user add constraint user_language_id FOREIGN KEY (language_id) REFERENCES language(language_id) on Delete cascade on update cascade;
alter table region add constraint region_country_id FOREIGN KEY (country_id) REFERENCES country(country_id) on Delete cascade on update cascade;
alter table dictonary add constraint dictonary_language_id FOREIGN KEY (language_id) REFERENCES language(language_id) on Delete cascade on update cascade;
alter table country add constraint country_language_id FOREIGN KEY (language_id) REFERENCES language(language_id) on Delete cascade on update cascade;
alter table email add constraint email_user_id FOREIGN KEY (user_id) REFERENCES user(user_id) on Delete cascade on update cascade;
alter table phone add constraint phone_user_id FOREIGN KEY (user_id) REFERENCES user(user_id) on Delete cascade on update cascade;
alter table phone add constraint phone_country_id FOREIGN KEY (country_id) REFERENCES country(country_id) on Delete cascade on update cascade;
alter table tweet add constraint tweet_user_id FOREIGN KEY (user_id) REFERENCES user(user_id) on Delete cascade on update cascade;
alter table tweet add constraint tweet_media_id FOREIGN KEY (media_id) REFERENCES file(file_id) on Delete cascade on update cascade;
alter table tweet add constraint tweet_tweet_id FOREIGN KEY (parent) REFERENCES tweet(tweet_id) on Delete cascade on update cascade;
alter table _like add constraint like_tweet_id FOREIGN KEY (tweet_id) REFERENCES tweet(tweet_id) on Delete cascade on update cascade;
alter table _like add constraint like_user_id FOREIGN KEY (user_id) REFERENCES user(user_id) on Delete cascade on update cascade;
alter table relation add constraint relation_follows FOREIGN KEY (follows) REFERENCES user(user_id) on Delete cascade on update cascade;
alter table relation add constraint relation_user_id FOREIGN KEY (user_id) REFERENCES user(user_id) on Delete cascade on update cascade;
alter table notification add constraint notification_user_id FOREIGN KEY (user_id) REFERENCES user(user_id) on Delete cascade on update cascade;
