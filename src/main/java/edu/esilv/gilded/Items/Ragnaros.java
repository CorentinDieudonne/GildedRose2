package edu.esilv.gilded.Items;

import java.time.LocalDateTime;
import java.util.List;

public class Ragnaros implements Strategy {
    private String name;
    private int quality;
    private int sellIn;
    int id;
    LocalDateTime date;
    List<Ragnaros> liste;


    public Ragnaros(String name, int quality, int sellIn, int id, LocalDateTime date, List<Ragnaros> liste) {
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

    public List<Ragnaros> getListe() {
        return liste;
    }

    public void setListe(List<Ragnaros> liste) {
        this.liste = liste;
    }


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
