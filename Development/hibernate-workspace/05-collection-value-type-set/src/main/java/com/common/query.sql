Hibernate: create table hibernate_sequence (next_val bigint) engine=InnoDB
Hibernate: insert into hibernate_sequence values ( 1 )
Hibernate: create table IMAGE (ITEM_ID bigint not null, FILENAME varchar(255)) engine=InnoDB
Hibernate: create table Item (id bigint not null, name varchar(255), primary key (id)) engine=InnoDB
Hibernate: alter table IMAGE add constraint FK81w867q86d41yp2romymdpbvi foreign key (ITEM_ID) references Item (id)

-- Insert 

Hibernate: select next_val as id_val from hibernate_sequence for update
Hibernate: update hibernate_sequence set next_val= ? where next_val=?
Hibernate: insert into Item (name, id) values (?, ?)
Hibernate: insert into IMAGE (ITEM_ID, FILENAME) values (?, ?)
Hibernate: insert into IMAGE (ITEM_ID, FILENAME) values (?, ?)

-- Select ( When only 1 record present in Item)
/*mysql> select * from Item;
+----+------+
| id | name |
+----+------+
|  1 | FOO  |
+----+------+
1 row in set (0.00 sec)
*/

Hibernate: select item0_.id as id1_1_, item0_.name as name2_1_ from Item item0_
Hibernate: select images0_.ITEM_ID as ITEM_ID1_0_0_, images0_.FILENAME as FILENAME2_0_0_ from IMAGE images0_ where images0_.ITEM_ID=?

listItem :[Item [id=1, images=[foo.jpg, bar.jpg]]]

-- Select (When 3 record present in Item)
/*
mysql> select * from Item;
+----+------+
| id | name |
+----+------+
|  1 | FOO  |
|  2 | BAR  |
|  3 | BAR2 |
+----+------+
3 rows in set (0.00 sec)
*/

Hibernate: select item0_.id as id1_1_, item0_.name as name2_1_ from Item item0_
Hibernate: select images0_.ITEM_ID as ITEM_ID1_0_0_, images0_.FILENAME as FILENAME2_0_0_ from IMAGE images0_ where images0_.ITEM_ID=?
Hibernate: select images0_.ITEM_ID as ITEM_ID1_0_0_, images0_.FILENAME as FILENAME2_0_0_ from IMAGE images0_ where images0_.ITEM_ID=?
Hibernate: select images0_.ITEM_ID as ITEM_ID1_0_0_, images0_.FILENAME as FILENAME2_0_0_ from IMAGE images0_ where images0_.ITEM_ID=?
listItem :[Item [id=1, images=[foo.jpg, bar.jpg]], Item [id=2, images=[foo.jpg, bar.jpg]], Item [id=3, images=[foo.jpg, bar.jpg]]]