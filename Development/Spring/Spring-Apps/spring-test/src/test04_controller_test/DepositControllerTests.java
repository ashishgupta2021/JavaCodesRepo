package test04_controller_test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.ui.ModelMap;

import com.web.controller.DepositController;

import common.AccountService;

public class DepositControllerTests {
	
	private static final String TEST_ACCOUNT_NO = "1234";
	private static final double TEST_AMOUNT = 500;
	private AccountService accountService;
	private DepositController depositController;
	
	@Before
	public void init() {
		accountService = Mockito.mock(AccountService.class);
		depositController = new DepositController(accountService);
	}

	@Test
	public void deposit() {
		
		// Set up
		Mockito.when(accountService.getBalance(TEST_ACCOUNT_NO)).thenReturn(150.0);
		ModelMap model = new ModelMap();
		
		// Execute
		String viewName = depositController.deposit(TEST_ACCOUNT_NO, TEST_AMOUNT, model);
		
		System.out.println("viewName :" + viewName +  " accountNo :" + model.get("accountNo") + " balance :"+ model.get("balance") );
		assertEquals(viewName, "success");
		assertEquals(model.get("accountNo"), TEST_ACCOUNT_NO);
		assertEquals(model.get("balance"), 150.0);
	}
}
