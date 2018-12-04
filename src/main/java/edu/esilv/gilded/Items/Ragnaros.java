package edu.esilv.gilded.Items;

import java.time.LocalDateTime;

public class Ragnaros implements Strategy {
    private String name;
    private int quality;
    private int sellIn;
    int id;
    LocalDateTime date;

    Ragnaros(String name, int quality, int sellIn,int id, LocalDateTime date)
    {
        this.name=name;
        this.quality=quality;
        this.sellIn=sellIn;
        this.id=id;
        this.date=date;
    }
    @Override
    public void update(){
    }
}
