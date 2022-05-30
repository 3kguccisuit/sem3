package se.kth.iv1350.pos.startup;

import se.kth.iv1350.pos.view.View;
import se.kth.iv1350.pos.controller.Controller;
import se.kth.iv1350.pos.integration.*;

/**
 * Startar hela applikationen, innehåller main som används för att starta applikationen
 */
public class Main {
    /**
     * Main metoden används för att starta applikationen
     * @param args Applikationen tar inga command line parameters.
     */
    public static void main(String[] args) {
    	
        Printer printer = new Printer();
        ExternalAccountingSystem eas = new ExternalAccountingSystem();
        ExternalInventorySystem eis = new ExternalInventorySystem();

        Controller contr = new Controller(printer, eas, eis);
        View view = new View(contr);
        
        view.runPOS();
    }
}
