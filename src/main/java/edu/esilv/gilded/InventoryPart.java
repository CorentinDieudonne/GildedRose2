package edu.esilv.gilded;

public interface InventoryPart {
    public void accept(InventoryPartVisitor inventoryPartVisitor);
}
