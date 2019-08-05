create database java_db ENCODING 'UTF-8';
\c java_db;

drop table contacts;
create table if not exists contacts (
id serial primary key,
telephone varchar(100) not null,
name varchar(100) not null);

INSERT INTO contacts (telephone, name) VALUES ('79788615109', 'test1');
INSERT INTO contacts (telephone, name) VALUES ('79788615108', 'test2');

create role test login password '123';
grant select, insert, delete on contacts to test;
grant usage on contacts_id_seq to test;