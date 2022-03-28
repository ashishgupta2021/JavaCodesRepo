Hibernate: create table Bid (id bigint not null, amount decimal(19,2), ITEM_ID bigint, BID_POSITION integer not null, primary key (id)) engine=InnoDB
Hibernate: create table hibernate_sequence (next_val bigint) engine=InnoDB
Hibernate: insert into hibernate_sequence values ( 1 )
Hibernate: insert into hibernate_sequence values ( 1 )
Hibernate: create table Item (id bigint not null, name varchar(255), primary key (id)) engine=InnoDB
Hibernate: alter table Bid add constraint FK884gyguvo3jcbca0v78w95l3k foreign key (ITEM_ID) references Item (id)

/*	Item And Bid Record insertion	*/
Hibernate: select next_val as id_val from hibernate_sequence for update
Hibernate: update hibernate_sequence set next_val= ? where next_val=?
Hibernate: select next_val as id_val from hibernate_sequence for update
Hibernate: update hibernate_sequence set next_val= ? where next_val=?

Hibernate: insert into Item (name, id) values (?, ?)
Hibernate: insert into Bid (amount, ITEM_ID, BID_POSITION, id) values (?, ?, ?, ?)
Hibernate: update Bid set ITEM_ID=?, BID_POSITION=? where id=?
Hibernate: update Bid set ITEM_ID=?, BID_POSITION=? where id=?

mysql> select * from Item;
+----+-----------+
| id | name      |
+----+-----------+
|  1 | Some Item |
+----+-----------+
1 row in set (0.00 sec)

mysql> select * from Bid;
+----+--------+---------+--------------+
| id | amount | ITEM_ID | BID_POSITION |
+----+--------+---------+--------------+
|  2 | 123.00 |       1 |            1 |
+----+--------+---------+--------------+
1 row in set (0.00 sec)

mysql> select * from hibernate_sequence;
+----------+
| next_val |
+----------+
|        3 |
|        3 |
+----------+
2 rows in set (0.00 sec)

