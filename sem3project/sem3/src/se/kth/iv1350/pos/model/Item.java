package se.kth.iv1350.pos.model;
import java.text.MessageFormat;

/**
 * Denna klass representerar en vara.
 */
public class Item {
    private ItemDTO itemDTO;
    private int storeQuantity;
    private int itemIdentifier; 
    
    /**
     * Skapar en instans av klassen Item.
     * @param itemIdentifier Varans identifierare
     * @param itemDTO The data transfer object för varan.
     * @param quantity Varans kvantitet.
     */


    public Item(int itemIdentifier, ItemDTO itemDTO, int quantity) {
        this.itemIdentifier = itemIdentifier;
        this.itemDTO = itemDTO;
        this.storeQuantity = quantity;
    }
    
    /**
     * Returnerar artikelidentifierare
     * @return artikelidentifierare.
     */
    public int getItemIdentifier() {
    	return this.itemIdentifier;
    }
    
    /**
     * Retunerar butikens kvantitet av en vara.
     * @return antal varor i butiken.
     */
    public int getStoreQuantity() {
    	return this.storeQuantity;
    }



    public String toString() {
        return MessageFormat.format("{0}",this.itemDTO.getItemDescription());
    }

    /**
     * Uppdaterar kvantiteten av en vara i butiken.
     * @param bought_quantity Kvantiteten av en vara som kunden har köpt
     */
    public void updateQuantity(int bought_quantity){
    	this.storeQuantity -= bought_quantity;
    }
    
    /**
     * Returnerar DTO för en vara.
     * @return ItemDTO för varan
     */
    public ItemDTO getItemDTO() {
    	return this.itemDTO; 
    }
}
