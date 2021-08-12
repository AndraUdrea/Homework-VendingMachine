package classes;

import exceptions.NotSufficientChangeException;

public class BankStorage {

	private int cinci_lei;
	private int zece_lei;
	private int un_leu;
	private int cincizeci_bani;

	public BankStorage() {
		this.cinci_lei = 100;
		this.un_leu = 150;
		this.zece_lei = 300;
		this.cincizeci_bani = 30;
	}

	public int getCinci_lei() {
		return cinci_lei;
	}

	public int getZece_lei() {
		return zece_lei;
	}

	public int getUn_leu() {
		return un_leu;
	}

	public int getCincizeci_bani() {
		return cincizeci_bani;
	}

	public void addMoney(int[] arrayOfMoney) {
		this.cincizeci_bani += arrayOfMoney[0];
		this.un_leu += arrayOfMoney[1];
		this.cinci_lei += arrayOfMoney[2];
		this.zece_lei += arrayOfMoney[3];
	}

	public boolean giveChange(Item item, double money, int[] arrayOfMoney) throws NotSufficientChangeException {

		double moneyDue = money - item.getPrice();
		double moneyDueCopy = moneyDue;

		while (moneyDue > 0) {
			if (moneyDue >= 10 && zece_lei > 0) {
				zece_lei--;
				moneyDue -= 10;
			} else if (moneyDue >= 5 && cinci_lei > 0) {
				cinci_lei--;
				moneyDue -= 5;
			} else if (moneyDue >= 1 && un_leu > 0) {
				un_leu--;
				moneyDue -= 1;
			} else if (moneyDue >= 0.5 && cincizeci_bani > 0) {
				cincizeci_bani--;
				moneyDue -= 0.5;
			}
		}

		if (moneyDue != 0) {
			if (moneyDue > 0) {
				String errorMessage = "Not enough money for change. Giving " + money + " back";
				this.cincizeci_bani -= arrayOfMoney[0];
				this.un_leu -= arrayOfMoney[1];
				this.cinci_lei -= arrayOfMoney[2];

				this.zece_lei -= arrayOfMoney[3];

				throw new NotSufficientChangeException(errorMessage);
			}

			return false;
		} else {
			System.out.println("Giving back " + moneyDueCopy + "lei.");
			return true;
		}
	}
}
