USE labor_sql;

-- -------------------------------------------------------------------------------------------------------------- --
--                                              Task1                                                             --
-- -------------------------------------------------------------------------------------------------------------- --
SELECT maker, type FROM Product WHERE type = "LAPTOP" ORDER BY maker;
SELECT model, ram, screen, price FROM Laptop WHERE price > 1000 ORDER BY ram, price DESC;
SELECT * FROM Printer WHERE color = "y" ORDER BY price DESC;
SELECT model, speed, hd, cd, price FROM PC WHERE (cd = "12x" OR "24x") AND price < 600 ORDER BY speed DESC;
SELECT name, class FROM Ships WHERE name = class ORDER BY name;
SELECT * FROM PC WHERE speed >= 500 AND price < 800 ORDER BY price DESC;
SELECT * FROM Printer WHERE type != "matrix" AND price < 300 ORDER BY type DESC;
SELECT model, speed FROM PC WHERE price BETWEEN 400 AND 600 ORDER BY hd;
SELECT pc.model, pc.speed, pc.hd FROM PC pc, Product p WHERE pc.hd = (10 OR 20) AND p.maker = "A" ORDER BY pc.speed;
SELECT model, speed, hd, price FROM Laptop WHERE screen >=12 ORDER BY price DESC;
SELECT model, type, price FROM Printer WHERE price < 300 ORDER BY type DESC;
SELECT model, ram, price FROM Laptop WHERE ram = 64 ORDER BY screen;
SELECT model, ram, price FROM PC WHERE ram > 64 ORDER BY hd;
SELECT model, speed, price FROM PC WHERE speed BETWEEN 500 AND 750 ORDER BY hd DESC;
SELECT * FROM Outcome_o o WHERE o.out > 2000 ORDER BY o.date DESC;
SELECT * FROM Income_o WHERE inc BETWEEN 5000 AND 10000 ORDER BY inc;
SELECT * FROM Income WHERE point = 1 ORDER BY inc;
SELECT * FROM Outcome o WHERE o.point = 2 ORDER BY o.out;
SELECT * FROM Classes WHERE country = "Japan" ORDER BY type DESC;
SELECT name, launched FROM Ships WHERE launched BETWEEN 1920 AND 1942 ORDER BY launched DESC;
SELECT ship, battle FROM Outcomes WHERE battle = "Guadalcanal" AND result != "sunk" ORDER BY ship DESC;
SELECT ship, battle, result FROM Outcomes WHERE result = "sunk" ORDER BY ship DESC;
SELECT class, displacement FROM Classes WHERE displacement >= 40000 ORDER BY type;
SELECT trip_no, town_from, town_to FROM Trip WHERE town_from = "London" OR town_to = "London" ORDER BY time_out;
SELECT trip_no, plane, town_from, town_to FROM Trip WHERE plane = "TU-134" ORDER BY time_out DESC;
SELECT trip_no, plane, town_from, town_to FROM Trip WHERE plane != "IL-86" ORDER BY plane;
SELECT trip_no, town_from, town_to FROM Trip WHERE town_from != "Rostov" AND town_to != "Rostov" ORDER BY plane;

-- -------------------------------------------------------------------------------------------------------------- --
--                                             Task2                                                              --
-- -------------------------------------------------------------------------------------------------------------- --
SELECT model FROM PC WHERE (length((REPLACE(model, '1', '**')))-length((model)) >= 2);
SELECT * FROM Outcome WHERE MONTHNAME (date) = "March";
SELECT * FROM Outcome_o WHERE DAYOFMONTH (date) = "14";
SELECT name FROM Ships WHERE name RLIKE "n$" AND name RLIKE "^W";
SELECT name FROM Ships WHERE (length((REPLACE(name, 'e', '**')))-length((name)) = 2);
SELECT name, launched FROM Ships WHERE name NOT RLIKE "a$";
SELECT name FROM Battles WHERE name RLIKE " " AND NOT name RLIKE "c$";
SELECT * FROM Trip WHERE TIME(time_out) BETWEEN "12:00:00" AND "17:00:00";
SELECT * FROM Trip WHERE TIME(time_in) BETWEEN "17:00:00" AND "23:00:00";
SELECT date FROM Pass_in_trip WHERE place RLIKE "^1";
SELECT date FROM Pass_in_trip WHERE place RLIKE "c$";
SELECT SUBSTRING_INDEX (name, ' ', -1) FROM Passenger WHERE name RLIKE " C";
SELECT SUBSTRING_INDEX (name, ' ', -1) FROM Passenger WHERE name NOT RLIKE " J";

-- -------------------------------------------------------------------------------------------------------------- --
--                                            Task3                                                              --
-- -------------------------------------------------------------------------------------------------------------- --
SELECT p.maker, p.type, pc.speed, pc.hd FROM Product p JOIN PC pc ON p.model = pc.model WHERE pc.hd <=8;
SELECT DISTINCT p.maker FROM Product p JOIN PC pc ON p.model = pc.model WHERE pc.speed >= 600;
SELECT DISTINCT p.maker FROM Product p JOIN Laptop l ON p.model = l.model WHERE l.speed < 500;
SELECT l1.model model1, l2.model model2, l1.hd, l1.ram FROM Laptop l1, Laptop l2 WHERE l1.hd = l2.hd AND l1.ram = l2.ram AND l1.model > l2.model;
SELECT c1.country, c1.class bb_class, c2.class bc_class FROM Classes c1, Classes c2 WHERE c1.type = "bb" AND c2.type = "bc" AND c1.country = c2.country;
SELECT DISTINCT p.model, p.maker FROM Product p JOIN PC pc ON p.model = pc.model WHERE pc.price < 600;
SELECT DISTINCT p.model, p.maker FROM Product p JOIN Printer pr ON p.model = pr.model WHERE pr.price > 300;
SELECT p.maker, p.model, pc.price FROM Product p JOIN PC pc ON p.model = pc.model;
SELECT p.maker, p.model, pc.price FROM Product p LEFT JOIN PC pc ON p.model = pc.model;
SELECT p.maker, p.type, p.model, l.speed FROM Product p JOIN Laptop l ON p.model = l.model WHERE l.speed > 600;
SELECT sh.name, c.displacement FROM Ships sh JOIN Classes c ON sh.class = c.class;
SELECT o.ship, o.battle, b.date FROM Outcomes o JOIN Battles b ON o.battle = b.name WHERE o.result = "OK";
SELECT sh.name, c.country FROM Ships sh JOIN Classes c ON sh.class = c.class;
SELECT t.plane, c.name FROM Trip t JOIN Company c ON t.ID_comp=c.ID_comp WHERE t.plane = "BOEING";
SELECT p.name, p_t.date FROM Passenger p JOIN Pass_in_trip p_t ON p.ID_psg = p_t.ID_psg;














