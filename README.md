# ContactsWeb
This project has been created to consolidate my skills in web programming: Java, JSP, Servlets, JDBC, PostgreSQL.

You will need to do something with PostgreSQL DB: open Ubuntu terminal and let write. 

$ sudo -i -u postgres

$ psql

create database java_db;

\c java_db;

create table contacts (id serial not null, telephone varchar(100) not null, name varchar(100) not null);

create role test login password '123';

grant select, insert, delete on contacts to test;

grant usage on contacts_id_seq to test;
