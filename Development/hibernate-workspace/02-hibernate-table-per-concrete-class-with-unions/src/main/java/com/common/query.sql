Hibernate: create table BankAccount (id bigint not null, owner varchar(255), account varchar(255), bankName varchar(255), primary key (id)) engine=InnoDB
Hibernate: create table CreditCard (id bigint not null, owner varchar(255), cardNumber varchar(255), expMonth varchar(255), primary key (id)) engine=InnoDB
Hibernate: create table hibernate_sequence (next_val bigint) engine=InnoDB
Hibernate: insert into hibernate_sequence values ( 1 )
-- Insert

Hibernate: select next_val as id_val from hibernate_sequence for update
Hibernate: update hibernate_sequence set next_val= ? where next_val=?
Hibernate: insert into CreditCard (owner, cardNumber, expMonth, id) values (?, ?, ?, ?)

-- Select entityManager.createQuery("from CreditCard")

Hibernate: select creditcard0_.id as id1_1_, creditcard0_.owner as owner2_1_, creditcard0_.cardNumber as cardNumb1_2_, creditcard0_.expMonth as expMonth2_2_ from CreditCard creditcard0_

[CreditCard [cardNumber=123456789, expMonth=04/10/2019]]

-- Update
Hibernate: select creditcard0_.id as id1_1_0_, creditcard0_.owner as owner2_1_0_, creditcard0_.cardNumber as cardNumb1_2_0_, creditcard0_.expMonth as expMonth2_2_0_ from CreditCard creditcard0_ where creditcard0_.id=?
Hibernate: update CreditCard set owner=?, cardNumber=?, expMonth=? where id=?


-- Select entityManager.createQuery("from BillingDetails")
Hibernate: 
	select 
		billingdet0_.id as id1_1_, 
		billingdet0_.owner as owner2_1_, 
		billingdet0_.account as account1_0_, 
		billingdet0_.bankName as bankName2_0_, 
		billingdet0_.cardNumber as cardNumb1_2_, 
		billingdet0_.expMonth as expMonth2_2_, 
		billingdet0_.clazz_ as clazz_ 
	from 
		( select 
				id, 
				owner, 
				account, 
				bankName, 
				null as cardNumber, 
				null as expMonth, 
				1 as clazz_ 
			from 
				BankAccount 
			union 
			select 
				id, 
				owner, 
				null as account, 
				null as bankName, 
				cardNumber, 
				expMonth, 
				2 as clazz_ 
			from 
				CreditCard ) billingdet0_

// Output 1 ( When only Credit Card table data available and not BankAccount Table data)
[CreditCard [cardNumber=123456789, expMonth=28Nov2019], CreditCard [cardNumber=123456789, expMonth=04/10/2019]]

// Output 2 ( When Both table data available)
[BankAccount [account=1234567, bankName=PNB], BankAccount [account=123, bankName=PNB], CreditCard [cardNumber=123456789, expMonth=28Nov2019], CreditCard [cardNumber=123456789, expMonth=04/10/2019]]

-- Bank Account

-- Insert 
Hibernate: select next_val as id_val from hibernate_sequence for update
Hibernate: update hibernate_sequence set next_val= ? where next_val=?
Hibernate: insert into BankAccount (owner, account, bankName, id) values (?, ?, ?, ?)

-- Select 

Hibernate: select bankaccoun0_.id as id1_1_, bankaccoun0_.owner as owner2_1_, bankaccoun0_.account as account1_0_, bankaccoun0_.bankName as bankName2_0_ from BankAccount bankaccoun0_

[BankAccount [account=123, bankName=PNB]]

Hibernate: select bankaccoun0_.id as id1_1_0_, bankaccoun0_.owner as owner2_1_0_, bankaccoun0_.account as account1_0_0_, bankaccoun0_.bankName as bankName2_0_0_ from BankAccount bankaccoun0_ where bankaccoun0_.id=?
Hibernate: update BankAccount set owner=?, account=?, bankName=? where id=?



