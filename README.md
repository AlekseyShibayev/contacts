# ContactsWeb
This project has been created to consolidate my skills in web programming.

In this project i used:
 
 master: Java, Spring Core, JDBC, PostgresQL, Servlets, JSP, Ajax, JSON, Log4j, JUnit, Mockito.
 
 master_v2: + Hibernate.

1. You will need to install programs.

I used Linux Mint 19.2. + IntelliJ IDEA + tomcat 7.

sudo apt-get purge openjdk*

sudo apt-get update

sudo apt-get install openjdk-8-jdk

sudo apt-get install maven

sudo apt-get install git

sudo apt-get install postgresql postgresql-contrib

Then clone contacts project to any folder and write:

git clone https://github.com/AlekseyShibayev/contacts

chmod a+x pathToCatalina..tomcat/bin/catalina.sh

2. You will need to do something with PostgresQL DB: open terminal and let write. 

sudo -i -u postgres

psql

create database contact_database ENCODING 'UTF-8';

\c contact_database;

Then use db/scripts.sql for creating db tables.
