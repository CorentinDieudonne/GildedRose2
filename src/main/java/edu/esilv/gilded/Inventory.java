package edu.esilv.gilded;

import java.time.LocalDateTime;

public class Inventory implements InventoryPart{
    private Item[] items;

    public Inventory(Item[] items) {
        super();
        this.items = items;
    }

    public Item[] getItems() {return items;}

// PBEZAULT@yahoo.fr

    public Inventory() {
        super();
        items = new Item[]{
                new Item("+5 Dexterity Vest", 10, 20,1, LocalDateTime.now()),
                new Item("Aged Brie", 2, 0,2,LocalDateTime.now()),
                new Item("Elixir of the Mongoose", 5, 7,3,LocalDateTime.now()),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80,4,LocalDateTime.now()),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20,5,LocalDateTime.now()),
                new Item("Conjured Mana Cake", 3, 6,6,LocalDateTime.now()),
                new Item("+5 Dexterity Vest", 10, 20,7, LocalDateTime.now())
        };

    }

    private void printInventory() {
        System.out.println("***************");
        for (Item item : items) {
            System.out.println(item);
        }
        System.out.println("***************");
        System.out.println("\n");
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (items[i].getName() != "Aged Brie"
                    && items[i].getName() != "Backstage passes to a TAFKAL80ETC concert") {
                if (items[i].getQuality() > 0) {
                    if (items[i].getName() != "Sulfuras, Hand of Ragnaros") {
                        items[i].setQuality(items[i].getQuality() - 1);
                    }
                }
                if(items[i].getSellIn()<0){
                    items[i].setQuality(items[i].getQuality()-2);
                }
            } else {
                if (items[i].getQuality() < 50) {
                    items[i].setQuality(items[i].getQuality() + 1);

                    if (items[i].getName() == "Backstage passes to a TAFKAL80ETC concert") {
                        if (items[i].getSellIn() < 11) {
                            if (items[i].getQuality() < 50) {
                                items[i].setQuality(items[i].getQuality() + 2);
                            }
                        }

                        if (items[i].getSellIn() < 6) {
                            if (items[i].getQuality() < 50) {
                                items[i].setQuality(items[i].getQuality() + 3);
                            }
                        }
                        if(items[i].getSellIn()<1){
                            items[i].setQuality(0);
                        }
                    }
                }
            }
            if (items[i].getName() != "Sulfuras, Hand of Ragnaros" && items[i].getName()!="Aged Brie") {
                items[i].setSellIn(items[i].getSellIn() - 1);
            }

            if (items[i].getSellIn() < 0) {
                if (items[i].getName() != "Aged Brie") {
                    if (items[i].getName() != "Backstage passes to a TAFKAL80ETC concert") {
                        if (items[i].getQuality() > 0) {
                            if (items[i].getName() != "Sulfuras, Hand of Ragnaros") {
                                items[i].setQuality(items[i].getQuality() - 1);
                            }
                        }
                    } else {
                        items[i].setQuality(0);
                    }
                } else {
                    if (items[i].getQuality() < 50) {
                        items[i].setQuality(items[i].getQuality() + 1);
                    }
                }
            }
            if("Aged Brie".equals(items[i].getName()) && items[i].getQuality()<50){
                items[i].setQuality(items[i].getQuality()+1);
                items[i].setSellIn(items[i].getSellIn()-1);
            }
        }
    }
    public void accept(InventoryPartVisitor inventoryPartVisitor) { }

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        for (int i = 0; i < 10; i++) {
            inventory.updateQuality();
            inventory.printInventory();
        }
    }
}
