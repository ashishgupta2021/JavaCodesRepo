package test08_manage_transaction;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import common.AccountDao;
import common.AccountService;
import common.AccountServiceImpl;

@Configuration
public class BankConfiguration {

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/account_test");
		dataSource.setUsername("root");
		dataSource.setPassword("ashish");
		return dataSource;
	}
	
	@Bean
	public AccountDao accountDao() {
		JdbcAccountDao accountDao = new JdbcAccountDao();
		accountDao.setDataSource(dataSource());
		return accountDao;
	}
	
	@Bean
	public AccountService accountService() {
		return new AccountServiceImpl(accountDao());
	}
	
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(BankConfiguration.class);
		AccountService ac = (AccountService) context.getBean("accountService");
		ac.createAccount("12334");
		System.out.println("DOne");
	}
}

