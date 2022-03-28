Hibernate: create table hibernate_sequence (next_val bigint) engine=InnoDB
Hibernate: insert into hibernate_sequence values ( 1 )
Hibernate: create table IMAGE (Item_id bigint not null, filename varchar(255) not null, height integer not null, title varchar(255) not null, width integer not null, primary key (Item_id, filename, height, title, width)) engine=InnoDB
Hibernate: create table Item (id bigint not null, name varchar(255), primary key (id)) engine=InnoDB
Hibernate: alter table IMAGE add constraint FKfmjenilsjv7utxi4500ytgc5j foreign key (Item_id) references Item (id)

-- Insert 

Hibernate: select next_val as id_val from hibernate_sequence for update
Hibernate: update hibernate_sequence set next_val= ? where next_val=?
Hibernate: insert into Item (name, id) values (?, ?)
Hibernate: insert into IMAGE (Item_id, filename, height, title, width) values (?, ?, ?, ?, ?)
Hibernate: insert into IMAGE (Item_id, filename, height, title, width) values (?, ?, ?, ?, ?)

-- Select

Hibernate: select item0_.id as id1_1_, item0_.name as name2_1_ from Item item0_
Hibernate: select images0_.Item_id as Item_id1_0_0_, images0_.filename as filename2_0_0_, images0_.height as height3_0_0_, images0_.title as title4_0_0_, images0_.width as width5_0_0_ from IMAGE images0_ where images0_.Item_id=?
listItem :[Item [id=1, images=[Image [title=Foo, filename=foo.jpg, width=40, height=20], Image [title=Boo, filename=boo.jpg, width=70, height=30]]]]
