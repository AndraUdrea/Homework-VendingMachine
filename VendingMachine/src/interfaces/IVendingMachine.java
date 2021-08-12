package interfaces;

import classes.Item;
import exceptions.NotFullPaidException;
import exceptions.SoldOutExcepiton;

public interface IVendingMachine {

	public void displayItemsAndPrices();

	public Item selectItem(int item) throws SoldOutExcepiton;

	public void displayCoins();

	public void enterMoney(Item item, double money, int[] arrayOfMoney) throws NotFullPaidException;

	public void returnItemAndChange(Item item, double money, int[] arrayOfMoney);

}
