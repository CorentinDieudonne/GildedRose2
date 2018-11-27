package edu.esilv.gilded;

public class ItemFactory {
    // TODO (PBZ) : it miss some imports ...
    //use getShape method to get object of type shape
    public Strategy getItem(String itemType) {
        if (itemType == null) {
            return null;
        }
        if (itemType.equalsIgnoreCase("+5 Dexterity Vest")) {
            return new Dexterity_Vest();

        } else if (itemType.equalsIgnoreCase("à modifier")) {
            return new Dexterity_Vest();
        }

            return null;

    }
}