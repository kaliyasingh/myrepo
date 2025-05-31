package com.ritik.main;

import java.util.Scanner;

import com.ritik.Account;
import com.ritik.daoimp.Accountdemoimpl;

public class App {
	public static void main(String args[]) {

		int n = 1, amt, choice;
		long accno;
		Accountdemoimpl accdemo = new Accountdemoimpl();
		Scanner s = new Scanner(System.in);

		while (n == 1) {
			System.out.println("----------------------------------------------------");
			System.out.println("What Do U Want : ");
			System.out.println("Open Account press 1");
			System.out.println("For Deposite press 2");
			System.out.println("For Withdrwal press 3");
			System.out.println("For Transaction press 4");
			System.out.println("For bank Statement press 5");
			System.out.println("show Details press 6");
			System.out.println("Exit press 0"); // Add exit option
			System.out.println("----------------------------------------------------");
			System.out.print("Enter your choice : ");
			choice = s.nextInt();

			if (choice == 0) {
				n = 0;
				System.out.println("Exiting the program. Goodbye!");
				break;
			}

			Account acc = new Account();
			switch (choice) {
			case 1:
				System.out.print("enter addhar no :");
				acc.setAddhar_no(s.nextLong());
				System.out.print("enter account holder name :");
				s.nextLine();
				acc.setName(s.next());
				System.out.print("enter balance  :");
				acc.setBalance(s.nextInt());
				
				if (accdemo.opeanAcc(acc))
					System.out.println("Account opened successfully for " + acc.getName() + " with account no :"
							+ acc.getAccount_no());
				else
					System.out.println("Account could not be opened");
				break;

			case 2:
				System.out.print("enter the account no :");
				accno = s.nextLong();
				if (accdemo.searchAccount(accno) != null) {
					System.out.print("enter the amount to be deposite :");
					amt = s.nextInt();
					if (accdemo.deposite(amt, accno))
						System.out.println("amount deposit succesfully ");
					else
						System.out.println("enter the valid amount ");
				} else
					System.out.println("account not be exist");

				break;
			case 3:
				System.out.print("enter the account no :");
				accno = s.nextLong();
				if (accdemo.searchAccount(accno) != null) {
					System.out.print("enter the amount to be withdraw :");
					amt = s.nextInt();
					if (accdemo.withdrwal(amt, accno))
						System.out.println("amount withdrwal succesfully ");
					else
						System.out.println("enter the valid sufficient amount ");
				} else
					System.out.println("account not be exist");
				break;
				
			case 4:
				System.out.print("enter your the account no :");
				accno = s.nextLong();
				if (accdemo.searchAccount(accno) != null) {
					System.out.print("enter the amount :");
					amt = s.nextInt();
					System.out.println("enter the account no the amt will be transfer");
					Long accno1 = s.nextLong();
					if ((accdemo.searchAccount(accno1)!=null) && accdemo.transaction(amt, accno, accno1))
						System.out.println("transaction succesfull");
					else
						System.out.println("transaction failed");
				} else
					System.out.println("account not be exist");
				break;

			case 5:
				System.out.print("enter the account no :");
				accno = s.nextLong();
				if (accdemo.searchAccount(accno) != null)
				accdemo.statement(accno);
				else
				System.out.println("account is not exist");

				break;
			case 6:
				System.out.print("enter account no :");
				accno = s.nextLong();
				if((acc = accdemo.searchAccount(accno))!=null)
				System.out.println(acc);
				else
					System.out.println("account not be exist");
				break;

			default:
				throw new IllegalArgumentException("Unexpected value: " + n);

			}
		}
	}
}
