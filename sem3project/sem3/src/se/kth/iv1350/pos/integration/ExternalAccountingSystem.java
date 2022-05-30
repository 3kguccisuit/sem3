package se.kth.iv1350.pos.integration;

import se.kth.iv1350.pos.model.*;
import se.kth.iv1350.pos.view.View;
import se.kth.iv1350.pos.controller.Controller;
import se.kth.iv1350.pos.integration.*;

/**
 * External accounting system, hanterar växeln i kassan.
 */
public class ExternalAccountingSystem {
    private int storeBalance;
    
    /**
     * Butikens start saldo.
     */
    public ExternalAccountingSystem() {
        this.storeBalance = 1000;
    }
    
    /**
     * Uppdaterar butikens kassa med amount.
     * @param amount Pengar som fås av kund.
     * @return returnerar butikens saldo
     */
    public int update(double amount) {
    	this.storeBalance  += amount;
      return this.storeBalance;
    }
  
    // /**
    //  * Returns store balance.
    //  * @return returns store balance.
    //  */
    // public int getStoreBalance() {
    // 	return this.storeBalance;
    // }
}
