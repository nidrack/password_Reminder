package entities;

import java.util.ArrayList;
import java.util.List;

import entities.enums.AccountType;

public class Account {

	private String login;
	private String password;
	private AccountType type;
	
	private List<Account> accounts = new ArrayList<>();
		
	public Account() {
	}
	
	public Account(String login, String password, AccountType type) {
		this.login = login;
		this.password = password;
		this.type = type;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AccountType getType() {
		return type;
	}

	public void setType(AccountType type) {
		this.type = type;
	}

	public void addAccount(Account account) {
		accounts.add(account);
	}
	
	public void removeAccount(Account account) {
		accounts.remove(account);

	}
	

	}
	
}

