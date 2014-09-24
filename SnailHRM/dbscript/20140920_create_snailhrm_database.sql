create database if not exists SNAILHRM;

use SNAILHRM; 

create user snailhrm identified by 'snailhrm';

grant usage on *.* to snailhrm@localhost identified by 'snailhrm'; 
grant all privileges on snailhrm.* to snailhrm@localhost; 

