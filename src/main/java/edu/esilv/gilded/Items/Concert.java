package edu.esilv.gilded.Items;

public class Concert implements Strategy {
    private String name;
    private int quality;
    private int sellIn;
    Concert(String name, int quality, int sellIn)
    {
        this.name=name;
        this.quality=quality;
        this.sellIn=sellIn;
    }
    @Override
    public void update() {
        if (sellIn > 10)
        {
            quality = quality - 1;
        }
        else if (sellIn > 5)
        {
            quality = quality - 2;
        }
        else
        {
            quality = quality + 3;
        }
        if (sellIn == 0)
        {
            quality = 0;
        }
        if (quality > 50)
        {
            quality = 50;
        }
        sellIn = sellIn - 1;
    }
}