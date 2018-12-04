package edu.esilv.gilded.Items;

import java.time.LocalDateTime;
import java.util.List;

public class Concert implements Strategy {
    private String name;
    private int quality;
    private int sellIn;
    int id;
    LocalDateTime date;
    List<Concert> liste;
    public Concert(String name, int quality, int sellIn, int id, LocalDateTime date, List<Concert> liste) {
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

    public List<Concert> getListe() {
        return liste;
    }

    public void setListe(List<Concert> liste) {
        this.liste = liste;
    }



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