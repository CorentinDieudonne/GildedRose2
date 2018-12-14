package edu.esilv.gilded;

import java.time.LocalDateTime;

public class DexterityVest extends Item{

    public  DexterityVest(){

    }
    public  DexterityVest(String name, int sellIn, int quality, int id, LocalDateTime date) {
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
            quality--;
        }
        else {
            quality-=2;
        }
        if (quality<0) {
            quality = 0;
        }
        sellIn--;
    }
}
