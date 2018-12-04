package edu.esilv.gilded.Items;

import java.time.LocalDateTime;

public class ItemFactory {
    // TODO (PBZ) : it miss some imports ...
    //use getShape method to get object of type shape
    public Strategy getItem(String itemType, int quality, int sellIn, int id, LocalDateTime date) {
        if (itemType == null) {
            return null;
        }
        if (itemType.equalsIgnoreCase("Aged Brie")) {
            return new AgedBrie(itemType, quality, sellIn,id ,date);

        } else if (itemType.equalsIgnoreCase("Backstage passes to a TAFKAL80ETC concert")) {
            return new Concert(itemType, quality, sellIn, id, date);

        } else if (itemType.equalsIgnoreCase("+5 Dexterity Vest")) {
            return new DexterityVest(itemType, quality, sellIn, id, date);

        } else if (itemType.equalsIgnoreCase("Elixir of the Mongoose")) {
            return new Elixir(itemType, quality, sellIn,id, date);

        } else if (itemType.equalsIgnoreCase("Conjured Mana Cake")) {
            return new ManaCake(itemType, quality, sellIn,id,date);

        } else if (itemType.equalsIgnoreCase("Sulfuras, Hand of Ragnaros")) {
            return new Ragnaros(itemType, quality, sellIn,id,date);
        }
        return null;


    }
}