package edu.esilv.gilded.Items;

import java.time.LocalDateTime;
import java.util.List;

public class ManaCake implements Strategy {
    private String name;
    private int quality;
    private int sellIn;
    int id;
    LocalDateTime date;
    List<ManaCake> liste;


    public ManaCake(String name, int quality, int sellIn, int id, LocalDateTime date, List<ManaCake> liste) {
        this.name = name;
        this.quality = quality;
        this.sellIn = sellIn;
        this.id = id;
        this.date = date;
        this.liste = liste;
    }


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

    public List<ManaCake> getListe() {
        return liste;
    }

    public void setListe(List<ManaCake> liste) {
        this.liste = liste;
    }


    ManaCake(String name, int quality, int sellIn, int id, LocalDateTime date)
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
            quality = quality - 2;
        }
        else
        {
            quality = quality - 4;
        }
        if (quality <= 0)
        {
            quality = 0;
        }
        sellIn = sellIn - 1;
    }
}