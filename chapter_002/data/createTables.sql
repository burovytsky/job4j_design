create database users_and_roles;

create table role(
	id serial primary key,
	name varchar(20)
);

create table users(
	id serial primary key,
	name varchar(50),
	email varchar(100),
	role_id int references role(id)
);

create table rules(
	id serial primary key,
	name varchar(20)
);

create table rules_role(
	id serial primary key,
	role_id int references role(id),
	rules_id int references rules(id)
);

create table category(
	id serial primary key,
	name varchar(20)
);

create table state(
	id serial primary key,
	name varchar(20)
);

create table items(
	id serial primary key,
	name varchar(100),
	description varchar(2000),
	users_id int references users(id),
	category_id int references category(id),
	state_id int references state(id)
);

create table attachs(
	id serial primary key,
	name varchar(50),
	amount int,
	item_id int references items(id)
);

create table comments(
	id serial primary key,
	name varchar(100),
	comment text,
	item_id int references items(id)
);

insert into role (name) values ('role1'), ('role2'), ('role3');
insert into users (name, email, role_id) values
    ('user1', 'user1@mail.com', 1),
    ('user2', 'user2@mail.com', 2),
    ('user3', 'user3@mail.com', 3);
insert into rules (name) values ('rule1'), ('rule2');
insert into rules_role (role_id, rules_id) values (1, 1), (3, 2);
insert into category (name) values ('category1'), ('category2'), ('category3');
insert into state (name) values ('stateLow'), ('stateNormal'), ('stateHigh');
insert into items (name, description, users_id, category_id, state_id) values
    ('item1', 'description item1', 1, 2, 3),
    ('item2', 'desc item2', 3, 3, 2);
insert into attachs (name, amount, item_id) values ('att1', 10, 1), ('att2', 3, 2);
insert into comments (name, comment, item_id) values ('commentName1', 'commentText1', 1),('commentName222', 'commentText2', 2);