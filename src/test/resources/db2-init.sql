create sequence produce_id_generator start with 10 increment by 1 no maxvalue no cycle cache 24;

create table PRODUCE (id int8 not null, name varchar(255), subname varchar(255), quantity int4 not null, primary key (id));

INSERT INTO PRODUCE (id, name, sub_name, quantity) VALUES (1, 'Apple', 'Granny Smith', 100);
INSERT INTO PRODUCE (id, name, sub_name, quantity) VALUES (2, 'Apple', 'Gala', 50);
INSERT INTO PRODUCE (id, name, sub_name, quantity) VALUES (3, 'Corn', 'Sweet', 1000);
INSERT INTO PRODUCE (id, name, sub_name, quantity) VALUES (4, 'Pineapple', '', 300);
INSERT INTO PRODUCE (id, name, sub_name, quantity) VALUES (5, 'Potato', 'Red', 500);