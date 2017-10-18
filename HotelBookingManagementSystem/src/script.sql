drop table users cascade constraints;
drop table hotels cascade constraints;
drop table roomdetails cascade constraints;
drop table bookingdetails cascade constraints;
drop table feedback cascade constraints;

create table users(
	user_id varchar(4) primary key,
	password varchar(32), 
	role varchar(10),
	user_name varchar(15) unique,
	name varchar(20),
	mobile_no varchar(10),
	phone varchar(10),
	address varchar(40),
	email varchar(30),
	status varchar(15)
);  

create table hotels(
	hotel_id varchar(4) primary key,
	city varchar(20),
	hotel_name varchar(30),
	address varchar(40),
	description varchar(50),
	avg_rate_per_night number(6,2),
	phone_no1 varchar(10),
	phone_no2 varchar(10),
	rating varchar(3),
	email varchar(30),
	fax varchar(6),
	status varchar(10)
);

create table roomdetails(
	room_id varchar(4) primary key,
	hotel_id varchar(4) references hotels(hotel_id),
	room_no varchar(3),
	room_type varchar(20),
	per_night_rate number(6,2),
	availability char,
	photo varchar(20),
	status varchar(15)
);

create table bookingdetails(
	booking_id varchar(4) primary key,
	room_id varchar(4) references roomdetails(room_id),
	user_id varchar(4) references users(user_id),
	booked_from date,
	booked_to date,
	firstGuestName varchar(20),
	secondGuestName varchar(20),
	no_of_adults number(1),
	no_of_children number(1),
	amount number(6,2),
	status varchar(15)
);

create table feedback(
	name varchar(20),
	email varchar(30),
	message varchar(50)
);

drop sequence booking_id_seq;
drop sequence hotel_id_seq;
drop sequence user_id_seq;
drop sequence room_id_seq;

create sequence booking_id_seq;
create sequence hotel_id_seq;
create sequence user_id_seq;
create sequence room_id_seq;

insert into users values(0,'36bcbb801f5052739af822c6ea51434','admin','system','Pramod Kapoor','7721849377','9324352142','New York, United States','admin@travellerbuddy.com','active');

commit;
