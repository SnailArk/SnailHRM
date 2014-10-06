CREATE TABLE `address` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `EMPLOYEE_ID` int(10) unsigned NOT NULL,
  `STREET` varchar(45) NOT NULL,
  `COUNTRY` varchar(45) NOT NULL,
  `STATE` varchar(45) NOT NULL,
  `CITY` varchar(45) NOT NULL,
  `ADDRESS_TYPE` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `EMPLOYEE_ID` (`EMPLOYEE_ID`),
  CONSTRAINT `address_ibfk_1` FOREIGN KEY (`EMPLOYEE_ID`) REFERENCES `employee` (`ID`)
);

CREATE TABLE `employee` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `FIRST_NAME` varchar(45) NOT NULL,
  `MIDDLE_NAME` varchar(45) DEFAULT NULL,
  `LAST_NAME` varchar(45) NOT NULL,
  `DATE_OF_BIRTH` date NOT NULL,
  `NATIONALITY` varchar(45) NOT NULL,
  `GENDER` varchar(45) NOT NULL,
  `PHONE_NUMBER` varchar(13) NOT NULL,
  `EMAIL` varchar(45) NOT NULL,
  `STATUS` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`)
);

CREATE TABLE `employee_job_details` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `EMPLOYEE_ID` int(10) unsigned NOT NULL,
  `DEPARTMENT_ID` int(10) unsigned NOT NULL,
  `ROLE_ID` int(10) unsigned NOT NULL,
  `DATE_OF_JOINING` date NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `EMPLOYEE_ID` (`EMPLOYEE_ID`),
  CONSTRAINT `EMPLOYEE_ID` FOREIGN KEY (`EMPLOYEE_ID`) REFERENCES `employee` (`ID`),
  CONSTRAINT `DEPARTMENT_ID` FOREIGN KEY (`ID`) REFERENCES `department` (`ID`),
  CONSTRAINT `ROLE_ID` FOREIGN KEY (`ID`) REFERENCES `role` (`ID`)
);