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
        if (sellIn >= 0)
        {
            quality = quality - 2;
        }
        else
        {
            quality = quality - 4;
        }
        if (quality <= 0)
        {
            quality = 0;
        }
        sellIn = sellIn - 1;
    }
}