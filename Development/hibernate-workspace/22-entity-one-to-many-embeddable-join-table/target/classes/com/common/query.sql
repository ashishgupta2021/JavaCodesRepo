Hibernate: create table DELIVERIES (USER_ID bigint not null, SHIPMENT_ID bigint not null, primary key (USER_ID, SHIPMENT_ID)) engine=InnoDB
Hibernate: create table hibernate_sequence (next_val bigint) engine=InnoDB
Hibernate: insert into hibernate_sequence values ( 1 )
Hibernate: insert into hibernate_sequence values ( 1 )
Hibernate: create table Shipment (id bigint not null, createdOn datetime(6), primary key (id)) engine=InnoDB
Hibernate: create table USERS (id bigint not null, city varchar(255) not null, street varchar(255) not null, zipcode varchar(5) not null, username varchar(255), primary key (id)) engine=InnoDB
Hibernate: alter table DELIVERIES drop index UK_fxswa09pd9xluirye4yo4ptip
Hibernate: alter table DELIVERIES add constraint UK_fxswa09pd9xluirye4yo4ptip unique (SHIPMENT_ID)
Hibernate: alter table DELIVERIES add constraint FKtblkdrxvth5ewvq1nabv58eaj foreign key (SHIPMENT_ID) references Shipment (id)
Hibernate: alter table DELIVERIES add constraint FKbckadabbr4k74si2gcr3an51n foreign key (USER_ID) references USERS (id)

/*	User, Shipment and DELIVERIES Record insertion	*/
Hibernate: select next_val as id_val from hibernate_sequence for update
Hibernate: update hibernate_sequence set next_val= ? where next_val=?
Hibernate: select next_val as id_val from hibernate_sequence for update
Hibernate: update hibernate_sequence set next_val= ? where next_val=?
Hibernate: select next_val as id_val from hibernate_sequence for update
Hibernate: update hibernate_sequence set next_val= ? where next_val=?
Hibernate: insert into USERS (city, street, zipcode, username, id) values (?, ?, ?, ?, ?)
Hibernate: insert into Shipment (createdOn, id) values (?, ?)
Hibernate: insert into Shipment (createdOn, id) values (?, ?)
Hibernate: insert into DELIVERIES (USER_ID, SHIPMENT_ID) values (?, ?)
Hibernate: insert into DELIVERIES (USER_ID, SHIPMENT_ID) values (?, ?)

how tables;
+----------------------------------------------------+
| Tables_in_entity_one_to_many_embeddable_join_table |
+----------------------------------------------------+
| DELIVERIES                                         |
| Shipment                                           |
| USERS                                              |
| hibernate_sequence                                 |
+----------------------------------------------------+
4 rows in set (0.00 sec)

mysql> select * from USERS;
+----+-----------+-------------+---------+----------+
| id | city      | street      | zipcode | username |
+----+-----------+-------------+---------+----------+
|  1 | Some City | Some Street | 12345   | johndoe  |
+----+-----------+-------------+---------+----------+
1 row in set (0.00 sec)

mysql> select * from Shipment;
+----+----------------------------+
| id | createdOn                  |
+----+----------------------------+
|  2 | 2020-03-08 15:09:28.507000 |
|  3 | 2020-03-08 15:09:28.511000 |
+----+----------------------------+
2 rows in set (0.00 sec)

mysql> select * from DELIVERIES;
+---------+-------------+
| USER_ID | SHIPMENT_ID |
+---------+-------------+
|       1 |           2 |
|       1 |           3 |
+---------+-------------+
2 rows in set (0.00 sec)