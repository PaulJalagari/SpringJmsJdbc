CREATE TABLE employee_details (
  `emp_id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(255) NOT NULL,
  `last_name` VARCHAR(255) NOT NULL,
  `email_id` VARCHAR(45) NULL,
  PRIMARY KEY (`emp_id`));
  
  CREATE TABLE emp_address (
  `address_id` INT NOT NULL AUTO_INCREMENT,
  `address_details` VARCHAR(255) NULL,
  `emp_id` INT NOT NULL,
  PRIMARY KEY (`address_id`),
  INDEX `fk_emp_address_1_idx` (`emp_id` ASC),
  CONSTRAINT `fk_emp_address_1`
    FOREIGN KEY (`emp_id`)
    REFERENCES `employee_details` (`emp_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
