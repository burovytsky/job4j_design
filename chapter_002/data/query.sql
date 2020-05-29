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
Select sum(p.price)
From type as t
Inner join product as p
on p.type_id = t.id
where t.name = 'овощи и фрукты'

--6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
select p.name, p.expired_date, p.price, t.name from product as p
join type t on p.type_id = t.id
where t.name = 'сыр' or t.name = 'молоко';

--7. Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.
Select t.name, sum(price)
From type as t
Inner join product as p
on p.type_id = t.id
where p.price < 10
group by t.name;

--8. Вывести все продукты и их тип.
select p.name, t.name from product as p
join type t on p.type_id = t.id;