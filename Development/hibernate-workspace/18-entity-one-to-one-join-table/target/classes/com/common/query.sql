Hibernate: create table hibernate_sequence (next_val bigint) engine=InnoDB
Hibernate: insert into hibernate_sequence values ( 1 )
Hibernate: insert into hibernate_sequence values ( 1 )
Hibernate: create table Item (id bigint not null, name varchar(255), primary key (id)) engine=InnoDB
Hibernate: create table ITEM_SHIPMENT (ITEM_ID bigint not null, SHIPMENT_ID bigint not null, primary key (SHIPMENT_ID)) engine=InnoDB
Hibernate: create table Shipment (id bigint not null, primary key (id)) engine=InnoDB
Hibernate: alter table ITEM_SHIPMENT drop index UK_ew9cirvgsiaohxf5nnvfbos2v
Hibernate: alter table ITEM_SHIPMENT add constraint UK_ew9cirvgsiaohxf5nnvfbos2v unique (ITEM_ID)
Hibernate: alter table ITEM_SHIPMENT add constraint FKjskmu51vb8q2s152jr64hlvis foreign key (ITEM_ID) references Item (id)
Hibernate: alter table ITEM_SHIPMENT add constraint FK534c2vtma52l0uapjbk6u5njp foreign key (SHIPMENT_ID) references Shipment (id)


/*	Item And Shipment Record insertion	*/
Hibernate: select next_val as id_val from hibernate_sequence for update
Hibernate: update hibernate_sequence set next_val= ? where next_val=?
Hibernate: select next_val as id_val from hibernate_sequence for update
Hibernate: update hibernate_sequence set next_val= ? where next_val=?
org.hibernate.engine.transaction.internal.TransactionImpl@526b2f3e
Hibernate: insert into Item (name, id) values (?, ?)
Hibernate: insert into Shipment (id) values (?)
Hibernate: insert into ITEM_SHIPMENT (ITEM_ID, SHIPMENT_ID) values (?, ?)


mysql> select * from Item;
+----+-----------+
| id | name      |
+----+-----------+
|  1 | Some Item |
+----+-----------+
1 row in set (0.00 sec)

mysql> select * from Shipment;
+----+
| id |
+----+
|  2 |
+----+
1 row in set (0.00 sec)

mysql> select * from Item_Shipment;
+---------+-------------+
| ITEM_ID | SHIPMENT_ID |
+---------+-------------+
|       1 |           2 |
+---------+-------------+
1 row in set (0.00 sec)
