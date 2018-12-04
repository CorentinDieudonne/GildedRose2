package edu.esilv.gilded.Items;

import java.time.LocalDateTime;
import java.util.List;

public class AgedBrie implements Strategy {
    private String name;
    private int quality;
    private int sellIn;
    LocalDateTime date;
    List<AgedBrie> liste;

    public AgedBrie(String name, int quality, int sellIn, int id, LocalDateTime date, List<AgedBrie> liste) {
        this.name = name;
        this.quality = quality;
        this.sellIn = sellIn;
        this.id = id;
        this.date = date;
        this.liste = liste;
    }

    int id;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public int getSellIn() {
        return sellIn;
    }

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public List<AgedBrie> getListe() {
        return liste;
    }

    public void setListe(List<AgedBrie> liste) {
        this.liste = liste;
    }


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
