create database android;
use android;
create table testTable
(
	user_id int not null primary key,
	user_name varchar(20) not null,
	user_password varchar(20) not null
)
;