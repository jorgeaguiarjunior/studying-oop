package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

import entities.enums.AccountAction;

public class Receipt {

	private String name;
	private Integer id;
	private Date date;
	private Double amount;
	private AccountAction action;
	private static final SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	public Receipt(String name, Integer id, Date date, Double amount, AccountAction action) {
		this.name = name;
		this.id = id;
		this.date = date;
		this.amount = amount;
		this.action = action;
	}

	@Override
	public String toString() {
		return "\n" + action + "\nName: " + name + "\nID: " + id + "\nDate: " + SDF.format(date) + "\nAmount: " + amount;
	}
}
