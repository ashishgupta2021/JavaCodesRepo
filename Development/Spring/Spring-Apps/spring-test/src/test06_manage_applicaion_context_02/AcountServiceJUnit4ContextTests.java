package test06_manage_applicaion_context_02;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import common.AccountService;
import common.BankConfiguration;

//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=BankConfiguration.class)
public class AcountServiceJUnit4ContextTests extends AbstractJUnit4SpringContextTests {

	private static final String TEST_ACCOUNT_NO = "1234";
	private AccountService  accountService;
	
	@Before
	public void init() {
		accountService = applicationContext.getBean(AccountService.class);
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
	
	@After
	public void cleanup() {
		accountService.removeAccount(TEST_ACCOUNT_NO);
	}
}
