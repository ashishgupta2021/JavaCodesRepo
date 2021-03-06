package test08_manage_transaction;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import common.AccountService;

//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=BankConfiguration.class)
@Transactional
public class AccountServiceJUnit4ContextTests extends AbstractTransactionalJUnit4SpringContextTests{

	private static final String TEST_ACCOUNT_NO = "1234";
	
	@Autowired
	private AccountService accountService;
	
	@Before
	public void init() {
		accountService.createAccount(TEST_ACCOUNT_NO);
		accountService.deposit(TEST_ACCOUNT_NO, 100);
	}
	
	@Test
	public void deposit() {
		accountService.deposit(TEST_ACCOUNT_NO, 50);
		assertEquals(accountService.getBalance(TEST_ACCOUNT_NO), 150, 0);
	}
	
	@Test
	public void withDraw() {
		accountService.withdraw(TEST_ACCOUNT_NO, 50);
		assertEquals(accountService.getBalance(TEST_ACCOUNT_NO), 50,0);
	}
}

