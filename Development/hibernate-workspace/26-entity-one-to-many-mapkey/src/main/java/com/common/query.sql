Hibernate: create table Bid (id bigint not null, amount decimal(19,2), item_id bigint, primary key (id)) engine=InnoDB
Hibernate: create table hibernate_sequence (next_val bigint) engine=InnoDB
Hibernate: insert into hibernate_sequence values ( 1 )
Hibernate: insert into hibernate_sequence values ( 1 )
Hibernate: create table Item (id bigint not null, name varchar(255), primary key (id)) engine=InnoDB
Hibernate: alter table Bid add constraint FKofartcioobwpek3qex4cmturt foreign key (item_id) references Item (id)


/*	User, Category , Item & Category_Item Record insertion	*/

Hibernate: select next_val as id_val from hibernate_sequence for update
Hibernate: update hibernate_sequence set next_val= ? where next_val=?
Hibernate: select next_val as id_val from hibernate_sequence for update
Hibernate: update hibernate_sequence set next_val= ? where next_val=?
Hibernate: select next_val as id_val from hibernate_sequence for update
Hibernate: update hibernate_sequence set next_val= ? where next_val=?

Hibernate: insert into Item (name, id) values (?, ?)
Hibernate: insert into Bid (amount, item_id, id) values (?, ?, ?)
Hibernate: insert into Bid (amount, item_id, id) values (?, ?, ?)


mysql> select * from Item;
+----+-----------+
| id | name      |
+----+-----------+
|  1 | Some Item |
+----+-----------+
1 row in set (0.00 sec)

mysql> select * from Bid;
+----+--------+---------+
| id | amount | item_id |
+----+--------+---------+
|  2 | 123.00 |       1 |
|  3 | 456.00 |       1 |
+----+--------+---------+
2 rows in set (0.00 sec)