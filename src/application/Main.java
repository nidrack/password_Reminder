package application;

import java.util.ArrayList;
import java.util.Scanner;

import entities.Account;
import entities.enums.AccountType;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner (System.in);
		String path = "c:\\temp\\accounts.csv";
		
		char a;
		Account acc;
		
		do {
		System.out.print("Login: ");
		String login = sc.nextLine();
		System.out.print("Password: ");
		String pw = sc.nextLine();
		System.out.print("Type: ");
		AccountType type = AccountType.valueOf(sc.nextLine());
		
		acc = new Account(login, pw, type);
		acc.addAccount(acc);
		System.out.println("Add more? ");
		a = sc.next().charAt(0); 
		sc.nextLine();
		} while (a == 'y');

		sc.close();
	}

}
