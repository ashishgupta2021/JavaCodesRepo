Hibernate: create table BillingDetails (BD_TYPE varchar(31) not null, id bigint not null, owner varchar(255), account varchar(255), bankName varchar(255), cardNumber varchar(255), expMonth varchar(255), primary key (id)) engine=InnoDB
Hibernate: create table hibernate_sequence (next_val bigint) engine=InnoDB
Hibernate: insert into hibernate_sequence values ( 1 )

-- Insert a CreditCard Object
Hibernate: select next_val as id_val from hibernate_sequence for update
Hibernate: update hibernate_sequence set next_val= ? where next_val=?
Hibernate: insert into BillingDetails (owner, cardNumber, expMonth, BD_TYPE, id) values (?, ?, ?, 'CC', ?)

-- Select all Credit Card Object (from CreditCard)
Hibernate: select creditcard0_.id as id2_0_, creditcard0_.owner as owner3_0_, creditcard0_.cardNumber as cardNumb6_0_, creditcard0_.expMonth as expMonth7_0_ from BillingDetails creditcard0_ where creditcard0_.BD_TYPE='CC'

[CreditCard [cardNumber=123456789, expMonth=04/10/2019]]

-- Update a CreditCard Object 
Hibernate: select creditcard0_.id as id2_0_0_, creditcard0_.owner as owner3_0_0_, creditcard0_.cardNumber as cardNumb6_0_0_, creditcard0_.expMonth as expMonth7_0_0_ from BillingDetails creditcard0_ where creditcard0_.id=? and creditcard0_.BD_TYPE='CC'
Hibernate: update BillingDetails set owner=?, cardNumber=?, expMonth=? where id=?


-- BankAccount

-- Insert a BankAccount Record

Hibernate: select next_val as id_val from hibernate_sequence for update
Hibernate: update hibernate_sequence set next_val= ? where next_val=?
Hibernate: insert into BillingDetails (owner, account, bankName, BD_TYPE, id) values (?, ?, ?, 'BankAccount', ?)

-- Select All BankAccount Detail (from BankAccount) 
Hibernate: select bankaccoun0_.id as id2_0_, bankaccoun0_.owner as owner3_0_, bankaccoun0_.account as account4_0_, bankaccoun0_.bankName as bankName5_0_ from BillingDetails bankaccoun0_ where bankaccoun0_.BD_TYPE='BankAccount'

[BankAccount [account=123, bankName=PNB]]

-- Update a BankAccount Detail
Hibernate: select bankaccoun0_.id as id2_0_0_, bankaccoun0_.owner as owner3_0_0_, bankaccoun0_.account as account4_0_0_, bankaccoun0_.bankName as bankName5_0_0_ from BillingDetails bankaccoun0_ where bankaccoun0_.id=? and bankaccoun0_.BD_TYPE='BankAccount'
Hibernate: update BillingDetails set owner=?, account=?, bankName=? where id=?


-- BillingDetails

-- Select (from BillingDetails)
select billingdet0_.id as id2_0_, billingdet0_.owner as owner3_0_, billingdet0_.account as account4_0_, billingdet0_.bankName as bankName5_0_, billingdet0_.cardNumber as cardNumb6_0_, billingdet0_.expMonth as expMonth7_0_, billingdet0_.BD_TYPE as BD_TYPE1_0_ from BillingDetails billingdet0_


