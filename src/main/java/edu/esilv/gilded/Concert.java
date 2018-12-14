package edu.esilv.gilded;

import java.time.LocalDateTime;

public class Concert extends Item{

    public Concert(){

    }
    public Concert(String name, int sellIn, int quality, int id, LocalDateTime date) {
        super();
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
        this.id=id;
        this.date=date;
    }
    public void update()
    {
        if (sellIn > 10) {
            quality++;
        }
        else if (sellIn > 5) {
            quality+=2;
        }
        else if (sellIn > 0) {
            quality+=3;
        }
        else if (sellIn == 0) {
            quality=0;
        }
        if (quality>50) {
            quality = 50;
        }
        sellIn--;
    }
}
