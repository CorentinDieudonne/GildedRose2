package edu.esilv.gilded.Items;

import java.time.LocalDateTime;

public class Concert implements Strategy {
    private String name;
    private int quality;
    private int sellIn;
    int id;
    LocalDateTime date;
    Concert(String name, int quality, int sellIn, int id, LocalDateTime date)
    {
        this.name=name;
        this.quality=quality;
        this.sellIn=sellIn;
        this.date=date;
        this.id=id;
    }
    @Override
    public void update() {
        if (sellIn >= 10)
        {
            quality = quality - 1;
        }
        else if (sellIn >= 5)
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