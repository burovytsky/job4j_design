create database car_catalog;

create table engine(
	id serial primary key,
	name varchar(20),
	power float4
);

create table transmission(
	id serial primary key,
	type varchar(20)
	manual automatic cvt
);

create table car_body(
	id serial primary key,
	type varchar(20)
);

create table car(
	id serial primary key,
	brand varchar(20),
	model varchar(20),
	engine_id int references engine(id),
	transmission_id int references transmission(id),
	car_body_id int references car_body(id)
);

insert into engine (name, power) values ('engine1', 2.0), ('engine2', 3.0),('engine3', 1.6),('engine4', 3.6);
insert into transmission (type) values ('manual'), ('automatic'), ('CVT');
insert into car_body (type) values ('Hatchback'), ('Sedan'), ('Coupe'), ('Jeep'), ('Wagon');
insert into car (brand, model, engine_id, transmission_id, car_body_id) values('Opel', 'Insignia', 1, 2, 1),
('Toyota', 'Camry', 4, 1, 2),('BMV', 'X5', 2, 1, 4),('Subaru', 'Impreza', 2, 1, 3);

--1. Вывести список всех машин и все привязанные к ним детали.

select c.brand, c.model, e.name, e.power, t.type, cb.type from car as c
left outer join engine as e on c.engine_id = e.id
left outer join transmission as t on c.transmission_id = t.id
left outer join car_body as cb on c.car_body_id = cb.id;

--2. Вывести отдельно детали, которые не используются в машине, кузова, двигатели, коробки передач.

select e.name, e.power from car as c
right outer join engine as e on c.engine_id = e.id where c.brand is null;

select t.type from car as c
right outer join transmission as t on c.transmission_id = t.id where c.id is null;

select cb.type from car_body as cb
left outer join car as c on cb.id = c.car_body_id where c.id is null;
