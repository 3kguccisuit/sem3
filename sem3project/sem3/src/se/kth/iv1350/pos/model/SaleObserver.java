package se.kth.iv1350.pos.model;
/**
 * Gränssnitt SaleObserver är en abstrakt klass som
 * som grupperar newSale-strukturen.
 */
public interface SaleObserver {
    /**
     * @param totalPrice får det totala priset för 
     * försäljningen (inklusive moms)  
     */
    public void newSale(double totalPrice);
}
