package classes;

import exceptions.NotFullPaidException;
import exceptions.NotSufficientChangeException;
import exceptions.SoldOutExcepiton;
import interfaces.IVendingMachine;

public class VendingMachineImpl implements IVendingMachine {

	private VendingStorage vStorage;
	private BankStorage bStorage;

	public VendingMachineImpl() {
		this.vStorage = new VendingStorage();
		this.bStorage = new BankStorage();
	}

	public void addItem(Item item) {
		this.vStorage.addItem(item);

	}

	@Override
	public void displayItemsAndPrices() {
		System.out.println();
		System.out.println();
		System.out.println("WELCOME!");
		System.out.println();
		System.out.println();
		System.out.println("Choose a product:");
		this.vStorage.showItems();
		System.out.println("0--> Exit");
	}

	@Override
	public Item selectItem(int itemId) throws SoldOutExcepiton {
		Item item = this.vStorage.getItem(itemId);
		if (item != null && item.getNumOfItems() > 0) {
			System.out.println("You have selected " + item.getName());
			System.out.println();
			return item;
		} else if (item == null) {
			System.out.println("Item with id " + itemId + " not found");
			return null;
		} else if (item.getNumOfItems() == 0) {
			String errorMessage = "The product selected is sold out :(";
			throw new SoldOutExcepiton(errorMessage);
		}

		return null;
	}

	@Override
	public void enterMoney(Item item, double money, int[] arrayOfMoney) throws NotFullPaidException {
		if (money < item.getPrice()) {
			String message = "You didn't introduce enough money. Giving " + money + " back :)";
			throw new NotFullPaidException(message);
			// System.out.println("You didn't introduce enough money. Giving "+money +" back
			// :)");
		}

		this.bStorage.addMoney(arrayOfMoney);
	}

	@Override
	public void returnItemAndChange(Item item, double money, int[] arrayOfMoney) {
		try {
			if (this.bStorage.giveChange(item, money, arrayOfMoney)) {
				System.out.println("Pick up your " + item.getName() + " and your change :)");
				item.remove(1);
			}
		} catch (NotSufficientChangeException e) {
			System.out.println(e.getMessage());

		}
	}

	@Override
	public void displayCoins() {
		System.out.println("1 for 0.5 bani \n" + "2 for 1 leu \n" + "3 for 5 lei \n" + "4 for 10 lei \n"
				+ "5 DONE introducing money \n" + "6 to cancel the request");
	}
}
