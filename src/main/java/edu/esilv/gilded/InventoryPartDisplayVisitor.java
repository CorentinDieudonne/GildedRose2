package edu.esilv.gilded;

public abstract class InventoryPartDisplayVisitor implements InventoryPartVisitor {
    public void visit(Inventory inventory) {
        System.out.println("Displaying Inventory.");
    }
    public void visit(Item[] items) {
        System.out.println("Displaying Computer.");
    }
}
