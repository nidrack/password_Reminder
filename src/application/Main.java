package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Account;
import entities.enums.AccountType;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String path = "c:\\temp\\accounts.csv";

		List<Account> accounts = new ArrayList<>();

		char a;
		Account acc;

		do {
			try {
				System.out.print("Login: ");
				String login = sc.nextLine();
				System.out.print("Password: ");
				String pw = sc.nextLine();
				System.out.print("Type: ");
				AccountType type = AccountType.valueOf(sc.nextLine());
				acc = new Account(login, pw, type);
				accounts.add(acc);
			} catch (IllegalArgumentException e) {
				System.out.println("Invalid type. Try again");
			}

			System.out.println("Add more? ");
			a = sc.next().charAt(0);
			sc.nextLine();
		} while (a == 'y');

		for (Account acc1 : accounts) {
			System.out.println("Login: " + acc1.getLogin() + " Password: " + acc1.getPassword());
		}
		sc.close();
	}

}
