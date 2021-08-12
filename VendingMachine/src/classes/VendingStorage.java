package classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

//

public class VendingStorage {

	private Map<Integer, Item> items;

	public VendingStorage() {
		this.items = new HashMap<>();
	}

	public void addItem(Item item) {
		if (!this.items.containsKey(item.getId())) {
			this.items.put(item.getId(), item);
		}
	}

	public void showItems() {
		for (Item currentItem : this.items.values()) {
			System.out.println(currentItem);
		}
	}

	public Item getItem(int id) {
		if (this.items.containsKey(id)) {
			return this.items.get(id);
		}

		return null;
	}

}
