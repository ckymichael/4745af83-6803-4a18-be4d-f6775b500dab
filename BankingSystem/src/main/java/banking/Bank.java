package banking;

import java.util.LinkedHashMap;

/**
 * Private Variables:<br>
 * {@link #accounts}: List&lt;Long, Account&gt;
 */
public class Bank implements BankInterface {
	private LinkedHashMap<Long, Account> accounts;

	public Bank() {
		accounts = new LinkedHashMap<>();
	}

	@Override
	public Long generateAccountNumber() {
		return (long) accounts.size();
	}

	private Account getAccount(Long accountNumber) {
        return accounts.getOrDefault(accountNumber, null);
	}

	public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
		Long id = generateAccountNumber();
		Account acc = new CommercialAccount(company, id, pin, startingDeposit);
		accounts.put(id, acc);
        return id;
	}

	public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
		Long id = generateAccountNumber();
		Account acc = new ConsumerAccount(person, id, pin, startingDeposit);
		accounts.put(id, acc);
		return id;
	}

	public boolean authenticateUser(Long accountNumber, int pin) {
        return getAccount(accountNumber).validatePin(pin);
	}

	public double getBalance(Long accountNumber) {
        return getAccount(accountNumber).getBalance();
	}

	public void credit(Long accountNumber, double amount) {
		getAccount(accountNumber).creditAccount(amount);
	}

	public boolean debit(Long accountNumber, double amount) {
		return getAccount(accountNumber).debitAccount(amount);
	}
}
