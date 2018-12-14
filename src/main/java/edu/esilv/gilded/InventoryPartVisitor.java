package edu.esilv.gilded;

public interface InventoryPartVisitor {
    public void visit(Inventory inventory);
    public void visit(Item[] items);
}
