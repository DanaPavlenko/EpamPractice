use labor_sql;

-- Task 4 (IN, ANY, ALL)
-- 1
SELECT DISTINCT maker FROM product 
WHERE type = "pc" AND maker NOT IN 
(SELECT maker FROM product WHERE type = "laptop"); 

-- 2
SELECT DISTINCT maker FROM product 
WHERE type = "pc" AND maker != ALL 
(SELECT maker FROM product WHERE type = "laptop");

-- 3 
SELECT DISTINCT maker FROM product 
WHERE NOT (type != "pc" OR maker = ANY 
(SELECT maker FROM product WHERE type = "laptop")); 

-- 4
SELECT DISTINCT maker FROM product 
WHERE type = "pc" AND maker IN 
(SELECT maker FROM product WHERE type = "laptop");

-- 5
SELECT DISTINCT maker FROM product 
WHERE NOT (type != "pc" OR maker != ALL 
(SELECT maker FROM product WHERE type = "laptop")); 

-- 6
SELECT DISTINCT maker FROM product 
WHERE type = "pc" AND maker = ANY 
(SELECT maker FROM product WHERE type = "laptop");

-- 7
SELECT DISTINCT maker FROM product 
WHERE type = "pc" AND maker NOT IN 
(SELECT maker FROM product WHERE type = "pc"
 AND model NOT IN (SELECT model FROM pc));
 
 -- 8
SELECT c.country, c.class FROM classes c 
WHERE c.country LIKE (CASE WHEN (SELECT COUNT(*) FROM classes c 
WHERE c.country='Ukraine') IS NOT NULL 
THEN ('Ukraine') ELSE ('%') END);

-- 9
SELECT sh.name, o.battle, b.date FROM ships sh
JOIN outcomes o ON o.ship = sh.name
JOIN battles b ON b.name = o.battle
WHERE result = 'damaged'
AND ship IN (SELECT ship FROM battles
JOIN outcomes ON outcomes.battle = battles.name
WHERE date > b.date);

-- 10
SELECT COUNT(pc.model) AS computer_count FROM pc 
WHERE pc.model IN 
(SELECT pc.model FROM product pr JOIN PC pc 
ON pr.model = pc.model AND maker = "A");

-- 11
SELECT DISTINCT maker FROM product 
WHERE type = "pc" AND model NOT IN 
(SELECT model FROM pc);

-- 12
SELECT model, price FROM laptop 
WHERE price > ANY (SELECT price FROM pc);

-- Task 5 (EXISTS)

-- 1

-- 2
SELECT maker FROM product WHERE 
EXISTS (SELECT model FROM pc WHERE model = product.model AND speed >= 750);

-- 3
SELECT maker FROM product WHERE 
EXISTS (SELECT model FROM pc WHERE model = product.model AND speed >= 750) 
AND EXISTS(SELECT model FROM laptop WHERE model != product.model  AND speed >= 750);

-- 4
SELECT DISTINCT p.maker FROM product p 
WHERE EXISTS (SELECT model FROM pc WHERE pc.model = p.model 
AND pc.speed IN (SELECT MAX(pc.speed))) 
AND EXISTS (SELECT model FROM product WHERE type = "printer" AND maker = p.maker);

-- 5
SELECT sh.name, sh.launched, c.displacement FROM ships sh 
JOIN classes c ON sh.class = c.class WHERE EXISTS 
(SELECT class FROM classes WHERE displacement > 35000 AND class = c.class) 
AND EXISTS (SELECT launched FROM ships WHERE name = sh.name AND launched >=1922);

-- 6
SELECT c.class FROM classes c
LEFT JOIN ships sh ON sh.class = c.class
WHERE c.class IN (SELECT ship FROM outcomes WHERE result = 'sunk') OR
sh.name IN (SELECT ship FROM Outcomes WHERE result = 'sunk')
GROUP BY c.class;

-- 7
SELECT DISTINCT p.maker FROM Product p 
WHERE type = 'laptop' AND EXISTS 
(SELECT maker FROM Product WHERE type = 'printer' AND maker = p.maker);

-- 8
SELECT DISTINCT p.maker FROM Product p 
WHERE type = 'PC' AND NOT EXISTS 
(SELECT maker FROM Product WHERE type = 'printer' AND maker = p.maker);

-- Task 6 (CONCATENATION, DATES, CALCULATIONS)
-- 1
SELECT AVG(price) AS 'середня ціна =' FROM pc;

-- 2
SELECT CONCAT ('MODEL ', model) model, 
CONCAT ('SPEED ', speed) speed, 
CONCAT ('RAM ', ram) ram, 
CONCAT ('HD ', hd) hd, 
CONCAT ('CD ',cd) cd, 
CONCAT ('PRICE ', price) price FROM pc;

-- 3
SELECT DATE_FORMAT(date, "%Y.%m.%d") date FROM income;

-- 4
SELECT ship, battle, CASE result
WHEN "sunk" THEN "потоплений"
WHEN "damaged" THEN "пошкоджений"
WHEN "OK" THEN "неушкоджений"
END AS результат FROM outcomes;

-- 5
SELECT trip_no, date, ID_psg, SUBSTR(place, 1, 1) AS 'row', 
SUBSTR(place, 2, 1) AS 'place' FROM pass_in_trip;

-- 6
SELECT trip_no, id_comp, plane, 
CONCAT ('from ', town_from, ' to ', town_to) AS route FROM trip;

-- Task 7 (STATISTIC, GROUPS)

-- 1
SELECT model, price FROM printer 
WHERE price IN (SELECT MAX(price) FROM printer);

-- 2
SELECT p.type, l.model, l.speed FROM laptop l, product p 
WHERE speed < (SELECT MIN(speed) FROM pc) AND l.model = p.model;

-- 3
SELECT DISTINCT pr.maker, p.price FROM Printer p, Product pr 
WHERE p.color = "y" AND p.price = (SELECT MIN(price) FROM Printer 
WHERE color ='y') AND p.model = pr.model;

-- 4
SELECT maker, COUNT(*) model_count
FROM Product WHERE type = "pc"
GROUP BY maker HAVING COUNT(*) >=2;

-- 5
SELECT AVG(hd) avg_hd FROM Pc pc, Product p 
WHERE pc.model = p.model AND p.maker IN 
(SELECT Product.maker FROM Product INNER JOIN Printer 
ON Product.model = Printer.model 
GROUP BY Product.maker);

-- 6
SELECT p.date, COUNT(town_from) AS count_trips_from_London 
FROM trip t, pass_in_trip p WHERE town_from = "London" 
AND t.trip_no = p.trip_no
GROUP BY date;

-- 7
SELECT date, MAX(count_trips_to_Moscow) 
AS max_count_trips_to_Moscow FROM 
(SELECT p.date, COUNT(town_from) 
AS count_trips_to_Moscow FROM trip t, pass_in_trip p 
WHERE town_to = "Moscow" AND t.trip_no = p.trip_no
GROUP BY date) pass_in_trip;

-- 8 MAKE FIXES
SELECT c.country, COUNT(sh.launched) AS ships_number, sh.launched 
FROM ships sh, classes c 
WHERE sh.class = c.class
GROUP BY c.country, sh.launched; 

-- 9
SELECT DISTINCT o.battle, c.country, COUNT(o.ship) AS ship_number
FROM outcomes o
LEFT JOIN ships s ON s.name = o.ship
LEFT JOIN classes c ON s.class = c.class
WHERE c.country IS NOT NULL
GROUP BY c.country, o.battle
HAVING COUNT(o.ship) >= 2;

 -- Task 8 (SUBQUERIES)
 -- 1   
SELECT p.maker, count(pc.model) pc, 
count(l.model) laptop, 
count(pr.model) printer FROM product p
LEFT JOIN pc pc ON p.model= pc.model 
LEFT JOIN laptop l ON p.model = l.model 
LEFT JOIN printer pr ON p.model = pr.model
GROUP BY maker;

-- 2
SELECT prod.maker, avg_screen FROM 
(SELECT p.maker, AVG(l.screen) AS avg_screen FROM laptop l 
JOIN product p ON l.model = p.model 
GROUP BY p.maker) prod; 

-- 3
SELECT p.maker, MAX(pc.price) AS max_pc_price FROM product p 
JOIN pc pc ON p.model = pc.model
GROUP BY maker;

-- 4
SELECT p.maker, MIN(pc.price) AS min_pc_price FROM product p 
JOIN pc pc ON p.model = pc.model
GROUP BY maker; 

-- 5
SELECT p.speed, avg_price FROM 
(SELECT speed, AVG(price) AS avg_price FROM pc 
WHERE speed > 600 
GROUP BY speed) p;

-- 6
SELECT p.maker, AVG(hd) FROM pc pc 
JOIN product p ON pc.model = p.model WHERE EXISTS 
(SELECT pr.maker FROM product pr WHERE pr.maker = p.maker AND pr.type = "printer")
GROUP BY maker;

-- 7
SELECT o.ship, c.displacement, c.numGuns 
FROM outcomes o JOIN
ships sh ON o.ship = sh.name JOIN
classes c ON sh.class = c.class
WHERE o.battle = 'Guadalcanal';

-- 8
SELECT o.ship, c.country, c.numGuns
FROM outcomes  o LEFT JOIN
ships sh ON o.ship = sh.name LEFT JOIN
classes c ON sh.class = c.class
WHERE o.result = 'damaged';

-- Task 9 (CASE)
-- 1
SELECT DISTINCT p.maker, 
CASE WHEN (SELECT count(model)FROM PC 
WHERE model IN 
(SELECT pr.model FROM product pr WHERE pr.maker=p.maker )) > 0
THEN CONCAT(' '+(SELECT count(model)FROM PC WHERE model IN (SELECT P2.model FROM product P2 WHERE P2.maker = P.maker)),'(YES)') 
ELSE 'NO' END pc
FROM product p 
GROUP BY p.maker;

-- 2
SELECT i.point, i.date, i.inc, o.out
FROM income_o i LEFT JOIN outcome_o o ON i.point = o.point
AND i.date = o.date;

-- 3
SELECT sh.name, c.numGuns, c.bore, c.displacement,
c.type, c.country, sh.launched, c.class
FROM Ships sh JOIN Classes c ON sh.class = c.class
WHERE
CASE WHEN c.numGuns = 8 THEN 1 ELSE 0 END +
CASE WHEN c.bore = 15 THEN 1 ELSE 0 END +
CASE WHEN c.displacement = 32000 THEN 1 ELSE 0 END +
CASE WHEN c.type = 'bb' THEN 1 ELSE 0 END +
CASE WHEN sh.launched = 1915 THEN 1 ELSE 0 END +
CASE WHEN c.country = 'USA' THEN 1 ELSE 0 END +
CASE WHEN c.class = 'Kongo' THEN 1 ELSE 0 END >= 4;

-- 4
SELECT trip_no, plane, (
CASE 
WHEN TIME(time_out) < TIME(time_in) THEN timediff(time_in, time_out)
ELSE timediff(time_out, time_in) END) 
airtime FROM trip;

-- 5 TODO


-- Task 10 (UNION)
-- 1 
SELECT p.maker, p.model, p.type, pc.price FROM Product p, Pc pc 
WHERE p.maker = "B" AND p.model = pc.model
UNION
SELECT p.maker, p.model, p.type, L.price FROM Product p, laptop l 
WHERE p.maker = "B" AND p.model = l.model
UNION
SELECT p.maker, p.model, p.type, pr.price FROM Product p, printer pr 
WHERE p.maker = "B" AND p.model = pr.model;

-- 2
SELECT p.type, pc.model, MAX(pc.price) FROM product p, pc pc 
WHERE p.model=pc.model GROUP BY model
UNION
SELECT p.type, l.model, MAX(l.price) FROM product p, laptop l 
WHERE p.model=l.model GROUP BY model
UNION
SELECT p.type, pr.model, MAX(pr.price) FROM product p, printer pr 
WHERE p.model=pr.model GROUP BY model;

-- 3
SELECT AVG(price) AS avg_price FROM 
(SELECT l.model, l.price FROM laptop l, Product p 
WHERE l.model = p.model AND p.maker = "A"
UNION 
SELECT pc.model, pc.price FROM pc pc, Product p 
WHERE pc.model = p.model AND p.maker = "A") p;

-- 4
SELECT sh.name, sh.class FROM ships sh WHERE sh.name = sh.class
UNION 
SELECT o.ship, c.class FROM outcomes o, classes c WHERE o.ship = c.class;

-- 5
SELECT class FROM ships GROUP BY class HAVING COUNT(name) = 1
UNION
SELECT class FROM classes c, outcomes o WHERE c.class = o.ship 
AND NOT EXISTS (SELECT name FROM ships s WHERE o.ship = s.class);

-- 6
SELECT class, COUNT(name) AS number_of_ships FROM ships 
GROUP BY class HAVING COUNT(name) BETWEEN 1 AND 2
UNION
SELECT class, COUNT(class) FROM classes c, outcomes o 
WHERE c.class = o.ship AND NOT EXISTS 
(SELECT name FROM ships s WHERE o.ship = s.class); 

-- 7
SELECT class, COUNT(name) AS number_of_ships FROM ships 
GROUP BY class
UNION
SELECT class, COUNT(class) FROM classes c, outcomes o 
WHERE c.class = o.ship AND NOT EXISTS 
(SELECT name FROM ships s WHERE o.ship = s.class); 

-- 8
SELECT name FROM ships sh WHERE launched < 1942
UNION 
SELECT ship FROM outcomes o, battles b 
WHERE o.battle = b.name AND YEAR(b.date) < 1942;
