Hibernate: create table hibernate_sequence (next_val bigint) engine=InnoDB
Hibernate: insert into hibernate_sequence values ( 1 )
Hibernate: create table IMAGE (Item_id bigint not null, filename varchar(255) not null, height integer not null, title varchar(255), width integer not null, IMAGE_ID bigint not null, primary key (IMAGE_ID)) engine=InnoDB
Hibernate: create table Item (id bigint not null, name varchar(255), primary key (id)) engine=InnoDB
Hibernate: alter table IMAGE add constraint FKfmjenilsjv7utxi4500ytgc5j foreign key (Item_id) references Item (id)
-- Insert 

Hibernate: select next_val as id_val from hibernate_sequence for update
Hibernate: update hibernate_sequence set next_val= ? where next_val=?
Hibernate: insert into Item (name, id) values (?, ?)
Hibernate: select max(IMAGE_ID) from IMAGE
Hibernate: insert into IMAGE (Item_id, IMAGE_ID, filename, height, title, width) values (?, ?, ?, ?, ?, ?)
Hibernate: insert into IMAGE (Item_id, IMAGE_ID, filename, height, title, width) values (?, ?, ?, ?, ?, ?)

-- Select

Hibernate: select item0_.id as id1_1_, item0_.name as name2_1_ from Item item0_
listItem :[Item [id=1, images=org.hibernate.collection.internal.PersistentIdentifierBag@642857e0]]

