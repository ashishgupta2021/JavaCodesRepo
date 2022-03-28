package common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BankConfiguration {

	@Bean
	public AccountDao accountDao() {
		return new InMemoryAccountDao();
	}
	
	@Bean
	public AccountService accountService() {
		return new AccountServiceImpl(accountDao());
	}
}
