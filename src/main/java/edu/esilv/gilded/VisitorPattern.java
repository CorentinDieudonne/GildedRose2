package edu.esilv.gilded;

public abstract class VisitorPattern {
    public static void main(String[] args) {

        InventoryPart computer = new Inventory();
        computer.accept(new InventoryPartDisplayVisitor() {
        });
    }
}
