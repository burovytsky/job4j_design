CREATE TABLE company
(
id integer NOT NULL,
name character varying,
CONSTRAINT company_pkey PRIMARY KEY (id)
);

CREATE TABLE person
(
id integer NOT NULL,
name character varying,
company_id integer,
CONSTRAINT person_pkey PRIMARY KEY (id)
);

insert into company (id, name) values (1, 'company1'),
(2, 'company2'), (3, 'company3'), (4, 'company4'), (5, 'company5');

insert into person (id, name, company_id) values (1, 'p1', 1),(2, 'p2', 1), (3, 'p3', 2), (4, 'p4', 3),
(5, 'p5', 3),(6, 'p6', 4), (7, 'p7', 4), (8, 'p8', 4), (9, 'p9', 4),(10, 'p10', 5),(11, 'p11', 5);

-- 1) Retrieve in a single query:
-- -names of all persons that are NOT in the company with id = 5
-- -company name for each person

select p.name, c.name from person as p
right join company as c
on (p.company_id = c.id) where not (c.id = 5);

-- 2) Select the name of the company with the maximum number of persons + number of persons in this company

select company_name, person_count from (
    select c.name as company_name, count(p.name) AS person_count
    from person as p right join company as c
	on (p.company_id = c.id)
    group by c.name
) per
order by person_count desc
limit 1;
