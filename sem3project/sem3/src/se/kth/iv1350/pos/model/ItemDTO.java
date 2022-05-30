package se.kth.iv1350.pos.model;

/**
 * Item data transfer object, grupperar ihop variabler för objekt.
 */
public class ItemDTO {
    private String itemDescription;
    private double price;
    private double VAT;
    
    /**
     * Skapar en instans av ItemDTO
     * @param itemDescription Beskriver ett föremål.
     * @param price Priset på varan
     * @param VAT  Moms på föremålet
     */
    public ItemDTO(String itemDescription, double price, double VAT) {
    	this.itemDescription = itemDescription;
        this.price = price;
        this.VAT = VAT;
    }
    
    /**
     * Returnerar artikelbeskrivningen.
     * @return itemDescription.
     */
    public String getItemDescription() {
        return this.itemDescription;
    }
    
    /**
     * Retunerar priset på varan
     * @return priset på varan.
     */
    public double getPrice() {
        return this.price;
    }
    
    /**
     * Returnerar moms för varan.
     * @return mom för varan
     */
    public double getVAT() {
        return this.VAT;
    }
    
}