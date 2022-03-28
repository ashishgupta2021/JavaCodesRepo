Hibernate: create table Address (id bigint not null, city varchar(255), street varchar(255), zipcode varchar(255), primary key (id)) engine=InnoDB
Hibernate: create table hibernate_sequence (next_val bigint) engine=InnoDB
Hibernate: insert into hibernate_sequence values ( 1 )
Hibernate: insert into hibernate_sequence values ( 1 )
Hibernate: create table users (id bigint not null, firstName varchar(255), lastName varchar(255), userName varchar(255), shippingAddress_id bigint not null, primary key (id)) engine=InnoDB
Hibernate: alter table users drop index UK_80jj07wxn5sa1vrwkfsyl1pw3
Hibernate: alter table users add constraint UK_80jj07wxn5sa1vrwkfsyl1pw3 unique (shippingAddress_id)
Hibernate: alter table users add constraint FKb7s4ovspn8vpltuanxuytbl0b foreign key (shippingAddress_id) references Address (id)


/*	User and Address Record insertion	*/
ibernate: select next_val as id_val from hibernate_sequence for update
Hibernate: update hibernate_sequence set next_val= ? where next_val=?
Hibernate: select next_val as id_val from hibernate_sequence for update
Hibernate: update hibernate_sequence set next_val= ? where next_val=?
Hibernate: insert into Address (city, street, zipcode, id) values (?, ?, ?, ?)
Hibernate: insert into users (firstName, lastName, shippingAddress_id, userName, id) values (?, ?, ?, ?, ?)


mysql> select * from users;
+----+-----------+----------+--------------+--------------------+
| id | firstName | lastName | userName     | shippingAddress_id |
+----+-----------+----------+--------------+--------------------+
|  1 | Ashish    | Gupta    | ashish_kumar |                  2 |
+----+-----------+----------+--------------+--------------------+
1 row in set (0.00 sec)

mysql> select * from Address;
+----+-----------+-----------------+---------+
| id | city      | street          | zipcode |
+----+-----------+-----------------+---------+
|  2 | Bangalore | Some Street 123 | 560023  |
+----+-----------+-----------------+---------+
1 row in set (0.00 sec)

mysql> select * from users u, Address a where u.shippingAddress_id = a.id;
+----+-----------+----------+--------------+--------------------+----+-----------+-----------------+---------+
| id | firstName | lastName | userName     | shippingAddress_id | id | city      | street          | zipcode |
+----+-----------+----------+--------------+--------------------+----+-----------+-----------------+---------+
|  1 | Ashish    | Gupta    | ashish_kumar |                  2 |  2 | Bangalore | Some Street 123 | 560023  |
+----+-----------+----------+--------------+--------------------+----+-----------+-----------------+---------+
1 row in set (0.00 sec)
