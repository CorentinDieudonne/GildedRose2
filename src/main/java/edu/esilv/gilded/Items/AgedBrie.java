package edu.esilv.gilded.Items;

public class AgedBrie implements Strategy {
    private String name;
    private int quality;
    private int sellIn;
    AgedBrie(String name, int quality, int sellIn)
    {
        this.name=name;
        this.quality=quality;
        this.sellIn=sellIn;
    }

    @Override
    public void update(){
        System.out.print("This is an Aged Brie");
    }
}
