package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import classes.Item;
import classes.VendingMachineImpl;
import exceptions.NotFullPaidException;
import exceptions.SoldOutExcepiton;

public class Main {

	public static void main(String[] args) {

		VendingMachineImpl vendingMachine = new VendingMachineImpl();

		Scanner scanner = new Scanner(System.in);

		Item it1 = new Item(1, "Sandwich", 5, 20);
		Item it2 = new Item(2, "Coke", 10, 19);
		Item it3 = new Item(3, "Brownie", 6, 5);

		vendingMachine.addItem(it1);
		vendingMachine.addItem(it2);
		vendingMachine.addItem(it3);

		boolean run = true;
		while (run) {
			vendingMachine.displayItemsAndPrices();
			System.out.print("> ");

			int input = scanner.nextInt();
			scanner.nextLine();

			if (input == 0) {
				run = false;
				continue;
			}

			Item item = null;
			try {
				item = vendingMachine.selectItem(input);
			} catch (SoldOutExcepiton e1) {
				System.out.println(e1.getMessage());
			}
			if (item == null) {
				continue;
			}

			System.out.println("Please enter money");
			double money = 0.0;
			boolean ok = true;
			vendingMachine.displayCoins();

			int[] arrayOfMoney = new int[4];

			while (ok) {
				input = scanner.nextInt();
				scanner.nextLine();

				switch (input) {
				case 1:
					money += 0.5;
					arrayOfMoney[0] += 1;
					System.out.println("Current balance: " + money);
					break;
				case 2:
					money += 1;
					arrayOfMoney[1] += 1;
					System.out.println("Current balance: " + money);
					break;
				case 3:
					money += 5;
					arrayOfMoney[2] += 1;
					System.out.println("Current balance: " + money);
					break;
				case 4:
					money += 10;
					arrayOfMoney[3] += 1;
					System.out.println("Current balance: " + money);
					break;
				case 5:
					ok = false;
					break;
				case 6:
					System.out.println("Canceling.. Returning your money: " + money + " lei :)");
					ok = false;
					break;
				default:
					System.out.print("Option not available");
					break;
				}
			}

			if (input != 6) {

				try {
					vendingMachine.enterMoney(item, money, arrayOfMoney);
				} catch (NotFullPaidException e) {
					System.out.println(e.getMessage());
				}
				vendingMachine.returnItemAndChange(item, money, arrayOfMoney);
			}

		}

	}
}