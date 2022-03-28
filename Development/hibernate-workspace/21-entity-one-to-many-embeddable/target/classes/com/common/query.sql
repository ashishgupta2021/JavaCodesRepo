Hibernate: create table hibernate_sequence (next_val bigint) engine=InnoDB
Hibernate: insert into hibernate_sequence values ( 1 )
Hibernate: insert into hibernate_sequence values ( 1 )
Hibernate: create table Shipment (id bigint not null, createdOn datetime(6), DELIVERY_ADDRESS_USER_ID bigint not null, primary key (id)) engine=InnoDB
Hibernate: create table USERS (id bigint not null, city varchar(255) not null, street varchar(255) not null, zipcode varchar(5) not null, username varchar(255), primary key (id)) engine=InnoDB
Hibernate: alter table Shipment add constraint FKo4y0s4rll0nyptu0vrhqeggfi foreign key (DELIVERY_ADDRESS_USER_ID) references USERS (id)


/*	User And Shipment Record insertion	*/
Hibernate: select next_val as id_val from hibernate_sequence for update
Hibernate: update hibernate_sequence set next_val= ? where next_val=?
Hibernate: select next_val as id_val from hibernate_sequence for update
Hibernate: update hibernate_sequence set next_val= ? where next_val=?
Hibernate: select next_val as id_val from hibernate_sequence for update
Hibernate: update hibernate_sequence set next_val= ? where next_val=?
Hibernate: insert into USERS (city, street, zipcode, username, id) values (?, ?, ?, ?, ?)
Hibernate: insert into Shipment (createdOn, DELIVERY_ADDRESS_USER_ID, id) values (?, ?, ?)
Hibernate: insert into Shipment (createdOn, DELIVERY_ADDRESS_USER_ID, id) values (?, ?, ?)
Hibernate: update Shipment set DELIVERY_ADDRESS_USER_ID=? where id=?
Hibernate: update Shipment set DELIVERY_ADDRESS_USER_ID=? where id=?


mysql> select * from USERS;
+----+-----------+-------------+---------+----------+
| id | city      | street      | zipcode | username |
+----+-----------+-------------+---------+----------+
|  1 | Some City | Some Street | 12345   | johndoe  |
+----+-----------+-------------+---------+----------+
1 row in set (0.00 sec)

mysql> select * from shipment;
+----+----------------------------+--------------------------+
| id | createdOn                  | DELIVERY_ADDRESS_USER_ID |
+----+----------------------------+--------------------------+
|  2 | 2020-03-08 14:40:20.695000 |                        1 |
|  3 | 2020-03-08 14:40:20.700000 |                        1 |
+----+----------------------------+--------------------------+
2 rows in set (0.00 sec)