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
        if (sellIn >= 0)
        {
            quality = quality + 1;
        }
        else
        {
            quality = quality + 2;
        }
        if (quality > 50)
        {
            quality = 50;
        }
        sellIn = sellIn - 1;
    }
}
