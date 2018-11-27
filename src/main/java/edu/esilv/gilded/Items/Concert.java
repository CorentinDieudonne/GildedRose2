package edu.esilv.gilded.Items;

public class Concert implements Strategy {
    private String name;
    private int quality;
    private int sellIn;
    Concert(String name, int quality, int sellIn)
    {
        this.name=name;
        this.quality=quality;
        this.sellIn=sellIn;
    }
    @Override
    public void update(){
        System.out.print("This is a Concert");
    }
}
