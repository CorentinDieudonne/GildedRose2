package edu.esilv.gilded.Items;

import java.time.LocalDateTime;

public class AgedBrie implements Strategy {
    private String name;
    private int quality;
    private int sellIn;
    int id;
    LocalDateTime date;
    AgedBrie(String name, int quality, int sellIn, int id, LocalDateTime date)
    {
        this.name=name;
        this.quality=quality;
        this.sellIn=sellIn;
        this.id=id;
        this.date=date;
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
