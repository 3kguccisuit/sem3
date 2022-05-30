package se.kth.iv1350.pos.integration;

import se.kth.iv1350.pos.model.*;
import java.util.*;

/**
 * External inventory system, hanterar varor som finns i lager.
 */
public class ExternalInventorySystem {
	private List<Item> storeItems = new ArrayList<>();
	private List<ItemDTO> itemDTOs = new ArrayList<>();
	
	public ExternalInventorySystem() {
	}

	/**
	 * Lägger till varor till butikens lager.
	 * (Beskrivning, Pris, VAT)
	 */
	public void addItem() {
		this.itemDTOs.add(new ItemDTO("Nötfärs 500g", 70, 12)); 
		this.itemDTOs.add(new ItemDTO("Riven ost 250g", 17, 2));
		this.itemDTOs.add(new ItemDTO("Taco Krydda", 10, 2));
		this.itemDTOs.add(new ItemDTO("Taco sås", 20, 4));

		this.storeItems.add(new Item(1, itemDTOs.get(0), 100));
		this.storeItems.add(new Item(2, itemDTOs.get(1), 100));
		this.storeItems.add(new Item(3, itemDTOs.get(2), 100));
		this.storeItems.add(new Item(4, itemDTOs.get(3), 100));
	}

/**
	 * Söker efter en vara i systemet med hjälp av itemIdentifier.
	 * @param itemIdentifier varans unika kod
	 * @return Returnerar varan om den finns, annars null
	 */

	   // ************************************************************
	public Item search(int itemIdentifier) {

		// 
		// for (int i=0; i < storeItems.size(); i++)
		// {
		// 	Item varaILagret = storeItems.get(i);
		// 	if (varaILagret.getItemIdentifier() == itemIdentifier)
		// 	{
		// 		return varaILagret;
		// 	}
		// }


		for (Item item : storeItems) {
			if (item.getItemIdentifier() == itemIdentifier) {
					return item;
			}
		}
		return null;
	}

	/**
	 * Uppdaterar lagret baserat på vad som säljs.
	 * @param sale Innehåller information från köpet.
	 */

	   // ************************************************************
	public void update(Sale sale) {
		List<Item> items = sale.getItems();
		List<Integer> itemsQuantity = sale.getItemsQuantity();

		for (Item item : items) {
			for (Item item2 : storeItems) {
				if (item == item2) {
					storeItems.get(storeItems.indexOf(item2)).updateQuantity(itemsQuantity.get(items.indexOf(item)));
				}
			}
		}
	}
	
	/**
	 * Returnerar butikens varor
	 * @return storeItems, alla om varorna finns i butikens lager.
	 */
	public List<Item> getItems(){
		return this.storeItems;
	}
}
