create database if not exists SNAILHRM;

create table `SNAILHRM`.`DEPARTMENT` (
  `ID` integer unsigned not null auto_increment,
  `DEPARTMENT_NAME` varchar(45) not null,
  `NOTES` varchar(1000) not null,
  primary key (`ID`)
);