--alter table if exists users drop constraint if exists FKr822dcf3gyok7wi2ae40poxw4;
--drop table if exists address cascade;
--drop table if exists users cascade;
--
--create table address (id int8 generated by default as identity, street varchar(255), primary key (id));
--create table users (id int8 not null, first_name varchar(255), primary key (id));
--alter table if exists users add constraint FKr822dcf3gyok7wi2ae40poxw4 foreign key (id) references address;

insert into address (id, street) values (1, 'Empty street');
insert into users (id, first_name, address_id) values (1, 'John', 1);
