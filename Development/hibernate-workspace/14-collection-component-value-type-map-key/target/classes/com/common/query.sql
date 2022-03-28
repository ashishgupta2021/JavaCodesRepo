Hibernate: create table hibernate_sequence (next_val bigint) engine=InnoDB
Hibernate: insert into hibernate_sequence values ( 1 )
Hibernate: create table IMAGE (Item_id bigint not null, height integer not null, title varchar(255), width integer not null, extension varchar(255) not null, name varchar(255) not null, primary key (Item_id, extension, name)) engine=InnoDB
Hibernate: create table Item (id bigint not null, name varchar(255), primary key (id)) engine=InnoDB
Hibernate: alter table IMAGE add constraint FKfmjenilsjv7utxi4500ytgc5j foreign key (Item_id) references Item (id)

-- Insert 

Hibernate: select next_val as id_val from hibernate_sequence for update
Hibernate: update hibernate_sequence set next_val= ? where next_val=?
Hibernate: insert into Item (name, id) values (?, ?)
Hibernate: insert into IMAGE (Item_id, extension, name, height, title, width) values (?, ?, ?, ?, ?, ?)
Hibernate: insert into IMAGE (Item_id, extension, name, height, title, width) values (?, ?, ?, ?, ?, ?)

-- Select

Hibernate: select item0_.id as id1_1_, item0_.name as name2_1_ from Item item0_
Hibernate: select images0_.Item_id as Item_id1_0_0_, images0_.height as height2_0_0_, images0_.title as title3_0_0_, images0_.width as width4_0_0_, images0_.FILENAME as FILENAME5_0_ from IMAGE images0_ where images0_.Item_id=?
listItem :[Item [id=1, images={foo.jpg=Image [title=Foo, width=40, height=20], boo.jpg=Image [title=Boo, width=70, height=30]}]]
