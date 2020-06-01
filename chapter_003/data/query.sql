create table type(
	id serial primary key,
	name varchar(30)
);

create table product(
	id serial primary key,
	name varchar(50),
	type_id int references type(id),
	expired_date date,
	price int
);

insert into type (name) values ('сыр'), ('молоко'), ('мороженное'), ('хлеб'), ('вода'), ('овощи');

insert into product (name, type_id, expired_date, price) values ('голландский', 1, '2020-10-12', 8),
('фета', 1, '2020-07-12', 20), ('простоквашино', 2, '2020-07-20', 5), ('домашнее', 2, '2020-06-12', 15),
('мороженное ласка', 3, '2020-12-12', 40), ('мороженное арктика', 3, '2020-11-12', 5),
('белый медведь', 3, '2020-12-30', 50), ('бородинский', 4, '2020-06-07', 9), ('кирпич', 4, '2020-06-12', 13),
('кока-кола', 5, '2021-05-12', 80), ('спрайт', 5, '2021-07-03', 19);

--1. Написать запрос получение всех продуктов с типом "СЫР"
select p.name, p.expired_date, p.price, t.name from product as p
join type t on p.type_id = t.id
where t.name = 'сыр';

--2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженное"
select * from product
where name like '%мороженное%';

--3. Написать запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце.
select * from product
where expired_date
between '2020-06-01' and '2020-06-30';

--4. Написать запрос, который выводит самый дорогой продукт.
select * from product
where price = (select max(price) from product);

--5. Написать запрос, который выводит количество всех продуктов определенного типа.
Select count(*)
From type as t
Inner join product as p
on p.type_id = t.id
where t.name = 'мороженное'

--6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
select p.name, p.expired_date, p.price, t.name from product as p
join type t on p.type_id = t.id
where t.name = 'сыр' or t.name = 'молоко';

--7. Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.
select t.name from product as p
inner join type as t on p.type_id = t.id
group by t.name having count(*) < 10;

--8. Вывести все продукты и их тип.
select p.name, t.name from product as p
join type t on p.type_id = t.id;