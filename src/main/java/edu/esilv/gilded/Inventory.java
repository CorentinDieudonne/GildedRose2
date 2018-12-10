package edu.esilv.gilded;

import cucumber.api.java.it.Ma;

import java.time.LocalDateTime;


public class Inventory implements InventoryPart{
    public Item[] items;

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

    public void printInventory() {
        System.out.println("***************");
        for (Item item : items) {
            System.out.println(item);
        }
        System.out.println("***************");
        System.out.println("\n");
    }


    public void itemlegacy()
    {
        for (int i = 0; i < items.length; i++) {
            if (items[i].getName().equals("Aged Brie")){
                AgedBrie brie = new AgedBrie(items[i].getName(),items[i].getSellIn(), items[i].getQuality(), items[i].getId(), items[i].getDate());
                items[i]=brie;
            }
            if (items[i].getName().equals("Backstage passes to a TAFKAL80ETC concert")){
                Concert concert = new Concert(items[i].getName(),items[i].getSellIn(), items[i].getQuality(), items[i].getId(), items[i].getDate());
                items[i]=concert;
            }
            if (items[i].getName().equals("+5 Dexterity Vest")){
                DexterityVest vest = new DexterityVest(items[i].getName(),items[i].getSellIn(), items[i].getQuality(), items[i].getId(), items[i].getDate());
                items[i]=vest;
            }
            if (items[i].getName().equals("Elixir of the Mongoose")){
                Elixir elixir = new Elixir(items[i].getName(),items[i].getSellIn(), items[i].getQuality(), items[i].getId(), items[i].getDate());
                items[i]=elixir;
            }
            if (items[i].getName().equals("Conjured Mana Cake")){
                ManaCake cake = new ManaCake(items[i].getName(),items[i].getSellIn(), items[i].getQuality(), items[i].getId(), items[i].getDate());
                items[i]=cake;
            }
            if (items[i].getName().equals("Sulfuras, Hand of Ragnaros")){
                Ragnaros ragnaros = new Ragnaros(items[i].getName(),items[i].getSellIn(), items[i].getQuality(), items[i].getId(), items[i].getDate());
                items[i]=ragnaros;
            }
        }
    }


    public void updateQuality() {

        for (int i = 0; i < items.length; i++) {
            items[i].update();
        }
        /*
        for (int i = 0; i < items.length; i++) {
            if (items[i].getName().equals("Aged Brie")){
                AgedBrie brie = new AgedBrie(items[i].getName(),items[i].getSellIn(), items[i].getQuality(), items[i].getId(), items[i].getDate());
                items[i]=brie;
            }
            if (items[i].getName().equals("Backstage passes to a TAFKAL80ETC concert")){
                Concert concert = new Concert(items[i].getName(),items[i].getSellIn(), items[i].getQuality(), items[i].getId(), items[i].getDate());
                items[i]=concert;
            }
            if (items[i].getName().equals("+5 Dexterity Vest")){countVest++;}
            if (items[i].getName().equals("Elixir of the Mongoose")){countElixir++;}
            if (items[i].getName().equals("Conjured Mana Cake")){countCake++;}
            if (items[i].getName().equals("Sulfuras, Hand of Ragnaros")){countRagnaros++;}
        }

        /*
        for (int i = 0; i < items.length; i++) {
            if (!items[i].getName().equals("Aged Brie")
                    && !items[i].getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].getQuality() > 0) {
                    if (!items[i].getName().equals("Sulfuras, Hand of Ragnaros")) {
                        items[i].setQuality(items[i].getQuality() - 1);
                    }
                }
                if(items[i].getSellIn()<0){
                    items[i].setQuality(items[i].getQuality()-2);
                }
            } else {
                if (items[i].getQuality() < 50) {
                    items[i].setQuality(items[i].getQuality() + 1);

                    if (items[i].getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
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
            if (!items[i].getName().equals("Sulfuras, Hand of Ragnaros") && !items[i].getName().equals("Aged Brie")) {
                items[i].setSellIn(items[i].getSellIn() - 1);
            }

            if (items[i].getSellIn() < 0) {
                if (!items[i].getName().equals("Aged Brie")) {
                    if (!items[i].getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].getQuality() > 0) {
                            if (!items[i].getName().equals("Sulfuras, Hand of Ragnaros")) {
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
                items[i].setSellIn(items[i].getSellIn()-1);
            }
        }
        */

    }
    public void accept(InventoryPartVisitor inventoryPartVisitor) { }


    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        for (int i = 0; i < 11; i++) {
            inventory.itemlegacy();
            inventory.updateQuality();
            inventory.printInventory();
        }
    }
}
