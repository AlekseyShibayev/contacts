create table if not exists company (
                                       id serial primary key,
                                       name varchar(100) not null
);
create table if not exists contact (
                                       id serial primary key,
                                       name varchar(100) not null,
                                       company_id integer not null,
                                       foreign key (company_id) references company (id)
);
create table if not exists passport (
                                        id serial primary key ,
                                        number varchar (100) not null,
                                        constraint fk_passport_id foreign key (id) references contact (id)
);
create table if not exists telephone (
                                         id serial primary key,
                                         number varchar (100) not null,
                                         contact_id integer
);
create table if not exists device (
                                      id serial primary key,
                                      name varchar (100) not null
);
create table if not exists contact_device (
                                              contact_id serial,
                                              device_id serial,
                                              PRIMARY KEY (contact_id, device_id),
                                              foreign key (contact_id) references contact (id) on update cascade,
                                              foreign key (device_id) references device (id) on update cascade
);
create role test login password '123';
grant select, insert, update, delete on contact, telephone, passport, company, device, contact_device to test;
grant usage on contact_id_seq, telephone_id_seq, passport_id_seq,
    company_id_seq, device_id_seq, contact_device_contact_id_seq, contact_device_device_id_seq to test;