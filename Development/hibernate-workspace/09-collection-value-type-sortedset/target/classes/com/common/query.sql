Hibernate: create table hibernate_sequence (next_val bigint) engine=InnoDB
Hibernate: insert into hibernate_sequence values ( 1 )
Hibernate: create table IMAGE (Item_id bigint not null, FILENAME varchar(255)) engine=InnoDB
Hibernate: create table Item (id bigint not null, name varchar(255), primary key (id)) engine=InnoDB
Hibernate: alter table IMAGE add constraint FKfmjenilsjv7utxi4500ytgc5j foreign key (Item_id) references Item (id)

-- Insert 
Hibernate: select next_val as id_val from hibernate_sequence for update
Hibernate: update hibernate_sequence set next_val= ? where next_val=?
Hibernate: insert into Item (name, id) values (?, ?)
Hibernate: insert into IMAGE (Item_id, FILENAME) values (?, ?)
Hibernate: insert into IMAGE (Item_id, FILENAME) values (?, ?)

-- Select
Hibernate: select item0_.id as id1_1_, item0_.name as name2_1_ from Item item0_
Hibernate: select images0_.Item_id as Item_id1_0_0_, images0_.FILENAME as FILENAME2_0_0_ from IMAGE images0_ where images0_.Item_id=?
listItem :[Item [id=1, images=[bar.jpg, foo.jpg]]]
