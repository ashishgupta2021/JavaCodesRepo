Hibernate: create table Address (id bigint not null, city varchar(255), street varchar(255), zipcode varchar(255), primary key (id)) engine=InnoDB
Hibernate: create table hibernate_sequence (next_val bigint) engine=InnoDB
Hibernate: insert into hibernate_sequence values ( 1 )
Hibernate: create table users (id bigint not null, firstName varchar(255), lastName varchar(255), userName varchar(255), primary key (id)) engine=InnoDB
Hibernate: alter table Address add constraint FKaswhhuagrmjec39ox2weu4fae foreign key (id) references users (id)


/*	User and Address Record insertion	*/
Hibernate: select next_val as id_val from hibernate_sequence for update
Hibernate: update hibernate_sequence set next_val= ? where next_val=?
Hibernate: insert into users (firstName, lastName, userName, id) values (?, ?, ?, ?)
Hibernate: insert into Address (city, street, zipcode, id) values (?, ?, ?, ?)


/*	from User	*/

Hibernate: select user0_.id as id1_1_, user0_.firstName as firstNam2_1_, user0_.lastName as lastName3_1_, user0_.userName as userName4_1_ from users user0_
Hibernate: select address0_.id as id1_0_0_, address0_.city as city2_0_0_, address0_.street as street3_0_0_, address0_.zipcode as zipcode4_0_0_, user1_.id as id1_1_1_, user1_.firstName as firstNam2_1_1_, user1_.lastName as lastName3_1_1_, user1_.userName as userName4_1_1_ from Address address0_ inner join users user1_ on address0_.id=user1_.id where address0_.id=?
listUser :[User [id=1, shippingAddress=Address [id=1, street=Some Street 123, zipcode=560023, city=Bangalore], userName=ashish_kumar, firstName=Ashish, lastName=Gupta]]


mysql> select * from users;
+----+-----------+----------+--------------+
| id | firstName | lastName | userName     |
+----+-----------+----------+--------------+
|  1 | Ashish    | Gupta    | ashish_kumar |
+----+-----------+----------+--------------+
1 row in set (0.00 sec)

mysql> select * from Address;
+----+-----------+-----------------+---------+
| id | city      | street          | zipcode |
+----+-----------+-----------------+---------+
|  1 | Bangalore | Some Street 123 | 560023  |
+----+-----------+-----------------+---------+
1 row in set (0.00 sec)

mysql> select * from hibernate_sequence;
+----------+
| next_val |
+----------+
|        2 |
+----------+
1 row in set (0.00 sec)
