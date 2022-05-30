package se.kth.iv1350.pos.model;

import java.util.*;
import se.kth.iv1350.pos.model.*;
import se.kth.iv1350.pos.view.View;
import se.kth.iv1350.pos.controller.Controller;
import se.kth.iv1350.pos.integration.*;

/**
 * Representerar kvittot av hela försäljningen.
 */
public class Receipt {
    private SaleDTO saleInformation;
    private java.util.Date time;
    private String storeName;
    private double totalVAT;
    private double totalPrice;
    private List<Item> nameOfItems;
    
    /**
     * Skapar en instans av ett kvitto.
     * @param saleInformation innehåller saleDTO, som har all info om försäljningen.
     */
    public Receipt(SaleDTO saleInformation) {
        this.time = new Date();
        this.saleInformation = saleInformation;
        this.nameOfItems = saleInformation.getItems();
        this.totalVAT = saleInformation.getTotalVAT();
        this.totalPrice = saleInformation.getTotalPrice();
        this.storeName = saleInformation.getNameOfStore();

    }
    
    /**
     * Returnerar aktuell tid och datum.
     * @return time är den aktuella tidpunkten för försäljningen.
     */
    public java.util.Date getTime() {
        return this.time;
    }
    
    /**
     * Returnerar namnet på butiken.
     * @return storeName är namnet på butiken.
     */
    public String getNameOfStore() {
        return this.storeName;
    }
    
    
    /**
     * Retunerar totala momsen
     * @return totalVAT är totala momsen för försäljningen
     */
    public double getTotalVAT() {
        return this.totalVAT;
    }
    
    /**
     * Returnerar det totala priset.
     * @return totalPrice är det totala priset för försäljningen
     */
    public double getTotalPrice() {
        return this.totalPrice;
    }
    
    /**
     * Returnerar en arraylista som innehåller namnen på alla varor
     * @return nameOfItems är listan över alla varor
     */
    public List<Item> getNameOfItems() {
        return this.nameOfItems;
    }
}
