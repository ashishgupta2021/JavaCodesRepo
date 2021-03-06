package com.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import common.AccountService;

public class DepositController {

	private AccountService accountService;
	
	@Autowired
	public DepositController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	@RequestMapping("/deposit.do")
	public String deposit(@RequestParam("accountNo") String accountNo, @RequestParam("amount") double amount,
			ModelMap model)	{
		accountService.deposit(accountNo, amount);
		model.addAttribute("accountNo",accountNo);
		model.addAttribute("balance",accountService.getBalance(accountNo));
		return "success";
	}
}
