insert into address (id, street) values (1, 'Empty street');
insert into address (id, street) values (2, 'Full street');
insert into users (id, first_name) values (1, 'John');
update address set user_id=1 where id=1;
update address set user_id=1 where id=2;