package edu.esilv.gilded.Items;

public class Elixir implements Strategy {
    private String name;
    private int quality;
    private int sellIn;
    Elixir(String name, int quality, int sellIn)
    {
        this.name=name;
        this.quality=quality;
        this.sellIn=sellIn;
    }
    @Override
    public void update(){
        sellIn = sellIn - 1;
        if (sellIn >0)
        {
            quality = quality - 1;
        }
        else
        {
            quality = quality - 2;
        }
        if (quality < 0)
        {
            quality = 0;
        }

    }
}
