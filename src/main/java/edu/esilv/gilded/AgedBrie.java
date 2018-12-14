package edu.esilv.gilded;

import java.time.LocalDateTime;

public class AgedBrie extends Item {

    public AgedBrie(){

    }
    public AgedBrie(String name, int sellIn, int quality, int id, LocalDateTime date) {
        super();
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
        this.id=id;
        this.date=date;
    }
    public void update()
    {
        if (sellIn > 0) {
            quality++;
        }
        else {
            quality+=2;
        }
        if (quality>50) {
            quality = 50;
        }
        sellIn--;
    }
}
