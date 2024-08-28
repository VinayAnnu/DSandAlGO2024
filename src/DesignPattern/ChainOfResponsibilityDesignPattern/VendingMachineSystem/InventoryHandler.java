package DesignPattern.ChainOfResponsibilityDesignPattern.VendingMachineSystem;

import java.util.HashMap;
import java.util.Map;

public class InventoryHandler extends VendingHandler {
    private Map<String, Integer> inventory = new HashMap<>();

    public InventoryHandler() {
        // Assume inventory is pre-filled with some items
        inventory.put("A1", 5);
        inventory.put("A2", 0);  // Out of stock
        inventory.put("B1", 3);
    }

    @Override
    public void handleRequest(VendingRequest request) {
        if (inventory.containsKey(request.getItemCode()) && inventory.get(request.getItemCode()) > 0) {
            System.out.println("Item " + request.getItemCode() + " is in stock.");
            if (nextHandler != null) {
                nextHandler.handleRequest(request);
            }
        } else {
            System.out.println("Item " + request.getItemCode() + " is out of stock.");
        }
    }
}
