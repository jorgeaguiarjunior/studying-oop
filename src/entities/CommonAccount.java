package entities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.enums.AccountType;

public abstract class CommonAccount implements Account {
	private String name;
	private String email;
	private Integer id;
	private Date date;
	protected AccountType type;
	protected List<Receipt> receipt = new ArrayList<>();
	protected Double amount;
	public static final SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");

	public CommonAccount(String name, String email, Integer id, Date date, AccountType type, Double amount) {
		this.name = name;
		this.email = email;
		this.id = id;
		this.date = date;
		this.type = type;
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public Date getDate() {
		return date;
	}

	public Double getAmount() {
		return amount;
	}

	public List<Receipt> getReceipt() {
		return receipt;
	}
	
	public void printReceipt() {
		for (Receipt r : receipt) {
			System.out.println((receipt.indexOf(r) + 1) + "º" + r);
		}

		System.out.println("Inform which receipt you want to print: 1 - " + receipt.size() + "\nOr 0 to all: ");
		Scanner sc = new Scanner(System.in);
		int which = sc.nextInt();
		String line;

		try (BufferedWriter bw = new BufferedWriter(
				new FileWriter("C:\\Temp\\eclipse-workspace\\estudo-poo\\receipts.txt"))) {
			if (which == 0) {
				for (Receipt r : receipt) {
					line = String.valueOf(r);
					bw.write(line);
				}
			} else {
				line = String.valueOf(receipt.get(which - 1));
				bw.write(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			sc.close();
		}

	}
}
