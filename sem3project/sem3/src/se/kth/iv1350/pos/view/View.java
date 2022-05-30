package se.kth.iv1350.pos.view;

import se.kth.iv1350.pos.controller.Controller;
import se.kth.iv1350.pos.model.*;

/**
 *  View av programmet kör en runPOS.
 */
public class View {
    private Controller contr;

    /**
     * Skapar en ny instans som använder den angivna controller för alla anrop till andra lager.
     * 
     * @param contr  Controller används för alla anrop till andra lager
     */
    public View(Controller contr) {
        this.contr = contr;
    }

    /**
     * Kör en falsk försäljning genom att anropa alla operationer i controller
     */
    public void runPOS() {
        contr.startSale();
        System.out.println("Försäljning startad.");

        SaleDTO saleDTO = contr.enterItem(1, 5);
        System.out.println("Föremål: " + saleDTO.getItems().get(0).getItemDTO().getItemDescription() +
                "    " + saleDTO.getItems().get(0).getItemDTO().getPrice() + " SEK");

        System.out.println("Totala kostander:                                      " + saleDTO.getTotalPrice() + " SEK\n");

        saleDTO = contr.enterItem(2, 1);
        System.out.println("Föremål: " + saleDTO.getItems().get(1).getItemDTO().getItemDescription() +
                "                   " + saleDTO.getItems().get(1).getItemDTO().getPrice() + " SEK");

        System.out.println("Totala kostander:                                      " + saleDTO.getTotalPrice() + " SEK\n");


        saleDTO = contr.enterItem(3, 1);
        System.out.println("Föremål: " + saleDTO.getItems().get(2).getItemDTO().getItemDescription() +
                "                   " + saleDTO.getItems().get(2).getItemDTO().getPrice() + " SEK");

        System.out.println("Totala kostander:                                      " + saleDTO.getTotalPrice() + " SEK\n");


        saleDTO = contr.enterItem(4, 1);
        System.out.println("Föremål: " + saleDTO.getItems().get(3).getItemDTO().getItemDescription() +
                "                   " + saleDTO.getItems().get(3).getItemDTO().getPrice() + " SEK");

        System.out.println("Totala kostander:                                      " + saleDTO.getTotalPrice() + " SEK\n");

        contr.endSale();
        System.out.println("\n           Kvitto\n*****************************");
        double change = contr.pay(1100, "Kontant");
        System.out.println("Växel:              " + change + " SEK");
        contr.print();
        System.out.println("*****************************");
    }
}
