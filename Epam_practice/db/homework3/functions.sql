DELIMITER //
CREATE FUNCTION min_experience()
RETURNS decimal (10, 1)
BEGIN
RETURN (SELECT MIN(experience) FROM employee);
END //

DELIMITER ;

DELIMITER //
CREATE FUNCTION name_and_building_number(ph_id INT)
RETURNS varchar(25)
BEGIN
RETURN (SELECT CONCAT(name, ' ', building_number) FROM pharmacy WHERE id = ph_id);
END //

DELIMITER ;

SELECT*, name_and_building_number(id) FROM employee;

SELECT min_experience() experience;