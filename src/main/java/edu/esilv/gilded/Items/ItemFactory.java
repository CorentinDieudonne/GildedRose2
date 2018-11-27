package edu.esilv.gilded.Items;

import edu.esilv.gilded.Items.*;

public class ItemFactory {
    // TODO (PBZ) : it miss some imports ...
    //use getShape method to get object of type shape
    public Strategy getItem(String itemType) {
        if (itemType == null) {
            return null;
        }
        if (itemType.equalsIgnoreCase("Aged Brie")) {
            return new Aged_Brie();

        } else if (itemType.equalsIgnoreCase("Backstage passes to a TAFKAL80ETC concert")) {
            return new Concert();

        } else if (itemType.equalsIgnoreCase("+5 Dexterity Vest")) {
            return new Dexterity_Vest();

        } else if (itemType.equalsIgnoreCase("Elixir of the Mongoose")) {
            return new Elixir();

        } else if (itemType.equalsIgnoreCase("Conjured Mana Cake")) {
            return new Mana_Cake();

        } else if (itemType.equalsIgnoreCase("Sulfuras, Hand of Ragnaros")) {
            return new Ragnaros();
        }
        return null;


    }
}