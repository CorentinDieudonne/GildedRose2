package edu.esilv.gilded;

import java.time.LocalDateTime;

public class Ragnaros extends Item{

    public Ragnaros(){

    }
    public Ragnaros(String name, int sellIn, int quality, int id, LocalDateTime date) {
        super();
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
        this.id=id;
        this.date=date;
    }
    public void update()
    {
    }
}
