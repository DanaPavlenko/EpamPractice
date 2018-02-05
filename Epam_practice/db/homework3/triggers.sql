SET SQL_SAFE_UPDATES = 0;

USE StoredPr_DB; 

-- insert with foreign keys

DELIMITER //
CREATE TRIGGER before_insert_employee
BEFORE INSERT
ON employee FOR EACH ROW
BEGIN
	IF (new.post NOT IN (SELECT post FROM post))
    THEN SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "There is no such post!";
	END IF;
    
    IF (new.pharmacy_id NOT IN (SELECT pharmacy_id FROM pharmacy))
    THEN SET new.pharmacy_id = NULL;
    END IF;
END //

DELIMITER ;

DELIMITER //
CREATE TRIGGER before_insert_pharmacy
BEFORE INSERT
ON pharmacy FOR EACH ROW
BEGIN
	IF (new.street NOT IN (SELECT street FROM street))
    THEN SET new.street = NULL;
	END IF;
END //

DELIMITER ;


DELIMITER //
CREATE TRIGGER before_insert_medicine_zone
BEFORE INSERT
ON medicine_zone FOR EACH ROW
BEGIN
	IF (new.medicine_id NOT IN (SELECT id FROM medicine)) 
    THEN SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "There is no such medicine!";
	END IF;
    
    IF (new.zone_id NOT IN (SELECT id FROM zone)) 
    THEN SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "There is no such zone!";
	END IF;
END //

DELIMITER ;

DELIMITER //
CREATE TRIGGER before_insert_pharmacy_medicine
BEFORE INSERT
ON pharmacy_medicine FOR EACH ROW
BEGIN
	IF (new.pharmacy_id NOT IN (SELECT id FROM pharmacy)) 
    THEN SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "There is no such pharmacy!";
	END IF;
    
    IF (new.medicine_id NOT IN (SELECT id FROM medicine)) 
    THEN SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "There is no such medicine!";
	END IF;
END //

DELIMITER ;

-- update post

DELIMITER //
CREATE TRIGGER no_post_update
BEFORE UPDATE
ON post FOR EACH ROW
BEGIN
        SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "You cannot update any post!";
END //

DELIMITER ;

-- delete

DELIMITER //
CREATE TRIGGER before_delete_post
BEFORE DELETE
ON post FOR EACH ROW
BEGIN
	IF (post IN (SELECT post FROM employee))
    THEN SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "You cannot delete this post!";
	END IF;
END //

DELIMITER ;

DELIMITER //
CREATE TRIGGER after_delete_street
AFTER DELETE
ON street FOR EACH ROW
BEGIN
	UPDATE pharmacy SET street = NULL WHERE old.street = street;
END //

DELIMITER ;

DELIMITER //
CREATE TRIGGER after_delete_pharmacy
AFTER DELETE
ON pharmacy FOR EACH ROW
BEGIN
	UPDATE employee SET pharmacy_id = NULL WHERE old.id = pharmacy_id;
    DELETE FROM pharmacy_medicine WHERE old.id = pharmacy_id;
END //

DELIMITER ;

DELIMITER //
CREATE TRIGGER after_delete_medicine
AFTER DELETE
ON medicine FOR EACH ROW
BEGIN
	DELETE FROM pharmacy_medicine WHERE old.id = medicine_id;
    DELETE FROM medicine_zone WHERE old.id = medicine_id;
END //

DELIMITER //
CREATE TRIGGER after_delete_zone
AFTER DELETE
ON zone FOR EACH ROW
BEGIN
    DELETE FROM medicine_zone WHERE old.id = zone_id;
END //
