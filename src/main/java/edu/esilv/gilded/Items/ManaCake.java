package edu.esilv.gilded.Items;

public class ManaCake implements Strategy {
    private String name;
    private int quality;
    private int sellIn;
    ManaCake(String name, int quality, int sellIn)
    {
        this.name=name;
        this.quality=quality;
        this.sellIn=sellIn;
    }
    @Override
    public void update(){
        System.out.print("This is a Mana_Cake");
    }
}