package entities;

import java.util.Date;

import entities.enums.AccountAction;
import entities.enums.AccountType;
import entities.exceptions.AccountExceptions;

public class PremiumAccount extends CommonAccount {

	public PremiumAccount(String name, String email, Integer id, Date date, AccountType type, Double amount) {
		super(name, email, id, date, type, amount);
	}

	@Override
	public void withdraw(Double amount) throws AccountExceptions {
		if (amount > this.amount) {
			throw new AccountExceptions("Insufficient account amount");
		} else if (amount < 1) {
			throw new AccountExceptions("Incorrect value, the value must be greater than or equal to 1");
		}
		this.amount = (this.amount - amount);
		receipt.add(new Receipt(getName(), getId(), new Date(), amount, AccountAction.WITHDRAWN));
	}

	@Override
	public void deposit(Double amount) throws AccountExceptions {
		if (amount < 1) {
			throw new AccountExceptions("Incorrect value, the value must be greater than or equal to 1");
		}
		this.amount = (this.amount + amount);
		receipt.add(new Receipt(getName(), getId(), new Date(), amount, AccountAction.DEPOSITED));
	}

	@Override
	public void transfer(Double amount, Account account) throws AccountExceptions {
		if (amount > this.amount) {
			throw new AccountExceptions("Insufficient account amount");
		} else if (amount < 1) {
			throw new AccountExceptions("Incorrect value, the value must be greater than or equal to 1");
		}
		this.amount = (this.amount - amount);
		receipt.add(new Receipt(getName(), getId(), getDate(), amount, AccountAction.SENT));
		account.receive(amount, new Receipt(getName(), getId(), getDate(), amount, AccountAction.RECEIVED));
	}

	@Override
	public void receive(Double amount, Receipt receipt) {
		this.amount = (this.amount + amount);
		this.receipt.add(receipt);
	}

	@Override
	public String toString() {
		return "Account Type: " + type + "\nID: " + getId() + "\nName: " + getName() + "\nEmail: " + getEmail()
				+ "\nClient since: " + SDF.format(getDate()) + "\nAccount amount: " + amount;
	}

}
