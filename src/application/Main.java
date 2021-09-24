package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
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

		String filePath = "c:\\temp\\accounts.csv";

		// LENDO ARQUIVO EXISTENTE E ADICIONANDO A LISTA
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

			String itemCsv = br.readLine();
			while (itemCsv != null) {

				String[] fields = itemCsv.split(",");
				String login = fields[0];
				String pw = fields[1];
				AccountType type = AccountType.valueOf(fields[2]);

				accounts.add(new Account(login, pw, type));

				itemCsv = br.readLine();
			}
		} catch (IOException e) {
			System.out.println("Error writing file: " + e.getMessage());
		} finally {
			System.out.println("Import sucessesful!");
		}

		accountList(accounts);

		// PREENCHENDO A LISTA COM OS DADOS SOLICITADOS
		System.out.println("Add more? (y/n) ");
		a = sc.next().charAt(0);
		sc.nextLine();

		if (a == 'y') {
			// PREENCHENDO A LISTA COM OS DADOS SOLICITADOS
			do {
				try {
					System.out.print("Login: ");
					String login = sc.nextLine();
					System.out.print("Password: ");
					String pw = sc.nextLine();
					System.out.print("Type: ");
					AccountType type = AccountType.valueOf(sc.nextLine());

					accounts.add(new Account(login, pw, type));
				} catch (IllegalArgumentException e) {
					System.out.println("Invalid type. Try again");
				}
				System.out.println("Add more? (y/n)");
				a = sc.next().charAt(0);
				sc.nextLine();
			} while (a == 'y');
		} else {
			accountList(accounts);
		}

		System.out.println("Save changes? (y/n)");
		a = sc.next().charAt(0);
		sc.nextLine();

		// ESCREVENDO OS DADOS EM ARQUIVO
		if (a == 'y') {
			try (BufferedWriter bwr = new BufferedWriter(new FileWriter(filePath))) {
				for (Account item : accounts) {
					bwr.write(item.getLogin() + "," + item.getPassword() + "," + item.getType());
					bwr.newLine();
				}
				System.out.println(filePath + " CREATED!");
			} catch (IOException e) {
				System.out.println("Error writing file: " + e.getMessage());
			}
			accountList(accounts);
		} else {
			System.out.println("Okie dokie");
		}
		sc.close();
	}

	public static void accountList(List<Account> list) {
		for (Account acc : list) {
			System.out.println(
					"Login: " + acc.getLogin() + " Password: " + acc.getPassword() + " Type: " + acc.getType());
		}
	}

}
