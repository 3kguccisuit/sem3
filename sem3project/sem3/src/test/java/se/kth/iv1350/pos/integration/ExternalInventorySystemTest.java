package test.java.se.kth.iv1350.pos.integration;


import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import se.kth.iv1350.pos.integration.ExternalInventorySystem;
import se.kth.iv1350.pos.model.Item;
import se.kth.iv1350.pos.model.ItemDTO;
import se.kth.iv1350.pos.model.Sale;

public class ExternalInventorySystemTest {
    private ExternalInventorySystem eis;
    
    public ExternalInventorySystemTest() {
           eis = new ExternalInventorySystem();  
    }

    @Test
    public void testAddItem() {
        System.out.println("addItem");
        eis.addItem();
        
        ItemDTO itemDTO = new ItemDTO("Nötfärs 500g", 87, 12);
        String expResult = itemDTO.getItemDescription();
        String result = eis.getItems().get(0).getItemDTO().getItemDescription();
        assertEquals("Expected result did not equal result",expResult, result);
        
    }

    @Test
    public void testSearchValid() {
        System.out.println("search valid identifier");
        eis.addItem();
        int itemIdentifier = 1;

        String expResult = "Nötfärs 500g";;
        Item item = eis.search(itemIdentifier);
        String result = item.getItemDTO().getItemDescription();
        assertEquals("Expected result did not equal result",expResult, result);
    }
    
    @Test
    public void testSearchNotValid() {
        System.out.println("search not valid identifier");
        eis.addItem();
        int itemIdentifier = 5;

        Item expResult = null;
        Item result = eis.search(itemIdentifier);
        assertEquals("Expected result did not equal result",expResult, result);
    }

    @Test
    public void testUpdate() {
        System.out.println("update");
        Sale sale = new Sale();
        eis.addItem();
        
        sale.addItem(eis.getItems().get(0), 1); 
        eis.update(sale);
        int expResult = 99;
        int result = sale.getItems().get(0).getStoreQuantity();
        assertEquals("Expected result did not equal result",expResult, result);
    }   
}