package se.kth.iv1350.pos.controller;

import se.kth.iv1350.pos.model.*;
import se.kth.iv1350.pos.integration.*;

/**
 * Programmets Controller, hanterar dem olika operationerna. 
 */
public class Controller {
    private Sale sale;
    private Printer printer; 
    private ExternalAccountingSystem eas;
    private ExternalInventorySystem eis;
    
    /**
     * Genererar en instans av controller
     * @param printer skriver kvittot
     * @param eis extern inventarie hanterare
     * @param eas extern bokförings hanterare
	 */
    public Controller(Printer printer, ExternalAccountingSystem eas, ExternalInventorySystem eis) {
        this.printer = printer;
        this.eis = eis;
        this.eas = eas;
        eis.addItem();
    }
    
    /**
     * Startar ett nytt sälj, denna funktion anropas först av allt.
     * @return getSaleInformation retunerar informationen om köpet som genomförs.
	 */
    public SaleDTO startSale() {
        this.sale = new Sale();
        return sale.getSaleInformation();
    }
    
    /**
     * Lägger till ett föremål i köpet
     * @param itemIdentifier Unik identifierare för varje produkt.
     * @param quantity Antalet av produkten.
     * @return SaleDTO, det som skall visas från view. 
     */
    public SaleDTO enterItem(int itemIdentifier, int quantity) {
    	Item item = eis.search(itemIdentifier);
    	if(item == null){
            return null;
        }
    	if(item.getStoreQuantity() >= quantity) {
    		sale.addItem(item, quantity);
    	}else {
    		return null;
    	}
    	return this.sale.getSaleInformation();
    }
    
    /**
	 * Avslutar köpet
     * @return returnerar SaleDTO efter avslutat köp.
	 */
    public SaleDTO endSale() {
    	eis.update(this.sale);
    	return this.sale.getSaleInformation();
    }
    
    /**
     * Hanterar betalningen, uppdaterar bokföring. 
     * @param amount vilket belopp som det betalas med.
     * @param paymentMethod vilkett sett som det betalas med.
     * @return change, hur mycket växel som skall retuneras till kund. 
	 */
    public double pay(double amount, String paymentMethod) {
    	double change = amount - sale.getSaleInformation().getTotalPrice();
    	
    	if(change >= 0){
    		this.eas.update(amount - change);
    	}

    	return change;
    }
    
    /**
     * printer skriver ut kvittot för försäljningen. 
     */
    public void print() {
        printer.print(this.sale);
    }
}