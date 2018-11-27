package edu.esilv.gilded.Items;

public class DexterityVest implements Strategy {
    private String name;
    private int quality;
    private int sellIn;
    DexterityVest(String name, int quality, int sellIn)
    {
        this.name=name;
        this.quality=quality;
        this.sellIn=sellIn;
    }
    @Override
    public void update() {
        System.out.println("This is a dexterity vest");
    }
}
