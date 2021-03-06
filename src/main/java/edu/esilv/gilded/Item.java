package edu.esilv.gilded;


import java.time.LocalDateTime;

public class Item {

    public int quality;
    public String name;
    public int sellIn;
    int id;
    LocalDateTime date;
    LocalDateTime buy_date;
    LocalDateTime sell_date;

    public Item() {
    }

    public Item(String name, int sellIn, int quality, int id, LocalDateTime date) {
        super();
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
        this.id = id;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSellIn() {
        return sellIn;
    }

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDate() { return date; }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public LocalDateTime getBuy_date() { return buy_date; }

    public void setBuy_date(LocalDateTime buy_date) {
        this.date = buy_date;
    }

    public LocalDateTime getSell_date() { return sell_date; }

    public void setSell_date(LocalDateTime sell_date) {
        this.date = sell_date;
    }

    public void update() {
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", sellIn=" + sellIn +
                ", quality=" + quality +
                '}';
    }
}

