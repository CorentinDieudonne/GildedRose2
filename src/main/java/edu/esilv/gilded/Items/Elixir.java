package edu.esilv.gilded.Items;

import java.time.LocalDateTime;

public class Elixir implements Strategy {
    private String name;
    private int quality;
    private int sellIn;
    int id;
    LocalDateTime date;
    Elixir(String name, int quality, int sellIn, int id, LocalDateTime date)
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
            quality = quality - 1;
        }
        else
        {
            quality = quality - 2;
        }
        if (quality <= 0)
        {
            quality = 0;
        }
        sellIn = sellIn - 1;
    }
}
