package test.java.se.kth.iv1350.pos.model;

import java.util.List;


import org.junit.Test;

import se.kth.iv1350.pos.model.Item;
import se.kth.iv1350.pos.model.ItemDTO;
import se.kth.iv1350.pos.model.Sale;
import se.kth.iv1350.pos.model.SaleDTO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


public class SaleTest {
    private Sale sale;
    private SaleDTO saleDTO;
    
    public SaleTest() {
        sale = new Sale();
        saleDTO = new SaleDTO(java.time.LocalTime.now(), 0, 0, null); 
    }

    @Test
    public void testAddItem() {
        System.out.println("addItem");
        ItemDTO itemDTO = new ItemDTO("Nötfärs 500g", 87, 12);
        Item item = new Item(1, itemDTO, 100);
        int quantity = 1;
        String expResult = "Nötfärs 500g";
        sale.addItem(item, quantity);
        String result = sale.getSaleInformation().getItems().get(0).getItemDTO().getItemDescription();
        assertEquals("Expected result did not equal result",expResult, result);
    }
    
    @Test
    public void testAddItemTotalPrice() {
        System.out.println("addItemTotalPrice");
        ItemDTO itemDTO = new ItemDTO("Nötfärs 500g", 87, 12);
        Item item = new Item(1, itemDTO, 100);
        int quantity = 1;
        double expResult = 99;
        sale.addItem(item, quantity);
        double result = sale.getSaleInformation().getTotalPrice();
        //assertEquals("Expected result did not equal result",expResult, result);
        assertEquals("Expected result did not equal result", expResult,result, 0);
   
    }
    
    @Test
    public void testAddItemTotalVAT() {
        System.out.println("addItemTotalVAT");
        ItemDTO itemDTO = new ItemDTO("Nötfärs 500g", 87, 12);
        Item item = new Item(1, itemDTO, 100);
        int quantity = 1;
        double expResult = 12;
        sale.addItem(item, quantity);
        double result = sale.getSaleInformation().getTotalVAT();
        assertEquals("Expected result did not equal result", expResult,result, 0);
    }

    @Test
    public void isScanned() {
        System.out.println("isDuplicateItem");
        ItemDTO itemDTO = new ItemDTO("Nötfärs 500g", 87, 12);
        Item item = new Item(1, itemDTO, 100);
        Item item2 = new Item(1, itemDTO, 100);
        int quantity = 1;
        sale.addItem(item, quantity);
        sale.addItem(item2, quantity);
        
        int expResult = 2;
        int result = sale.getItemsQuantity().get(0);
        assertEquals("Expected result did not equal result",expResult, result);
    }
    
    @Test
    public void testIsNotDuplicateItem() {
        System.out.println("isNotDuplicateItem");
        ItemDTO itemDTO = new ItemDTO("Nötfärs 500g", 87, 12);
        Item item = new Item(1, itemDTO, 100);
        Item item2 = new Item(2, itemDTO, 100);
        int quantity = 1;
        sale.addItem(item, quantity);
        sale.addItem(item2, quantity);
        
        int expResult = 1;
        int result = sale.getItemsQuantity().get(0);
        assertEquals("Expected result did not equal result",expResult, result);
    }   
}