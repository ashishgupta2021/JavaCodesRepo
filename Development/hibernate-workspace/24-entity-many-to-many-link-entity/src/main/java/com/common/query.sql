Hibernate: create table Category (id bigint not null, name varchar(255), primary key (id)) engine=InnoDB
Hibernate: create table CATEGORY_ITEM (CATEGORY_ID bigint not null, ITEM_ID bigint not null, addedBy varchar(255), addedOn datetime(6), primary key (CATEGORY_ID, ITEM_ID)) engine=InnoDB
Hibernate: create table hibernate_sequence (next_val bigint) engine=InnoDB
Hibernate: insert into hibernate_sequence values ( 1 )
Hibernate: insert into hibernate_sequence values ( 1 )
Hibernate: create table Item (id bigint not null, name varchar(255), primary key (id)) engine=InnoDB
Hibernate: alter table CATEGORY_ITEM add constraint FKjip0or3vemixccl6vx0kluj03 foreign key (CATEGORY_ID) references Category (id)
Hibernate: alter table CATEGORY_ITEM add constraint FKf1uerpnmn49vl1spbbplgxaun foreign key (ITEM_ID) references Item (id)

/*	Category , Item & Category_Item Record insertion	*/

Hibernate: select next_val as id_val from hibernate_sequence for update
Hibernate: update hibernate_sequence set next_val= ? where next_val=?
Hibernate: select next_val as id_val from hibernate_sequence for update
Hibernate: update hibernate_sequence set next_val= ? where next_val=?
Hibernate: select next_val as id_val from hibernate_sequence for update
Hibernate: update hibernate_sequence set next_val= ? where next_val=?
Hibernate: select next_val as id_val from hibernate_sequence for update
Hibernate: update hibernate_sequence set next_val= ? where next_val=?
Hibernate: insert into Category (name, id) values (?, ?)
Hibernate: insert into Category (name, id) values (?, ?)
Hibernate: insert into Item (name, id) values (?, ?)
Hibernate: insert into Item (name, id) values (?, ?)
Hibernate: insert into CATEGORY_ITEM (addedBy, addedOn, CATEGORY_ID, ITEM_ID) values (?, ?, ?, ?)
Hibernate: insert into CATEGORY_ITEM (addedBy, addedOn, CATEGORY_ID, ITEM_ID) values (?, ?, ?, ?)
Hibernate: insert into CATEGORY_ITEM (addedBy, addedOn, CATEGORY_ID, ITEM_ID) values (?, ?, ?, ?)

mysql> select * from Category;
+----+----------------+
| id | name           |
+----+----------------+
|  1 | Some Category  |
|  2 | Other Category |
+----+----------------+
2 rows in set (0.00 sec)

mysql> select * from Item;
+----+------------+
| id | name       |
+----+------------+
|  3 | Some Item  |
|  4 | Other Item |
+----+------------+
2 rows in set (0.00 sec)

mysql> select * from Category_Item;
+-------------+---------+---------+----------------------------+
| CATEGORY_ID | ITEM_ID | addedBy | addedOn                    |
+-------------+---------+---------+----------------------------+
|           1 |       3 | johndoe | 2020-03-08 17:59:53.505000 |
|           1 |       4 | johndoe | 2020-03-08 17:59:53.505000 |
|           2 |       3 | johndoe | 2020-03-08 17:59:53.505000 |
+-------------+---------+---------+----------------------------+
3 rows in set (0.00 sec)

mysql> select * from HIBERNATE_SEQUENCE;
+----------+
| next_val |
+----------+
|        5 |
|        5 |
+----------+
2 rows in set (0.00 sec)