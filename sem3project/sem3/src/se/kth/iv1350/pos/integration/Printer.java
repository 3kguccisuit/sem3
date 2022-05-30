package se.kth.iv1350.pos.integration;

import se.kth.iv1350.pos.model.*;
import java.text.MessageFormat;


/**
 * Skrivare, skickar information till en extern skrivare. 
 */
public class Printer {
    
	public Printer() {
    }
    
    /**
     * Prints a recepit which in turns just prints a command.
     * @param Sale The recepit.
     * Skriver ut ett kvitto
     * @param Sale Kvittot 
     */
    public void print(Sale sale) {
        Receipt receipt = sale.getReceipt();
        System.out.println(MessageFormat.format("Affär: {0} Datum:{1}",receipt.getNameOfStore(), receipt.getTime()));
        
        int ind=0;
        for (Item item : sale.getItems()) {
            System.out.println(MessageFormat.format("Vara:     {1} st. {0} á {2} = {3}",
                            item.toString(), 
                            sale.getItemsQuantity().get(ind),
                            item.getItemDTO().getPrice()+item.getItemDTO().getVAT(),
                            (item.getItemDTO().getPrice()+item.getItemDTO().getVAT()) 
                            * sale.getItemsQuantity().get(ind)
                            ));
                            ind++;
		}
        System.out.println(MessageFormat.format("Totalt: SEK {0} varav moms: {1}",receipt.getTotalPrice(),receipt.getTotalVAT()));
    }
}
