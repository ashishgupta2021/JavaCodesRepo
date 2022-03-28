Hibernate: create table hibernate_sequence (next_val bigint) engine=InnoDB
Hibernate: insert into hibernate_sequence values ( 1 )
Hibernate: insert into hibernate_sequence values ( 1 )
Hibernate: create table Item (id bigint not null, name varchar(255), primary key (id)) engine=InnoDB
Hibernate: create table ITEM_BUYER (buyer_id bigint, ITEM_ID bigint not null, primary key (ITEM_ID)) engine=InnoDB
Hibernate: create table USERS (id bigint not null, username varchar(255), primary key (id)) engine=InnoDB
Hibernate: alter table ITEM_BUYER add constraint FKkiwjbexyym0xtm5yvh1i3hfpr foreign key (buyer_id) references USERS (id)
Hibernate: alter table ITEM_BUYER add constraint FKq7f4kgui70ruuv946j45nt74r foreign key (ITEM_ID) references Item (id)

/*	User And Item Record insertion	*/
Hibernate: select next_val as id_val from hibernate_sequence for update
Hibernate: update hibernate_sequence set next_val= ? where next_val=?
Hibernate: select next_val as id_val from hibernate_sequence for update
Hibernate: update hibernate_sequence set next_val= ? where next_val=?
Hibernate: select next_val as id_val from hibernate_sequence for update
Hibernate: update hibernate_sequence set next_val= ? where next_val=?
Hibernate: select next_val as id_val from hibernate_sequence for update
Hibernate: update hibernate_sequence set next_val= ? where next_val=?
Hibernate: insert into USERS (username, id) values (?, ?)
Hibernate: insert into Item (name, id) values (?, ?)
Hibernate: insert into Item (name, id) values (?, ?)
Hibernate: insert into Item (name, id) values (?, ?)
Hibernate: insert into ITEM_BUYER (buyer_id, ITEM_ID) values (?, ?)
Hibernate: insert into ITEM_BUYER (buyer_id, ITEM_ID) values (?, ?)


mysql> select * from users;
+----+----------+
| id | username |
+----+----------+
|  1 | johndoe  |
+----+----------+
1 row in set (0.00 sec)

mysql> select * from item;
+----+-------------+
| id | name        |
+----+-------------+
|  2 | Some Item   |
|  3 | Other Item  |
|  4 | Unsold Item |
+----+-------------+
3 rows in set (0.00 sec)

mysql> select * from ITEM_BUYER;
+----------+---------+
| buyer_id | ITEM_ID |
+----------+---------+
|        1 |       2 |
|        1 |       3 |
+----------+---------+
2 rows in set (0.00 sec)