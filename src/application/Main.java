package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Account;
import entities.enums.AccountType;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		List<Account> accounts = new ArrayList<>();

		char a;
		Account acc;
		
		String filePath = "c:\\temp\\accounts.csv";

		// PREENCHENDO A LISTA COM OS DADOS SOLICITADOS		
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

		// ESCREVENDO OS DADOS SOLICITADOS EM ARQUIVO
		try (BufferedWriter bwr = new BufferedWriter(new FileWriter(filePath))) {
			for (Account item : accounts) {
				bwr.write(item.getLogin() + "," + item.getPassword() + "," + item.getType());
			}
			System.out.println(filePath + " CREATED!");
		} catch (IOException e) {
			System.out.println("Error writing file: " + e.getMessage());
		}

		for (Account acc1 : accounts) {
			System.out.println("Login: " + acc1.getLogin() + " Password: " + acc1.getPassword() + " Type: " + acc1.getType());
		}
		sc.close();
	}

}
