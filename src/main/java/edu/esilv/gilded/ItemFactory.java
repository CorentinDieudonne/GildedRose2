package edu.esilv.gilded;

public class ItemFactory {
    // TODO (PBZ) : it miss some imports ...
    Strategy agedBriedStrategy=new AgedBrieStrategy();
    public Item buildItem(String itemType,Inventory inventory){
        Item newItem=null;
        if(AGED_BRIE.equals(itemType)){
            newItem=new Item(AGED_BRIE,sellin:10,quality:20,ageBrieStrategy);
        }
        inventory.add(newItem);
        return newItem;
    }