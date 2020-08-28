package application;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import entities.Account;
import entities.CommonAccount;
import entities.PremiumAccount;
import entities.StandardAccount;
import entities.enums.AccountType;
import entities.exceptions.AccountExceptions;

public class Program {
	private static List<Integer> listId = new ArrayList<>();

	public static void main(String[] args) {
		// TESTE DE CRIAÇÃO DAS CONTAS
		Account standardAccount = new StandardAccount("Jorge", "jorgeaguiarjunior@hotmail.com", createId(), new Date(),
				AccountType.STANDARD_ACCOUNT, 0.0);

		Account premiumAccount = new PremiumAccount("Teste", "teste@nomail.com", createId(), new Date(),
				AccountType.PREMIUM_ACCOUNT, 0.0);

		System.out.println("\n" + standardAccount);
		System.out.println("\n" + premiumAccount);

		// TESTE DE DEPOSITO
		standardAccount.deposit(1000.00);
		premiumAccount.deposit(1000.00);

		System.out.println("\n" + standardAccount);
		System.out.println("\n" + premiumAccount);

		// TESTE DE SAQUE COM EXCEÇÃO
		try {
			standardAccount.withdraw(1000.00);
			premiumAccount.withdraw(1000.00);
		} catch (AccountExceptions e) {
			e.printStackTrace();
		}

		System.out.println("\n" + standardAccount);
		System.out.println("\n" + premiumAccount);

		// TESTE DE SAQUE SEM EXCEÇÃO
		try {
			standardAccount.withdraw(100.00);
			premiumAccount.withdraw(100.00);
		} catch (AccountExceptions e) {
			e.printStackTrace();
		}

		System.out.println("\n" + standardAccount);
		System.out.println("\n" + premiumAccount);

		// TESTE DE TRANSFERENCIA STANDARD -> PREMIUM

		try {
			standardAccount.transfer(100.00, premiumAccount);
		} catch (AccountExceptions e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("\n" + standardAccount);
		System.out.println("\n" + premiumAccount);

		// TESTE DE TRANSFERENCIA PREMIUM -> STANDARD

		try {
			premiumAccount.transfer(100.00, standardAccount);
		} catch (AccountExceptions e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\n" + standardAccount);
		System.out.println("\n" + premiumAccount);

		// VERIFICANDO RECIBOS
		System.out.println("\n" + ((CommonAccount) standardAccount).getReceipt());
		System.out.println("\n" + ((CommonAccount) premiumAccount).getReceipt());
		
		premiumAccount.printReceipt();

	}

	public static Integer createId() {
		Random random = new Random();

		int id = random.nextInt(9999);

		if (listId == null) {
			return id;
		}

		while (listId.contains(id)) {
			random.nextInt(9999);
		}

		return id;
	}

}
