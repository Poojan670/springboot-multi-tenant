CREATE TABLE if not exists public.tenant_tenant (
	id bigint PRIMARY KEY,
	driverclassname VARCHAR(255),
	url VARCHAR(255),
	name VARCHAR(255),
	username VARCHAR(255),
	password VARCHAR(255),
	initialize BOOLEAN
);
INSERT INTO tenant_tenant VALUES (1, 'org.postgresql.Driver', 'jdbc:postgresql://localhost:5432/test?currentSchema=test1&ApplicationName=MultiTenant', 'test1', 'postgres', 'poojan12', true);
INSERT INTO tenant_tenant VALUES (2, 'org.postgresql.Driver', 'jdbc:postgresql://localhost:5432/test?currentSchema=test2&ApplicationName=MultiTenant', 'test2', 'postgres', 'poojan12', true);

create schema if not exists test1;
create schema if not exists test2;
create table test1.city(id bigint, name varchar(200));
create table test2.city(id bigint, name varchar(200));

create table test1.document(id bigint, title varchar(200), description varchar(255));
create table test2.document(id bigint, title varchar(200), description varchar(255));

CREATE SEQUENCE "test1".hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
CREATE SEQUENCE "test2".hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
