package edu.esilv.gilded;
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
                new Item("+5 Dexterity Vest", 10, 20,1, LocalDateTime.now().minusDays(1)),
                new Item("Aged Brie", 2, 0,2,LocalDateTime.now().minusHours(10)),
                new Item("Elixir of the Mongoose", 5, 7,3,LocalDateTime.now().minusDays(2)),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80,4,LocalDateTime.now().minusDays(5)),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20,5,LocalDateTime.now().minusDays(1)),
                new Item("Conjured Mana Cake", 3, 6,6,LocalDateTime.now().minusDays(4)),
                new Item("+5 Dexterity Vest", 10, 20,7, LocalDateTime.now().minusHours(6))
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
