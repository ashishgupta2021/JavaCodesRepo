Hibernate: create table BankAccount (account varchar(255), bankName varchar(255), id bigint not null, primary key (id)) engine=InnoDB
Hibernate: create table BillingDetails (id bigint not null, owner varchar(255), primary key (id)) engine=InnoDB
Hibernate: create table CreditCard (cardNumber varchar(255), expMonth varchar(255), CREDITCARD_ID bigint not null, primary key (CREDITCARD_ID)) engine=InnoDB
Hibernate: create table hibernate_sequence (next_val bigint) engine=InnoDB
Hibernate: insert into hibernate_sequence values ( 1 )
Hibernate: alter table BankAccount add constraint FKcuq00ydxwbbq1oi96e47j3l4h foreign key (id) references BillingDetails (id)
Hibernate: alter table CreditCard add constraint FK4xfp670ae6dtwgnw7jilkxit7 foreign key (CREDITCARD_ID) references BillingDetails (id)

-- Insert into CreditCard

Hibernate: select next_val as id_val from hibernate_sequence for update
Hibernate: update hibernate_sequence set next_val= ? where next_val=?
Hibernate: insert into BillingDetails (owner, id) values (?, ?)
Hibernate: insert into CreditCard (cardNumber, expMonth, CREDITCARD_ID) values (?, ?, ?)

-- Select ( from CreditCard)

Hibernate: select creditcard0_.CREDITCARD_ID as id1_1_, creditcard0_1_.owner as owner2_1_, creditcard0_.cardNumber as cardNumb1_2_, creditcard0_.expMonth as expMonth2_2_ from CreditCard creditcard0_ inner join BillingDetails creditcard0_1_ on creditcard0_.CREDITCARD_ID=creditcard0_1_.id

[CreditCard [cardNumber=123456789, expMonth=04/10/2019]]

-- Update (CreditCard)

Hibernate: select creditcard0_.CREDITCARD_ID as id1_1_0_, creditcard0_1_.owner as owner2_1_0_, creditcard0_.cardNumber as cardNumb1_2_0_, creditcard0_.expMonth as expMonth2_2_0_ from CreditCard creditcard0_ inner join BillingDetails creditcard0_1_ on creditcard0_.CREDITCARD_ID=creditcard0_1_.id where creditcard0_.CREDITCARD_ID=?
Hibernate: update CreditCard set cardNumber=?, expMonth=? where CREDITCARD_ID=?

-- BankAccount

-- Insert
Hibernate: select next_val as id_val from hibernate_sequence for update
Hibernate: update hibernate_sequence set next_val= ? where next_val=?
Hibernate: insert into BillingDetails (owner, id) values (?, ?)
Hibernate: insert into BankAccount (account, bankName, id) values (?, ?, ?)

-- Select 

Hibernate: select bankaccoun0_.id as id1_1_, bankaccoun0_1_.owner as owner2_1_, bankaccoun0_.account as account1_0_, bankaccoun0_.bankName as bankName2_0_ from BankAccount bankaccoun0_ inner join BillingDetails bankaccoun0_1_ on bankaccoun0_.id=bankaccoun0_1_.id

[BankAccount [account=123, bankName=PNB]]

-- UPdate

Hibernate: select bankaccoun0_.id as id1_1_0_, bankaccoun0_1_.owner as owner2_1_0_, bankaccoun0_.account as account1_0_0_, bankaccoun0_.bankName as bankName2_0_0_ from BankAccount bankaccoun0_ inner join BillingDetails bankaccoun0_1_ on bankaccoun0_.id=bankaccoun0_1_.id where bankaccoun0_.id=?
Hibernate: update BankAccount set account=?, bankName=? where id=?


-- BillingDetails

-- Select ( from BillingDetails )

Hibernate: select billingdet0_.id as id1_1_, billingdet0_.owner as owner2_1_, billingdet0_1_.account as account1_0_, billingdet0_1_.bankName as bankName2_0_, billingdet0_2_.cardNumber as cardNumb1_2_, billingdet0_2_.expMonth as expMonth2_2_, case when billingdet0_1_.id is not null then 1 when billingdet0_2_.CREDITCARD_ID is not null then 2 when billingdet0_.id is not null then 0 end as clazz_ from BillingDetails billingdet0_ left outer join BankAccount billingdet0_1_ on billingdet0_.id=billingdet0_1_.id left outer join CreditCard billingdet0_2_ on billingdet0_.id=billingdet0_2_.CREDITCARD_ID
[CreditCard [cardNumber=123456789, expMonth=28Nov2019], BankAccount [account=123, bankName=PNB], BankAccount [account=1234567, bankName=PNB]]


