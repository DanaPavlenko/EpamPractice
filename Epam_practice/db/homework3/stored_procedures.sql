DELIMITER //
CREATE PROCEDURE employee_insert
	   (IN employee_surname VARCHAR(30), IN employee_name CHAR(30), IN employee_midle_name VARCHAR(30),
		IN employee_identity_number CHAR(10), IN employee_passport CHAR(10), IN employee_experience DECIMAL(10,1),
		IN employee_birthday DATE, IN employee_post VARCHAR(15), IN employee_pharmacy_id INT)
BEGIN
	INSERT INTO employee
		(surname, name, midle_name, identity_number, passport,
        experience, birthday, post, pharmacy_id)
	VALUES (employee_surname, employee_name, employee_midle_name, employee_identity_number, employee_passport,
		
        employee_experience, employee_birthday, employee_post, employee_pharmacy_id);
END //

DELIMITER;

DELIMITER //

CREATE PROCEDURE medicine_zone_insert (IN medicine_id INT, IN zone_id INT)

BEGIN 

IF EXISTS (SELECT id FROM medicine WHERE id = medicine_id) AND
EXISTS (SELECT id FROM zone WHERE id = zone_id)
THEN INSERT INTO medicine_zone VALUES (medicine_id, zone_id);
END IF;

END //

DELIMITER;

DELIMITER //
CREATE PROCEDURE create_table_for_each_employee()
BEGIN
	DECLARE done int DEFAULT false;
	DECLARE e_name char(27);
	DECLARE e_cursor CURSOR FOR SELECT 'name' FROM employee;
	DECLARE CONTINUE HANDLER
	FOR NOT FOUND SET done = true;
	OPEN e_cursor;
	myLoop: LOOP
		FETCH e_cursor INTO e_name;
		IF done=true THEN LEAVE myLoop;
		END IF;
		SET @temp_query = CONCAT('CREATE TABLE ', e_name, '(arg1 INT PRIMARY KEY, arg2 CHAR(27) NOT NULL, 
		                                                     arg3 INT(10) NULL), arg4 VARCHAR(10) NULL;');
		PREPARE myquery FROM @temp_query;
		EXECUTE myquery;
		DEALLOCATE PREPARE myquery;
	END LOOP;
	CLOSE e_cursor;
END //
DELIMITER ;

CALL employee_insert('YarShmal', 'Taras', 'Pshhh', '2727', '27272727', 0.1, '1996-01-01', 'doctor', 1);

CALL medicine_zone_insert(1, 2);

CALL create_table_cursor();