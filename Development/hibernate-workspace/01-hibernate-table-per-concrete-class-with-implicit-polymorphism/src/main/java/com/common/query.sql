-- Table Creation (One time) 
Hibernate: create table BankAccount (id bigint not null, owner varchar(255), account varchar(255), bankName varchar(255), primary key (id)) engine=InnoDB
Hibernate: create table CreditCard (id bigint not null, CC_OWNER varchar(255) not null, cardNumber varchar(255), expMonth varchar(255), primary key (id)) engine=InnoDB

/*
 * Credit Card
*/

-- Insert Record
Hibernate: insert into CreditCard (CC_OWNER, cardNumber, expMonth, id) values (?, ?, ?, ?)

-- Select All 
Hibernate: 
	select 
		creditcard0_.id as id1_1_, 
		creditcard0_.CC_OWNER as CC_OWNER2_1_, 
		creditcard0_.cardNumber as cardNumb3_1_, 
		creditcard0_.expMonth as expMonth4_1_ 
	from 
		CreditCard creditcard0_

-- Data
--[CreditCard [id=1, cardNumber=123456789, expMonth=04/10/2019]]
--[CreditCard [id=1, cardNumber=123456789, expMonth=04/10/2019]]

-- update ( for update, hibernate runs select first and then update)
Hibernate: 
	select 
		creditcard0_.id as id1_1_0_, 
		creditcard0_.CC_OWNER as CC_OWNER2_1_0_, 
		creditcard0_.cardNumber as cardNumb3_1_0_, 
		creditcard0_.expMonth as expMonth4_1_0_ 
	from 
		CreditCard creditcard0_ 
	where creditcard0_.id=?
Hibernate: 
	update CreditCard 
		set CC_OWNER=?, cardNumber=?, expMonth=? 
	where id=?
	
	
/*
 * Bank Account
*/
	
-- Insert Record

Hibernate: insert into BankAccount (owner, account, bankName, id) values (?, ?, ?, ?)

-- Select Record

Hibernate: 
select bankaccoun0_.id as id1_0_, bankaccoun0_.owner as owner2_0_, bankaccoun0_.account as account3_0_, bankaccoun0_.bankName as bankName4_0_ from BankAccount bankaccoun0_

[BankAccount [id=1, account=123, bankName=PNB]]

-- Update Record

Hibernate: select bankaccoun0_.id as id1_0_0_, bankaccoun0_.owner as owner2_0_0_, bankaccoun0_.account as account3_0_0_, bankaccoun0_.bankName as bankName4_0_0_ from BankAccount bankaccoun0_ where bankaccoun0_.id=?
Hibernate: update BankAccount set owner=?, account=?, bankName=? where id=?





