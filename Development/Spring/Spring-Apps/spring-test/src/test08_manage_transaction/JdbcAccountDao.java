package test08_manage_transaction;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import common.Account;
import common.AccountDao;

public class JdbcAccountDao extends JdbcDaoSupport implements AccountDao {

	@Override
	public void createAccount(Account account) {
		String sql = "INSERT INTO account(account_no, balance) values (?, ?)";
		//getJdbcTemplate().update(sql, account.getAccountNo(), account.getBalance());
		getJdbcTemplate().update(sql, account.getAccountNo(), account.getBalance());

	}

	@Override
	public void updateAccount(Account account) {
		String sql = "UPDATE account set balance = ? where account_no = ?";
		getJdbcTemplate().update(sql, account.getBalance(), account.getAccountNo());
	}

	@Override
	public void removeAccount(Account account) {
		String sql = "DELETE FROM account where account_no = ?";
		getJdbcTemplate().update(sql, account.getAccountNo());
	}

	@Override
	public Account findAccount(String accountNo) {
		String sql = "Select balance from account where account_no = ?";
		double balance = getJdbcTemplate().queryForObject(sql, Double.class, accountNo);
		return new Account(accountNo, balance);
	}

	
}
