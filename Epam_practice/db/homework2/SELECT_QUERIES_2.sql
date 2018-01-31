use labor_sql;

-- Task 4 (IN, ANY, ALL)

SELECT DISTINCT maker FROM product WHERE type = "pc" AND maker NOT IN (SELECT maker FROM product WHERE type = "laptop"); 
SELECT DISTINCT maker FROM product WHERE type = "pc" AND maker != ALL (SELECT maker FROM product WHERE type = "laptop"); 
SELECT DISTINCT maker FROM product WHERE NOT (type != "pc" OR maker = ANY (SELECT maker FROM product WHERE type = "laptop")); 
SELECT DISTINCT maker FROM product WHERE type = "pc" AND maker IN (SELECT maker FROM product WHERE type = "laptop");
SELECT DISTINCT maker FROM product WHERE NOT (type != "pc" OR maker != ALL (SELECT maker FROM product WHERE type = "laptop")); 
SELECT DISTINCT maker FROM product WHERE type = "pc" AND maker = ANY (SELECT maker FROM product WHERE type = "laptop");

-- Task 5 (EXISTS)

SELECT maker FROM product WHERE type = "pc" AND EXISTS (SELECT model FROM product WHERE model = product.model);
SELECT maker FROM product WHERE EXISTS (SELECT model FROM pc WHERE model = product.model  AND speed >= 750);
SELECT maker FROM product WHERE EXISTS (SELECT model FROM pc WHERE model = product.model  AND speed >= 750) AND EXISTS(SELECT * FROM laptop WHERE model != product.model  AND speed >= 750);
SELECT DISTINCT p.maker FROM Product p WHERE type = 'laptop' AND EXISTS (SELECT maker FROM Product WHERE type = 'printer' AND maker = p.maker);
SELECT DISTINCT p.maker FROM Product p WHERE type = 'PC' AND NOT EXISTS (SELECT maker FROM Product WHERE type = 'printer' AND maker = p.maker);

-- Task 6 (CONCATENATION, DATES, CALCULATIONS)

SELECT AVG(price) AS 'середня ціна =' FROM pc;
SELECT CONCAT ('MODEL ', model) model, CONCAT ('SPEED ', speed) speed, CONCAT ('RAM ', ram) ram, CONCAT ('HD ', hd) hd, CONCAT ('CD ',cd) cd, CONCAT ('PRICE ', price) price FROM pc;
SELECT DATE_FORMAT(date, "%Y.%m.%d") date FROM income;

SELECT ship, battle, CASE result
WHEN "sunk" THEN "потоплений"
WHEN "damaged" THEN "пошкоджений"
WHEN "OK" THEN "неушкоджений"
END AS результат FROM outcomes;

SELECT trip_no, id_comp, plane, CONCAT ('from ', town_from, ' to ', town_to) AS route FROM trip;

-- Task 7 (STATISTIC, GROUPS)

SELECT model, price FROM printer WHERE price IN (SELECT MAX(price) FROM printer);
SELECT p.type, l.model, l.speed FROM laptop l, product p WHERE speed < (SELECT MIN(speed) FROM pc) AND l.model = p.model;
   
SELECT DISTINCT pr.maker, p.price FROM Printer p, Product pr 
WHERE p.color = "y" AND p.price = (SELECT MIN(price) FROM Printer WHERE color ='y') AND p.model = pr.model;

SELECT maker, COUNT(*) model_count
FROM Product WHERE type = "pc"
GROUP BY maker HAVING COUNT(*) >=2;

SELECT AVG(hd) avg_hd FROM Pc pc, Product p WHERE pc.model = p.model AND p.maker
 IN (SELECT Product.maker FROM Product INNER JOIN Printer ON Product.model = Printer.model 
GROUP BY Product.maker);
 
 -- Task 8 (SUBQUERIES)
    
SELECT p.maker, count(pc.model) pc, count(l.model) laptop, count(pr.model) printer FROM product p
LEFT JOIN pc pc ON p.model= pc.model 
LEFT JOIN laptop l ON p.model = l.model 
LEFT JOIN printer pr ON p.model = pr.model
GROUP BY maker;

SELECT prod.maker, avg_screen FROM (SELECT p.maker, AVG(l.screen) AS avg_screen FROM laptop l JOIN product p ON l.model = p.model GROUP BY p.maker) prod; 
SELECT prod.maker, max_price FROM (SELECT p.maker, MAX(pc.price) AS max_price FROM pc pc JOIN product p ON pc.model = p.model GROUP BY p.maker) prod; 

SELECT p.maker, MAX(pc.price) pc_price FROM product p JOIN pc pc ON p.model = pc.model
GROUP BY maker;

SELECT prod.maker, min_price FROM (SELECT p.maker, MIN(pc.price) AS min_price FROM pc pc JOIN product p ON pc.model = p.model GROUP BY p.maker) prod; 

SELECT p.maker, MIN(pc.price) pc_price FROM product p JOIN pc pc ON p.model = pc.model
GROUP BY maker;

SELECT p.speed, avg_price FROM (SELECT speed, AVG(price) AS avg_price FROM pc WHERE speed > 600 GROUP BY speed) p;

 -- Task 10 (UNION)
 
SELECT p.maker, p.model, p.type, pc.price FROM Product p, Pc pc WHERE p.maker = "B" AND p.model = pc.model
UNION
SELECT p.maker, p.model, p.type, L.price FROM Product p, laptop l WHERE p.maker = "B" AND p.model = l.model
UNION
SELECT p.maker, p.model, p.type, pr.price FROM Product p, printer pr WHERE p.maker = "B" AND p.model = pr.model;

SELECT p.type, pc.model, MAX(pc.price) FROM product p, pc pc WHERE p.model=pc.model GROUP BY model
UNION
SELECT p.type, l.model, MAX(l.price) FROM product p, laptop l WHERE p.model=l.model GROUP BY model
UNION
SELECT p.type, pr.model, MAX(pr.price) FROM product p, printer pr WHERE p.model=pr.model GROUP BY model;

SELECT AVG(price) AS avg_price FROM (SELECT l.model, l.price FROM laptop l, Product p WHERE l.model = p.model AND p.maker = "A"
UNION 
SELECT pc.model, pc.price FROM pc pc, Product p WHERE pc.model = p.model AND p.maker = "A") p;

SELECT sh.name, sh.class FROM ships sh WHERE sh.name = sh.class
UNION 
SELECT o.ship, c.class FROM outcomes o, classes c WHERE o.ship = c.class;

SELECT class FROM ships GROUP BY class HAVING COUNT(name) = 1
UNION
SELECT class FROM classes c, outcomes o WHERE c.class = o.ship AND NOT EXISTS (SELECT name FROM ships s WHERE o.ship = s.class); 

