package se.kth.iv1350.pos.model;

import se.kth.iv1350.pos.integration.*;
import se.kth.iv1350.pos.model.*;
import se.kth.iv1350.pos.controller.Controller;
import java.time.*;
import java.util.*;

/**
 * Representerar en försäljning, en kund.
 */
public class Sale {
    private LocalTime time; 
    private SaleDTO saleInformation;
    private Receipt receipt;
    private List<Item> items;
    private List<Integer> customerItemsQuantity = new ArrayList<>();
    private double totalVAT;
    private double totalPrice;

    /**
	 * Skapar en ny instans av försäljning och sparar tiden.
	 */
    public Sale () {
    	this.time = LocalTime.now();
    	this.items = new ArrayList<>();
    	this.saleInformation = new SaleDTO(time, 0, 0, null);
    }

    /**
	 *Returnerar en arraylista med alla objekt i klassen "Item".
	 * @return varorna som en arraylista ochsom innehåller alla varor.
	 */
    public List<Item> getItems() {
    	return this.items;
    }

    /**
	 * Returnerar kundens kvantitet av varor.
	 * @return customerItemsQuantity antal varor kunden vill köpa.
	 */
    public List<Integer> getItemsQuantity(){
    	return this.customerItemsQuantity;
    }

    /**
	 * Returnerar försäljningsinformationen för försäljningen.
	 * @return saleInformation innehåller information om försäljningen.
	 */
    public SaleDTO getSaleInformation() {
        return this.saleInformation;
    }
    
    /**
	 * Lägger till en vara till den aktuella försäljningen.
	 * @param item varan som läggs till.
	 * @param quantity kvantiteten av varan som läggs till.
	 */

	   // ************************************************************
    public void addItem(Item item, int quantity) {
    	updateTotalVAT(item.getItemDTO().getVAT(), quantity);
    	updateTotalPrice(item.getItemDTO().getPrice(), quantity, (item.getItemDTO().getVAT()));
        isScanned(item, quantity);
    }
    /**
	 * Hanterar dubbletter av varor genom att öka antalet med ett för den givna varan.
	 * @param currentItem dublett vararn.
	 * @param quantity kvantiteten av denna artikel.
	 */
    private void isScanned(Item item, int quantity) {
        boolean found = false;
    	for(Item currentItem : items) {
    		if(currentItem.getItemIdentifier() == item.getItemIdentifier()) {   
    			found = true;
    			customerItemsQuantity.set(items.indexOf(currentItem),
				(customerItemsQuantity.get(items.indexOf(currentItem)) + quantity));
    		}
    	}
        if(found == false) {
    		updateItems(item);
                customerItemsQuantity.add(quantity);
    	}
    }
    
    /**
	 * Returnerar kvittot.
	 * @param sale försäljningen som hanterar.
	 * @return recepit, kvittot av försäljningen
	 */

 
    public Receipt getReceipt() {
        this.receipt = new Receipt(getSaleInformation());
    	return receipt;
    }
 	
    	/**
     * Denna metod uppdaterar det totala priset för försäljningen.
     * @param amount kostnaden för varan.
     * @param quantity varans kvantitet.
     * @param totalVAT totala momsen
     */
	private void updateTotalPrice(double amount, int quantity, double totalVAT) {
		this.totalPrice += (amount * quantity) + (totalVAT * (double)quantity);
                this.saleInformation = new SaleDTO(this.time, this.totalVAT, this.totalPrice, this.items);
	}

	/**
     * Uppdaterar den totala momsen för hela försäljningen.
     * @param amount priset av varan
     * @param quantity varans kvantitet.
     */
	private void updateTotalVAT(double vat, int quantity) {
		this.totalVAT += (vat* quantity);
                this.saleInformation = new SaleDTO(this.time, this.totalVAT, this.totalPrice, this.items);
	}

	/**
     * Lägger till varan i arraylistan nameOfItems.
     * @param item varan som läggs till i listan.
     */
	private void updateItems(Item item) {
		items.add(item);
                this.saleInformation = new SaleDTO(this.time, this.totalVAT, this.totalPrice, this.items);
	}
}
