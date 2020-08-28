package entities;

import entities.exceptions.AccountExceptions;

public interface Account {

	void withdraw(Double amount) throws AccountExceptions;

	void deposit(Double amount) throws AccountExceptions;

	void transfer(Double amount, Account account) throws AccountExceptions;

	void receive(Double amount, Receipt receipt);

	void printReceipt();

}
