create table EMPLOYEE_PERSONAL_DETAILS (
  ID integer unsigned not null auto_increment,
  FIRST_NAME varchar(45) not null,
  MIDDLE_NAME varchar(45),
  LAST_NAME varchar(45) not null,
  DATE_OF_BIRTH date not null,
  NATIONALITY varchar(45) not null,
  GENDER varchar(45) not null,
  PHONE_NUMBER varchar(13) not null,
  EMAIL varchar(45) not null,
  STATUS boolean not null,
  primary key (ID)
);

create table EMPLOYEE_JOB_DETAILS (
  ID integer unsigned not null auto_increment,
  EMPLOYEE_ID integer unsigned not null,
  DEPARTMENT varchar(45) not null,
  ROLE varchar(45) not null,
  DATE_OF_JOINING date not null,
  primary key (ID),
  foreign key (EMPLOYEE_ID) references EMPLOYEE_PERSONAL_DETAILS(ID) 
);

create table EMPLOYEE_ADDRESS_DETAILS (
	ID integer unsigned not null auto_increment,
	EMPLOYEE_ID integer unsigned not null,
	STREET varchar(45) not null,
  	COUNTRY varchar(45) not null,
  	STATE varchar(45) not null,
  	CITY varchar(45) not null,
  	primary key (ID),
  	foreign key (EMPLOYEE_ID) references EMPLOYEE_PERSONAL_DETAILS(ID)
);


