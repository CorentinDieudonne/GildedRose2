package edu.esilv.gilded.Items;

public class Ragnaros implements Strategy {
    private String name;
    private int quality;
    private int sellIn;
    Ragnaros(String name, int quality, int sellIn)
    {
        this.name=name;
        this.quality=quality;
        this.sellIn=sellIn;
    }
    @Override
    public void update(){
    }
}
