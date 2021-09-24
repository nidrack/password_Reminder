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

		for (Account acc1 : accounts) {
			System.out.println(
					"Login: " + acc1.getLogin() + " Password: " + acc1.getPassword() + " Type: " + acc1.getType());
		}

		// PREENCHENDO A LISTA COM OS DADOS SOLICITADOS
		System.out.println("Add more? ");
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

				System.out.println("Add more? ");
				a = sc.next().charAt(0);
				sc.nextLine();
			} while (a == 'y');

		} else {
			for (Account acc1 : accounts) {
				System.out.println(
						"Login: " + acc1.getLogin() + " Password: " + acc1.getPassword() + " Type: " + acc1.getType());
			}
		}

		System.out.println("Save changes? ");
		a = sc.next().charAt(0);
		sc.nextLine();

		if (a == 'y') {
			// ESCREVENDO OS DADOS EM ARQUIVO
			try (BufferedWriter bwr = new BufferedWriter(new FileWriter(filePath))) {
				for (Account item : accounts) {
					bwr.write(item.getLogin() + "," + item.getPassword() + "," + item.getType());
					bwr.newLine();
				}
				System.out.println(filePath + " CREATED!");
			} catch (IOException e) {
				System.out.println("Error writing file: " + e.getMessage());
			}

			for (Account acc1 : accounts) {
				System.out.println(
						"Login: " + acc1.getLogin() + " Password: " + acc1.getPassword() + " Type: " + acc1.getType());
			}
		} else {
			System.out.println("Okie dokie");
		}
		sc.close();
	}

}
