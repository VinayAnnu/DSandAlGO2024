package DesignPattern.ChainOfResponsibilityDesignPattern.VendingMachineSystem;

import java.util.HashMap;
import java.util.Map;

public class DispenseItemHandler extends VendingHandler {
    private Map<String, Integer> inventory = new HashMap<>();

    public DispenseItemHandler() {
        // Assume inventory is pre-filled with some items
        inventory.put("A1", 5);
        inventory.put("B1", 3);
    }

    @Override
    public void handleRequest(VendingRequest request) {
        if (inventory.containsKey(request.getItemCode()) && inventory.get(request.getItemCode()) > 0) {
            System.out.println("Dispensing item: " + request.getItemCode());
            inventory.put(request.getItemCode(), inventory.get(request.getItemCode()) - 1);
            if (nextHandler != null) {
                nextHandler.handleRequest(request);
            }
        }
    }
}
