package edu.esilv.gilded;

import edu.esilv.gilded.Items.*;

public class ItemFactory {
    // TODO (PBZ) : it miss some imports ...
    //use getShape method to get object of type shape
    public Strategy getItem(String itemType) {
        if (itemType == null) {
            return null;
        }
        if (itemType.equalsIgnoreCase("+5 Dexterity Vest")) {
            return new Aged_Brie();

        } else if (itemType.equalsIgnoreCase("à modifier")) {
            return new Concert();

        } else if (itemType.equalsIgnoreCase("à modifier")) {
            return new Dexterity_Vest();

        } else if (itemType.equalsIgnoreCase("à modifier")) {
            return new Elixir();

        } else if (itemType.equalsIgnoreCase("à modifier")) {
            return new Mana_Cake();
        } else if (itemType.equalsIgnoreCase("à modifier")) {
            return new Ragnaros();
        }
        return null;


    }
}