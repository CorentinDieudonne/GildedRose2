package edu.esilv.gilded;

public abstract class InventoryPartDisplayVisitor implements InventoryPartVisitor {
    @Override
    public void visit(Inventory inventory) {
        System.out.println("Displaying Inventory.");
    }
    @Override
    public void visit(Item[] items) {
        System.out.println("Displaying Computer.");
    }
}
